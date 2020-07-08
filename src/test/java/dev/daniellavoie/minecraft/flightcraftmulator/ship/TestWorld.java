package dev.daniellavoie.minecraft.flightcraftmulator.ship;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import dev.daniellavoie.minecraft.flightcraftmulator.forge.adapters.BlockSnapshotAdapter;
import dev.daniellavoie.minecraft.flightcraftmulator.forge.adapters.WorldAdapter;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class TestWorld implements WorldAdapter {
	private final Map<BlockPos, BlockSnapshotAdapter> blockSnapshotsByPos;

	public TestWorld(Set<BlockSnapshotAdapter> blockSnapshots) {
		this.blockSnapshotsByPos = blockSnapshots.stream()
				.collect(Collectors.toMap(BlockSnapshotAdapter::getPos, blockSnapshot -> blockSnapshot));
	}

	public BlockSnapshotAdapter addBlock(BlockSnapshotAdapter blockSnapshot) {
		return blockSnapshotsByPos.put(blockSnapshot.getPos(), blockSnapshot);
	}

	public BlockSnapshotAdapter removeBlock(BlockSnapshotAdapter blockSnapshot) {
		return blockSnapshotsByPos.remove(blockSnapshot.getPos());
	}

	@Override
	public BlockSnapshotAdapter getBlockSnapshot(BlockPos pos, IWorld world) {
		return blockSnapshotsByPos.get(pos);
	}
}
