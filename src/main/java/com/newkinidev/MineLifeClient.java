package com.newkinidev;

import com.newkinidev.support_block.BoxScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class MineLifeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(MineLife.BOX_SCREEN_HANDLER, BoxScreen::new);
    }
}
