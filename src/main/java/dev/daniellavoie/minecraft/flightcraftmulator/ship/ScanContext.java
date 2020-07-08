package dev.daniellavoie.minecraft.flightcraftmulator.ship;

import java.util.HashSet;
import java.util.Set;

import dev.daniellavoie.minecraft.flightcraftmulator.forge.adapters.BlockSnapshotAdapter;
import net.minecraft.util.math.BlockPos;

public class ScanContext {
	private final Set<BlockPos> blocksToScan = new HashSet<>();
	private final Set<BlockSnapshotAdapter> connectedBlocks = new HashSet<>();
	private final Set<BlockPos> scannedBlocks = new HashSet<>();

	public ScanContext(Set<BlockSnapshotAdapter> existingConnectedBlocks, BlockPos initialBlockPosToScan) {
		this(initialBlockPosToScan);

		connectedBlocks.addAll(existingConnectedBlocks);
	}

	public ScanContext(BlockPos initialBlockPosToScan) {
		blocksToScan.add(initialBlockPosToScan);
	}

	public void addBlockToScan(BlockPos blockPos) {
		blocksToScan.add(blockPos);
	}

	public boolean isBlocksToScanEmpty() {
		return blocksToScan.isEmpty();
	}

	public void connectBlock(BlockSnapshotAdapter blockState) {
		connectedBlocks.add(blockState);
	}

	public Set<BlockSnapshotAdapter> getConnectedBlocks() {
		return connectedBlocks;
	}

	public Set<BlockPos> getScannedBlocks() {
		return scannedBlocks;
	}

	public boolean isScanned(BlockPos blockPos) {
		return scannedBlocks.contains(blockPos);
	}

	public void markBlockAsScanned(BlockPos blockPos) {
		scannedBlocks.add(blockPos);
	}

	public BlockPos pickBlockToScan() {
		BlockPos blockPos = blocksToScan.iterator().next();

		blocksToScan.remove(blockPos);

		return blockPos;
	}
}
