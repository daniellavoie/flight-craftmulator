package dev.daniellavoie.minecraft.flightcraftmulator.forge.registers;

import static dev.daniellavoie.minecraft.flightcraftmulator.forge.FlightCraftmulatorMod.MOD_ID;

import dev.daniellavoie.minecraft.flightcraftmulator.blocks.shipwheel.ShipWheelBlock;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegister {
	public static final DeferredRegister<Block> REGISTER = new DeferredRegister<>(ForgeRegistries.BLOCKS, MOD_ID);
	
	public static final RegistryObject<Block> SHIP_WHEEL_BLOCK = REGISTER.register(ShipWheelBlock.ID,
			() -> new ShipWheelBlock());
}
