# Fullbright

A lightweight client-side NeoForge mod for Minecraft 1.21.1 that adds a Fullbright toggle keybind.

## Features

- Default keybind: G
- Toggle Fullbright on/off without opening a GUI
- Client-only rendering change; no server installation required
- Restores the original gamma/brightness setting when disabled
- Small client-side chat message notifications
- Keybind appears in Minecraft Controls

## Build

From the project root:

```bash
gradle build
```

If you have the Gradle wrapper set up later, you can use:

```bash
./gradlew build
```

## Resulting jar

The built mod jar is placed in:

```text
build/libs/fullbright-1.0.0.jar
```

## Install

1. Build the mod with Gradle.
2. Copy the generated jar from `build/libs/` into your NeoForge 1.21.1 client `mods` folder.
3. Start the NeoForge 1.21.1 client and press G to toggle Fullbright.
4. You can rebind the key in `Options -> Controls`.

## Implementation notes

This mod is intentionally client-side only. It does not alter world data or block lighting. Instead, it temporarily adjusts the local client's gamma value while the player is in a world and restores the original value when turned off.

## Version compatibility notes

- This project targets NeoForge 1.21.1 specifically.
- The API usage is kept intentionally simple so that nearby versions may need only minimal edits.
- If a future version changes the `gamma()` or key registration APIs, the likely changes are limited to the exact event registration and the brightness option accessors.
- The mod is not claimed to work on other Minecraft versions unless explicitly verified.
