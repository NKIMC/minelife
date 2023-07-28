package com.newkinidev;

import com.newkinidev.block.ModBlockGroup;
import com.newkinidev.block.ModBlocks;
import com.newkinidev.item.ModItemGroup;
import com.newkinidev.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MineLife implements ModInitializer {
	public static final String MOD_ID = "minelife";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerModGroups();
		ModBlockGroup.registerModGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}