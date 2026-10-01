# Fullbright

A lightweight client-side mod for NeoForge 1.21.1 that adds a Fullbright toggle keybind.

## Features
- Toggle Fullbright with the G key by default
- Key appears in Minecraft Controls
- Client-only; no server install required
- Restores gamma exactly when toggled off
- Small client-side notifications (`Fullbright: ON` / `Fullbright: OFF`)

## Build locally

From the project root:

```bash
gradle build
```

If you use the Gradle wrapper after generating it locally, use:

```bash
./gradlew build
```

## Output jar

The generated jar is normally placed in:

```text
build/libs/fullbright-1.0.0.jar
```

## Install

1. Place the built jar in your NeoForge 1.21.1 client `mods` folder.
2. Launch the game.
3. Press G to toggle Fullbright.
4. Rebind the key in `Options -> Controls` if desired.

## Version notes

- Targeting NeoForge 1.21.1 only.
- The implementation uses the standard client gamma option, which is the simplest reliable client-side brightness change.
- Nearby versions may need small API adjustments, especially around key registration and the exact gamma option accessors.
