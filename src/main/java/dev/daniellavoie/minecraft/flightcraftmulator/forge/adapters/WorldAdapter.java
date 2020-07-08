package dev.daniellavoie.minecraft.flightcraftmulator.forge.adapters;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.util.BlockSnapshot;

public interface WorldAdapter {
	default BlockSnapshotAdapter getBlockSnapshot(BlockPos pos, IWorld world) {
		return new BlockSnapshotImpl(pos, BlockSnapshot.getBlockSnapshot(world, pos).getCurrentBlock().getBlock());
	}
}
