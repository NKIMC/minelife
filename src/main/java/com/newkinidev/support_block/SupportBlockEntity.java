package com.newkinidev.support_block;

import com.newkinidev.MineLife;
import com.newkinidev.inventory.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class SupportBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);
    int progress = 0;

    public SupportBlockEntity(BlockPos pos, BlockState state) {
        super(MineLife.SUPPORT_BLOCK_ENTITY, pos, state);
    }


    //From the ImplementedInventory Interface

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    //These Methods are from the NamedScreenHandlerFactory Interface
    //createMenu creates the ScreenHandler itself
    //getDisplayName will Provide its name which is normally shown at the top

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        //We provide *this* to the screenHandler as our class Implements Inventory
        //Only the Server has the Inventory at the start, this will be synced to the client in the ScreenHandler

        return new BoxScreenHandler(syncId, playerInventory, this, new PropertyDelegate() {
            public int get(int index) {
                return progress;
            }

            public void set(int index, int value) {
                progress = value;
            }

            public int size() {
                return 1;
            }
        });
    }

    @Override
    public Text getDisplayName() {
        // for 1.19+
        return Text.empty();
        // for earlier versions
        // return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, this.inventory);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, this.inventory);
    }
}


