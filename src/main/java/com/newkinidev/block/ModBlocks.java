package com.newkinidev.block;

import com.newkinidev.support_block.SupportBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import com.newkinidev.MineLife;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block TEMP_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).sounds(BlockSoundGroup.STONE));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(TEMP_BLOCK);
        entries.add(MineLife.SUPPORT_BLOCK);
    }

    private static void registerBlockItem(){
        Registry.register(Registries.ITEM, new Identifier(MineLife.MOD_ID, "temp_block"), new BlockItem(TEMP_BLOCK, new FabricItemSettings()));
    }

    private static void registerBlock(){
        Registry.register(Registries.BLOCK, new Identifier(MineLife.MOD_ID, "temp_block"), TEMP_BLOCK);
    }

    public static void registerModBlocks() {
        MineLife.LOGGER.info("Registering Mod Blocks for " + MineLife.MOD_ID);

        registerBlock();
        registerBlockItem();

        ItemGroupEvents.modifyEntriesEvent(ModBlockGroup.ITEM_GROUP_KEY).register(ModBlocks::addItemsToIngredientItemGroup);
    }
}
