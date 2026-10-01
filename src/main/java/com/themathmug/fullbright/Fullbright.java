package com.themathmug.fullbright;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLPaths;

@Mod(Fullbright.MOD_ID)
public class Fullbright {
    public static final String MOD_ID = "fullbright";
    public static final String MOD_NAME = "Fullbright";

    private static boolean enabled = false;
    private static Double originalGamma = null;

    public Fullbright(ModContainer container) {
        // Intentionally left minimal; this mod does not require extra lifecycle setup.
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void toggle() {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft == null || minecraft.options == null) {
            return;
        }

        if (!enabled) {
            originalGamma = minecraft.options.gamma().get();
            minecraft.options.gamma().set(1.0D);
            enabled = true;
            if (minecraft.player != null) {
                minecraft.player.displayClientMessage(Component.literal("Fullbright: ON"), false);
            }
            return;
        }

        if (originalGamma != null) {
            minecraft.options.gamma().set(originalGamma);
        }
        enabled = false;
        originalGamma = null;
        if (minecraft.player != null) {
            minecraft.player.displayClientMessage(Component.literal("Fullbright: OFF"), false);
        }
    }

    public static void reset() {
        if (!enabled) {
            return;
        }

        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft == null || minecraft.options == null) {
            return;
        }

        if (originalGamma != null) {
            minecraft.options.gamma().set(originalGamma);
        }

        enabled = false;
        originalGamma = null;
    }
}
