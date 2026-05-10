package net.mofusya.afk_screens.event;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mofusya.afk_screens.key.ModKeyMappings;
import net.mofusya.afk_screens.screen.AFKScreen;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class OpenAFKScreen {

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (ModKeyMappings.get(0).consumeClick()) {
            Minecraft.getInstance().setScreen(new AFKScreen());
        }
    }
}