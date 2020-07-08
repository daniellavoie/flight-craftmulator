package dev.daniellavoie.minecraft.flightcraftmulator.forge.listners;

import dev.daniellavoie.minecraft.flightcraftmulator.forge.adapters.BlockSnapshotAdapter;
import dev.daniellavoie.minecraft.flightcraftmulator.forge.adapters.BlockSnapshotImpl;
import dev.daniellavoie.minecraft.flightcraftmulator.forge.adapters.WorldAdapter;
import dev.daniellavoie.minecraft.flightcraftmulator.forge.resources.TagResources;
import dev.daniellavoie.minecraft.flightcraftmulator.ship.ShipService;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.world.BlockEvent.EntityPlaceEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntityPlaceEventListener {
	private final ShipService shipService;
	private final WorldAdapter worldAdapter;

	public EntityPlaceEventListener(ShipService shipService, WorldAdapter worldAdapter) {
		this.shipService = shipService;
		this.worldAdapter = worldAdapter;
	}

	@SubscribeEvent
	public void onEntityPlaceEvent(EntityPlaceEvent event) {
		Block block = event.getBlockSnapshot().getCurrentBlock().getBlock();
		BlockSnapshotAdapter blockSnapshot = new BlockSnapshotImpl(event.getBlockSnapshot().getPos(),
				event.getBlockSnapshot().getCurrentBlock().getBlock());

		if (TagResources.isShipWheel(block) && !isShipWheelConnectingToExistingShip(event)) {
			shipService.createNewShip(blockSnapshot, event.getWorld());
		} else if (TagResources.isShipPart(block)) {
			shipService.addBlockToExistingShipIfNeeded(blockSnapshot, event.getWorld());
		}
	}

	private boolean isShipWheelConnectingToExistingShip(EntityPlaceEvent event) {
		BlockPos downPos = event.getPos().down();

		return shipService.isBlockStatePartOfAShip(
				new BlockSnapshotImpl(downPos, worldAdapter.getBlockSnapshot(downPos, event.getWorld()).getBlock()));
	}
}
