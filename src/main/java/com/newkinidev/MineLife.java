package com.newkinidev;

import com.newkinidev.block.BoxBlock;
import com.newkinidev.block.ModBlockGroup;
import com.newkinidev.block.ModBlocks;
import com.newkinidev.item.ModItemGroup;
import com.newkinidev.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MineLife implements ModInitializer {

	public static final Block BOX_BLOCK;
	public static final BlockItem BOX_BLOCK_ITEM;
	public static final BlockEntityType<BoxBlockEntity> BOX_BLOCK_ENTITY;

	public static final String MOD_ID = "minelife";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Identifier BOX = new Identifier(MOD_ID, "box_block");

	static {
		BOX_BLOCK = Registry.register(Registries.BLOCK, BOX, new BoxBlock(FabricBlockSettings.copyOf(Blocks.CHEST)));
		BOX_BLOCK_ITEM = Registry.register(Registries.ITEM, BOX, new BlockItem(BOX_BLOCK, new Item.Settings()));

		//The parameter of build at the very end is always null, do not worry about it
		// pre-1.17
		BOX_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, BOX, BlockEntityType.Builder.create(BoxBlockEntity::new, BOX_BLOCK).build(null));
		// In 1.17 use FabricBlockEntityTypeBuilder instead of BlockEntityType.Builder
		BOX_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, BOX, FabricBlockEntityTypeBuilder.create(BoxBlockEntity::new, BOX_BLOCK).build(null));
	}

	@Override
	public void onInitialize() {
		ModItemGroup.registerModGroups();
		ModBlockGroup.registerModGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}