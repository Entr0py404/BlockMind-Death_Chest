
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.blockmind.deathchest.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.blockmind.deathchest.BlockmindDeathChestMod;

public class BlockmindDeathChestModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BlockmindDeathChestMod.MODID);
	public static final RegistryObject<Item> DEATH_CHEST = block(BlockmindDeathChestModBlocks.DEATH_CHEST, CreativeModeTab.TAB_BUILDING_BLOCKS);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
