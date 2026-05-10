package net.mofusya.afk_screens.key;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mofusya.afk_screens.AFKScreens;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = AFKScreens.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModKeyMappings {

    public static final ArrayList<KeyMapping> keys = new ArrayList<>();

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
        create(event, "open_screen", KeyEvent.VK_U);
    }

    private static void create(RegisterKeyMappingsEvent event, String name, int key) {
        var keyMap = new KeyMapping("key." + AFKScreens.MOD_ID + "." + name, key, "key.categories." + AFKScreens.MOD_ID);
        keys.add(keyMap);
        event.register(keyMap);
    }

    public static KeyMapping get(int key){
        return keys.get(key);
    }
}
