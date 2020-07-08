package dev.daniellavoie.minecraft.flightcraftmulator.forge.resources;

import dev.daniellavoie.minecraft.flightcraftmulator.forge.FlightCraftmulatorMod;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;

public abstract class TagResources {
	private static final ResourceLocation SHIP_PART_TAG_RESOURCE = new ResourceLocation(FlightCraftmulatorMod.MOD_ID,
			"ship_part");
	private static final ResourceLocation SHIP_WHEEL_TAG_RESOURCE = new ResourceLocation(FlightCraftmulatorMod.MOD_ID,
			"ship_part");

	public static boolean isShipPart(Block block) {
		return isPartOfTag(block, SHIP_PART_TAG_RESOURCE);
	}

	public static boolean isShipWheel(Block block) {
		return isPartOfTag(block, SHIP_WHEEL_TAG_RESOURCE);
	}

	private static boolean isPartOfTag(Block block, ResourceLocation resourceLocation) {
		return BlockTags.getCollection().getOrCreate(resourceLocation).contains(block);
	}
}
