
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.blockmind.deathchest.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.blockmind.deathchest.block.entity.DeathChestBlockEntity;
import net.blockmind.deathchest.BlockmindDeathChestMod;

public class BlockmindDeathChestModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES,
			BlockmindDeathChestMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> DEATH_CHEST = register("death_chest", BlockmindDeathChestModBlocks.DEATH_CHEST,
			DeathChestBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
