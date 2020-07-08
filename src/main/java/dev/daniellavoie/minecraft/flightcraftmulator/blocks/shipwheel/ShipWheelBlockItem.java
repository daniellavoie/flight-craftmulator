package dev.daniellavoie.minecraft.flightcraftmulator.blocks.shipwheel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ShipWheelBlockItem extends BlockItem {

	private static final Logger LOGGER = LogManager.getLogger();
	public static final String ID = "ship_wheel";

	public ShipWheelBlockItem(Block blockIn) {
		super(blockIn, (new Item.Properties()).maxStackSize(1).group(ItemGroup.TRANSPORTATION));
		LOGGER.info("ShipWheel Block item created");
	}
}
