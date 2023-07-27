package com.newkinidev.item;

import com.newkinidev.MineLife;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    // Define your custom ItemGroup
    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.MAGNIFIER))
            .displayName(Text.translatable("minelife.item"))
            .build();

    // Define the RegistryKey for your custom ItemGroup
    public static final RegistryKey<ItemGroup> ITEM_GROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MineLife.MOD_ID, "item"));

    private static void registerGroup() {
        // Register the custom ItemGroup with the defined RegistryKey
        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_KEY.getValue(), ITEM_GROUP);
    }

    public static void registerModGroups() {
        MineLife.LOGGER.info("Registering Mod Groups for " + MineLife.MOD_ID);
        registerGroup();
    }
}
