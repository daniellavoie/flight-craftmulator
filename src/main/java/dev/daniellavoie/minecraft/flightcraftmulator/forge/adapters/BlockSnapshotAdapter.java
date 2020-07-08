package dev.daniellavoie.minecraft.flightcraftmulator.forge.adapters;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;

public interface BlockSnapshotAdapter {
	BlockPos getPos();
	
	Block getBlock();
}
