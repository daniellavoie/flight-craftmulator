package dev.daniellavoie.minecraft.flightcraftmulator.ship;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dev.daniellavoie.minecraft.flightcraftmulator.entities.Ship;
import dev.daniellavoie.minecraft.flightcraftmulator.forge.adapters.BlockSnapshotAdapter;
import dev.daniellavoie.minecraft.flightcraftmulator.forge.adapters.WorldAdapter;
import dev.daniellavoie.minecraft.flightcraftmulator.forge.resources.TagResources;
import dev.daniellavoie.minecraft.flightcraftmulator.ship.repository.ShipRepository;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class DefaultShipService implements ShipService {
	private final ShipRepository shipRepository;
	private final WorldAdapter world;

	public DefaultShipService(ShipRepository shipRepository, WorldAdapter world) {
		this.shipRepository = shipRepository;
		this.world = world;
	}

	private void addBlockToExistingShip(BlockSnapshotAdapter shipWheelBlock, Ship ship, IWorld world) {
		scanShip(world, new ScanContext(ship.getBlocks(), shipWheelBlock.getPos()));
	}

	@Override
	public void addBlockToExistingShipIfNeeded(BlockSnapshotAdapter shipWheelblockSnapshot, IWorld world) {
		List<Ship> connectedShips = shipRepository.getShips()
				.filter(ship -> isBlockInContactWithShip(shipWheelblockSnapshot, ship, world))
				.collect(Collectors.toList());

		if (connectedShips.size() == 0) {
			return;
		}

		addBlockToExistingShip(shipWheelblockSnapshot,
				connectedShips.size() == 1 ? connectedShips.get(0) : mergeShips(connectedShips), world);
	}

	@Override
	public void createNewShip(BlockSnapshotAdapter shipWheelblockSnapshot, IWorld world) {
		ScanContext scanContext = new ScanContext(shipWheelblockSnapshot.getPos().down());

		scanShip(world, scanContext);
	}

	private boolean isBlockInContactWithOtherBlock(BlockSnapshotAdapter blockSnapshot1,
			BlockSnapshotAdapter blockSnapshot2) {
		return Stream
				.of(blockSnapshot1.getPos().getX() == blockSnapshot2.getPos().getX(),
						blockSnapshot1.getPos().getY() == blockSnapshot2.getPos().getY(),
						blockSnapshot1.getPos().getZ() == blockSnapshot2.getPos().getZ())
				.filter(bool -> bool.booleanValue()).collect(Collectors.toList()).size() == 2;
	}

	private boolean isBlockInContactWithShip(BlockSnapshotAdapter blockSnapshot, Ship ship, IWorld world) {
		return ship.getBlocks().stream().filter(shipBlock -> isBlockInContactWithOtherBlock(blockSnapshot, shipBlock))
				.findAny().isPresent();
	}

	private Stream<BlockPos> getAdjacentPos(BlockPos blockPos, ScanContext scanContext) {
		return Stream.of(blockPos.north(), blockPos.east(), blockPos.west(), blockPos.south(), blockPos.down(),
				blockPos.up()).filter(adjacentBlockPos -> scanContext.isScanned(adjacentBlockPos));
	}

	@Override
	public boolean isBlockStatePartOfAShip(BlockSnapshotAdapter blockSnapshot) {
		return shipRepository.getShips().filter(ship -> ship.getBlocks().contains(blockSnapshot)).findAny().isPresent();
	}

	private Ship mergeShips(List<Ship> connectedShips) {
		connectedShips.forEach(shipRepository::removeShip);

		return new Ship(connectedShips.stream().flatMap(ship -> ship.getBlocks().stream()).collect(Collectors.toSet()));
	}

	private boolean scanBlockPos(BlockPos blockPos, IWorld world, ScanContext scanContext) {
		if (scanContext.isScanned(blockPos)) {
			return false;
		}

		scanContext.markBlockAsScanned(blockPos);

		BlockSnapshotAdapter blockSnapshot = this.world.getBlockSnapshot(blockPos, world);

		if (!TagResources.isShipPart(blockSnapshot.getBlock())) {
			return false;
		}

		scanContext.connectBlock(blockSnapshot);

		return true;
	}

	private void scanShip(IWorld world, ScanContext scanContext) {
		do {
			BlockPos blockPos = scanContext.pickBlockToScan();

			if (scanBlockPos(blockPos, world, scanContext)) {
				getAdjacentPos(blockPos, scanContext).forEach(scanContext::addBlockToScan);
			}
		} while (!scanContext.isBlocksToScanEmpty());
	}
}
