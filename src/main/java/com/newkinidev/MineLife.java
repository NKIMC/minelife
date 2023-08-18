package com.newkinidev;

import com.newkinidev.block.*;
import com.newkinidev.item.ModItemGroup;
import com.newkinidev.item.ModItems;
import com.newkinidev.support_block.SupportBlock;
import com.newkinidev.support_block.SupportBlockEntity;
import com.newkinidev.support_block.BoxScreenHandler;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MineLife implements ModInitializer {

	public static final Block SUPPORT_BLOCK;
	public static final BlockItem SUPPORT_BLOCK_ITEM;
	public static final BlockEntityType<SupportBlockEntity> SUPPORT_BLOCK_ENTITY;

	public static final String MOD_ID = "minelife";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Identifier BOX = new Identifier(MOD_ID, "support_block");

	public static final ScreenHandlerType<BoxScreenHandler> BOX_SCREEN_HANDLER;

	static {
		SUPPORT_BLOCK = Registry.register(Registries.BLOCK, BOX, new SupportBlock(FabricBlockSettings.copyOf(Blocks.CHEST)));
		SUPPORT_BLOCK_ITEM = Registry.register(Registries.ITEM, BOX, new BlockItem(SUPPORT_BLOCK, new Item.Settings()));

		SUPPORT_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, BOX, FabricBlockEntityTypeBuilder.create(SupportBlockEntity::new, SUPPORT_BLOCK).build(null));

		BOX_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(BOX, BoxScreenHandler::new);
	}

	@Override
	public void onInitialize() {
		ModItemGroup.registerModGroups();
		ModBlockGroup.registerModGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}