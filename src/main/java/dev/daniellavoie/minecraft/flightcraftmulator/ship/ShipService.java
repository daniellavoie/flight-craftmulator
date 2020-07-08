package dev.daniellavoie.minecraft.flightcraftmulator.ship;

import dev.daniellavoie.minecraft.flightcraftmulator.forge.adapters.BlockSnapshotAdapter;
import net.minecraft.world.IWorld;

public interface ShipService {
	void addBlockToExistingShipIfNeeded(BlockSnapshotAdapter blockSnapshot, IWorld world);

	void createNewShip(BlockSnapshotAdapter shipWheelBlockSnapshot, IWorld world);

	boolean isBlockStatePartOfAShip(BlockSnapshotAdapter blockSnapshot);
}
