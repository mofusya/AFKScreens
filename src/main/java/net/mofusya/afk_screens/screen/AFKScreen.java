package net.mofusya.afk_screens.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.mofusya.afk_screens.config.ClientConfig;

@OnlyIn(Dist.CLIENT)
public class AFKScreen extends Screen {
    public AFKScreen() {
        super(Component.translatable("screen.afk_screens.afk_screen"));
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        super.render(guiGraphics, mouseX, mouseY, delta);

        String configMessage = ClientConfig.AFK_MESSAGE.get();
        int configColor = ClientConfig.AFK_MESSAGE_COLOR.get();
        double configSize = ClientConfig.AFK_MESSAGE_SIZE.get();

        var message = configMessage.equals(ClientConfig.AFK_MESSAGE.getDefault()) ? Component.translatable("screen.afk_screens.afk_screen.message") : Component.literal(configMessage);

        guiGraphics.pose().pushPose();
        guiGraphics.pose().scale((float) configSize, (float) configSize, (float) configSize);
        guiGraphics.drawCenteredString(this.font, message, (int) ((float) this.width / 2 / (float) configSize), (int) (64 / (float) configSize), configColor);
        guiGraphics.pose().popPose();
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
