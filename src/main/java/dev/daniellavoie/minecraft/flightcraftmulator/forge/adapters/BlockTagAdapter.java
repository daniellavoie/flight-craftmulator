package dev.daniellavoie.minecraft.flightcraftmulator.forge.adapters;

import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public interface BlockTagAdapter {
	default Tag<T> getOrCreate(ResourceLocation resourceLocationIn) {
		
	}
}
