package dev.daniellavoie.minecraft.flightcraftmulator.forge.adapters;

import net.minecraft.block.Block;

public class BlockStateImpl implements BlockStateAdapter {
	private final Block block;
	
	public BlockStateImpl(Block block) {
		this.block = block;
	}
	
	@Override
	public Block getBlock() {
		return block;
	}

}
