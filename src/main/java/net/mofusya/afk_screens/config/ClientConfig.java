package net.mofusya.afk_screens.config;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import net.mofusya.afk_screens.AFKScreens;

@OnlyIn(Dist.CLIENT)
public class ClientConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<String> AFK_MESSAGE;
    public static final ForgeConfigSpec.ConfigValue<Integer> AFK_MESSAGE_COLOR;
    public static final ForgeConfigSpec.ConfigValue<Double> AFK_MESSAGE_SIZE;

    static {
        BUILDER.push(AFKScreens.MOD_ID);

        AFK_MESSAGE = BUILDER.comment("[default:\\\\null\\\\]").define("afk_message", "\\null\\");
        AFK_MESSAGE_COLOR = BUILDER.comment("[default:0xFFFFFF}").define("afk_message_color", 0xFFFFFF);
        AFK_MESSAGE_SIZE = BUILDER.comment("[default:1.0]").define("afk_message_size", 1.0);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
