package net.mofusya.afk_screens;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.mofusya.afk_screens.config.ClientConfig;
import org.slf4j.Logger;

@Mod(AFKScreens.MOD_ID)
public class AFKScreens
{
    public static final String MOD_ID = "afk_screens";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AFKScreens()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC, MOD_ID + "/client.toml");

        MinecraftForge.EVENT_BUS.register(this);
    }
}
