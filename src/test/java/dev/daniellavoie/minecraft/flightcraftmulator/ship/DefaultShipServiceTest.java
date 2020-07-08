package dev.daniellavoie.minecraft.flightcraftmulator.ship;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import dev.daniellavoie.minecraft.flightcraftmulator.forge.adapters.BlockSnapshotAdapter;
import dev.daniellavoie.minecraft.flightcraftmulator.forge.adapters.WorldAdapter;
import dev.daniellavoie.minecraft.flightcraftmulator.forge.adapters.WorldImpl;
import dev.daniellavoie.minecraft.flightcraftmulator.ship.repository.ShipMemoryRepository;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.util.BlockSnapshot;

public class DefaultShipServiceTest {

	@Test
	public void test() {
		WorldAdapter world = new WorldImpl(Mockito.mock(IWorld.class));
		ShipService shipService = new DefaultShipService(new ShipMemoryRepository());

		BlockSnapshot blockSnapshotMock = Mockito.mock(BlockSnapshot.class);
		BlockSnapshotAdapter shipWheelBlockSnapshot = new BlockSnapshotImpl(blockSnapshotMock);
		WorldAdapter world = new 

		shipService.createNewShip(shipWheelBlockSnapshot, world);
	}
}
