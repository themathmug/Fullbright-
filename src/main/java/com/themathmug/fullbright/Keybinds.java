package com.themathmug.fullbright;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.event.TickEvent;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = Fullbright.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class Keybinds {
    public static final KeyMapping TOGGLE_FULLBRIGHT = new KeyMapping(
            "key.fullbright.toggle",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            "key.categories.misc"
    );

    private Keybinds() {
    }

    @SubscribeEvent
    public static void register(RegisterKeyMappingsEvent event) {
        event.register(TOGGLE_FULLBRIGHT);
    }
}

@Mod.EventBusSubscriber(modid = Fullbright.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
final class ClientInputHandler {
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }

        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) {
            Fullbright.reset();
            return;
        }

        if (Keybinds.TOGGLE_FULLBRIGHT.consumeClick()) {
            Fullbright.toggle();
        }
    }
}
