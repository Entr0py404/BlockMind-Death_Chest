package net.blockmind.deathchest.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.blockmind.deathchest.init.BlockmindDeathChestModGameRules;
import net.blockmind.deathchest.init.BlockmindDeathChestModBlocks;

import javax.annotation.Nullable;

import java.util.concurrent.atomic.AtomicReference;

@Mod.EventBusSubscriber
public class BeforePlayerDiesProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(),
					event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		execute(null, world, x, y, z, entity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		if (entity == null)
			return;
		double LoopIndex = 0;
		if (world.getLevelData().getGameRules().getBoolean(BlockmindDeathChestModGameRules.DISABLEDEATHCHEST) == false) {
			if (!world.isClientSide()) {
				if (entity instanceof Player) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - amount <= 0) {
						world.setBlock(new BlockPos(x, y, z), BlockmindDeathChestModBlocks.DEATH_CHEST.get().defaultBlockState(), 3);
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putString("Owner", (entity.getDisplayName().getString()));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						LoopIndex = 0;
						{
							AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
							entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _iitemhandlerref.set(capability));
							if (_iitemhandlerref.get() != null) {
								for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
									ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
									{
										BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
										if (_ent != null) {
											final int _slotid = (int) LoopIndex;
											final ItemStack _setstack = itemstackiterator;
											_setstack.setCount((itemstackiterator).getCount());
											_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
												if (capability instanceof IItemHandlerModifiable)
													((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
											});
										}
									}
									LoopIndex = LoopIndex + 1;
								}
							}
						}
						if (entity instanceof Player _player)
							_player.getInventory().clearContent();
					}
				}
			}
		}
	}
}
