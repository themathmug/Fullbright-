package com.themathmug.fullbright;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public final class Fullbright {
    public static final String MOD_ID = "fullbright";
    public static final String MOD_NAME = "Fullbright";

    private static boolean enabled = false;
    private static Double originalGamma = null;

    private Fullbright() {
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void toggle() {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft == null || minecraft.player == null || minecraft.options == null) {
            return;
        }

        if (!enabled) {
            originalGamma = minecraft.options.gamma().get();
            minecraft.options.gamma().set(1.0D);
            enabled = true;
            minecraft.player.displayClientMessage(Component.literal("Fullbright: ON"), false);
        } else {
            if (originalGamma != null) {
                minecraft.options.gamma().set(originalGamma);
            }
            enabled = false;
            originalGamma = null;
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
