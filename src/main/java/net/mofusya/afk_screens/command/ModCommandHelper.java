package net.mofusya.afk_screens.command;

import net.minecraft.ChatFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;
import net.mofusya.afk_screens.config.ClientConfig;

@OnlyIn(Dist.CLIENT)
class ModCommandHelper {
    static void setMessage(String message) {
        if (message == null) return;

        ClientConfig.AFK_MESSAGE.set(message);
    }

    static void setMessageColor(ChatFormatting color) {
        if (color == null) return;
        Integer colorInt = color.getColor();
        if (colorInt == null) return;

        ClientConfig.AFK_MESSAGE_COLOR.set(colorInt);
    }

    static void setMessageSize(double size) {
        ClientConfig.AFK_MESSAGE_SIZE.set(size);
    }

    static void reset() {
        ClientConfig.AFK_MESSAGE.set(ClientConfig.AFK_MESSAGE.getDefault());
        ClientConfig.AFK_MESSAGE_COLOR.set(ClientConfig.AFK_MESSAGE_COLOR.getDefault());
        ClientConfig.AFK_MESSAGE_SIZE.set(ClientConfig.AFK_MESSAGE_SIZE.getDefault());
    }
}
