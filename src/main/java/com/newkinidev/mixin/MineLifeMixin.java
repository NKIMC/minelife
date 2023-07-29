// 해당 코드는 최신 버전 기준으로 작성된 것이며, 실제 버전과 일치하는지 확인해야 합니다.

package com.newkinidev.mixin;

import net.minecraft.client.gui.InGameGui;
import net.minecraft.client.gui.ResourceLoadProgressGui;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.StringTextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameGui.class)
public class MineLifeMixin {
	@Inject(at = @At("TAIL"), method = "render(F)V")
	private void moveLoadingBar(Screen screen, float partialTicks, CallbackInfo info) {
		if (screen instanceof ResourceLoadProgressGui) {
			ResourceLoadProgressGui loadGui = (ResourceLoadProgressGui) screen;
			int x = loadGui.width - 100; // 로딩 바를 오른쪽으로 이동시킬 x 좌표
			int y = loadGui.height - 12; // 로딩 바를 아래쪽으로 이동시킬 y 좌표

			StringTextComponent text = new StringTextComponent("Custom Loading Text"); // 로딩 바 아래에 추가로 표시할 텍스트
			this.minecraft.font.draw(text, x + 2, y + 2, 0xFFFFFF); // 추가로 표시할 텍스트 그리기
		}
	}
}
