package net.mofusya.afk_screens.command;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.ColorArgument;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mofusya.afk_screens.AFKScreens;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ModCommands {

    @SubscribeEvent
    public static void register(RegisterClientCommandsEvent event) {
        event.getDispatcher().register(Commands.literal(AFKScreens.MOD_ID)
                .then(Commands.literal("set_message")
                        .then(Commands.argument("message", StringArgumentType.string()).executes(arguments -> {
                                    String message = arguments.getArgument("message", String.class);
                                    ModCommandHelper.setMessage(message);
                                    return 0;
                                })
                        )
                )
                .then(Commands.literal("set_message_color")
                        .then(Commands.argument("color", ColorArgument.color()).executes(arguments -> {
                                    ChatFormatting color = arguments.getArgument("color", ChatFormatting.class);
                                    ModCommandHelper.setMessageColor(color);
                                    return 0;
                                })
                        )
                )
                .then(Commands.literal("set_message_size")
                        .then(Commands.argument("size", DoubleArgumentType.doubleArg(0.0)).executes(arguments -> {
                                    double size = arguments.getArgument("size", Double.class);
                                    ModCommandHelper.setMessageSize(size);
                                    return 0;
                                })
                        )
                )
                .then(Commands.literal("reset")
                        .executes(arguments -> {
                            ModCommandHelper.reset();
                            return 0;
                        })
                )
        );
    }
}
