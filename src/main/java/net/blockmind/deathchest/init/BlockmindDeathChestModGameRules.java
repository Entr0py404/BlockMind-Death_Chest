
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.blockmind.deathchest.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockmindDeathChestModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> DISABLEDEATHCHEST = GameRules.register("disableDeathChest", GameRules.Category.PLAYER,
			GameRules.BooleanValue.create(false));
}
