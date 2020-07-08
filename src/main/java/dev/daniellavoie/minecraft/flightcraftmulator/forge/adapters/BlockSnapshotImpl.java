package dev.daniellavoie.minecraft.flightcraftmulator.forge.adapters;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;

public class BlockSnapshotImpl implements BlockSnapshotAdapter {
	private final BlockPos pos;
	private final Block block;

	public BlockSnapshotImpl(BlockPos pos, Block block) {
		this.pos = pos;
		this.block = block;
	}

	@Override
	public BlockPos getPos() {
		return pos;
	}

	@Override
	public Block getBlock() {
		return block;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((block == null) ? 0 : block.hashCode());
		result = prime * result + ((pos == null) ? 0 : pos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlockSnapshotImpl other = (BlockSnapshotImpl) obj;
		if (block == null) {
			if (other.block != null)
				return false;
		} else if (!block.equals(other.block))
			return false;
		if (pos == null) {
			if (other.pos != null)
				return false;
		} else if (!pos.equals(other.pos))
			return false;
		return true;
	}
}
