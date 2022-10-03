
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.blockmind.deathchest.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.blockmind.deathchest.block.DeathChestBlock;
import net.blockmind.deathchest.BlockmindDeathChestMod;

public class BlockmindDeathChestModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, BlockmindDeathChestMod.MODID);
	public static final RegistryObject<Block> DEATH_CHEST = REGISTRY.register("death_chest", () -> new DeathChestBlock());
}
