package dev.daniellavoie.minecraft.flightcraftmulator.entities;

import java.util.HashSet;
import java.util.Set;

import dev.daniellavoie.minecraft.flightcraftmulator.forge.adapters.BlockSnapshotAdapter;

public class Ship {
	private final Set<BlockSnapshotAdapter> blocks = new HashSet<>();

	public Ship(Set<BlockSnapshotAdapter> blocks) {
		this.blocks.addAll(blocks);
	}

	public Set<BlockSnapshotAdapter> getBlocks() {
		return blocks;
	}

	public void refreshBlocks(Set<BlockSnapshotAdapter> blocks) {
		this.blocks.clear();
		this.blocks.addAll(blocks);
	}
}
