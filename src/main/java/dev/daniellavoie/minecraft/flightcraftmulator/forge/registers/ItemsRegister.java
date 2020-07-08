package dev.daniellavoie.minecraft.flightcraftmulator.forge.registers;

import static dev.daniellavoie.minecraft.flightcraftmulator.forge.FlightCraftmulatorMod.MOD_ID;

import dev.daniellavoie.minecraft.flightcraftmulator.blocks.shipwheel.ShipWheelBlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemsRegister {
	public static final DeferredRegister<Item> REGISTER = new DeferredRegister<>(ForgeRegistries.ITEMS, MOD_ID);

	public static final RegistryObject<Item> SHIP_WHEEL_ITEM = REGISTER.register(ShipWheelBlockItem.ID,
			() -> new ShipWheelBlockItem(BlockRegister.SHIP_WHEEL_BLOCK.get()));
}
