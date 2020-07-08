package dev.daniellavoie.minecraft.flightcraftmulator.forge;

import static dev.daniellavoie.minecraft.flightcraftmulator.forge.FlightCraftmulatorMod.MOD_ID;

import dev.daniellavoie.minecraft.flightcraftmulator.forge.adapters.WorldAdapter;
import dev.daniellavoie.minecraft.flightcraftmulator.forge.adapters.WorldImpl;
import dev.daniellavoie.minecraft.flightcraftmulator.forge.listners.EntityPlaceEventListener;
import dev.daniellavoie.minecraft.flightcraftmulator.forge.registers.BlockRegister;
import dev.daniellavoie.minecraft.flightcraftmulator.forge.registers.ItemsRegister;
import dev.daniellavoie.minecraft.flightcraftmulator.ship.DefaultShipService;
import dev.daniellavoie.minecraft.flightcraftmulator.ship.repository.ShipMemoryRepository;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MOD_ID)
public class FlightCraftmulatorMod {
	public static final String MOD_ID = "flightcraftmulator";

	public FlightCraftmulatorMod() {
		BlockRegister.REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
		ItemsRegister.REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());

		WorldAdapter world = new WorldImpl();

		MinecraftForge.EVENT_BUS.register(
				new EntityPlaceEventListener(new DefaultShipService(new ShipMemoryRepository(), world), world));
	}
}
