package com.newkinidev.item;

import com.newkinidev.MineLife;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item MAGNIFIER = new Item(new FabricItemSettings());

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(MAGNIFIER);
    }

    private static void registerItem() {
        Registry.register(Registries.ITEM, new Identifier(MineLife.MOD_ID,"magnifier"), MAGNIFIER);
    }

    public static void registerModItems() {
        MineLife.LOGGER.info("Registering Mod Items for " + MineLife.MOD_ID);
        registerItem();
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToIngredientItemGroup);
    }
}