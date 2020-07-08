package dev.daniellavoie.minecraft.flightcraftmulator.ship.repository;

import java.util.Set;
import java.util.stream.Stream;

import dev.daniellavoie.minecraft.flightcraftmulator.entities.Ship;

public class ShipMemoryRepository implements ShipRepository {
	private Set<Ship> ships;

	@Override
	public Stream<Ship> getShips() {
		return ships.stream();
	}

	@Override
	public void removeShip(Ship ship) {
		ships.remove(ship);
	}

	@Override
	public void addShip(Ship ship) {
		ships.add(ship);
	}
}