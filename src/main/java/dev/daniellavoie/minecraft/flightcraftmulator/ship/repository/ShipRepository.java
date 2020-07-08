package dev.daniellavoie.minecraft.flightcraftmulator.ship.repository;

import java.util.stream.Stream;

import dev.daniellavoie.minecraft.flightcraftmulator.entities.Ship;

public interface ShipRepository {
	Stream<Ship> getShips();

	void removeShip(Ship ship);

	void addShip(Ship ship);
}
