# Circle of Craft: Pride's Legacy

A NeoForge 1.21.1 add-on for **Circle of Craft**, focused on a Lion King II-inspired continuation.

## Current milestone

**Milestone 0 — Kovu vertical slice**

- Load as a separate mod alongside Circle of Craft.
- Register a `prideslegacy:kovu` entity.
- Reuse Circle of Craft's existing lion mesh and Scar texture *by resource reference* for the first prototype (no copied asset files).
- Keep Kovu male and persistent enough for testing.
- Spawn with `/summon prideslegacy:kovu`.
- Next: custom Kovu texture/model edits, dialogue, quest state, and Circle of Craft quest-chain integration.

## Target

- Minecraft 1.21.1
- NeoForge 21.1.x
- Circle of Craft 0.3.0+
- GeckoLib 4.8+
- Java 21

## Development dependency

For local development, copy your installed Circle of Craft jar into:

`libs/circleofcraft.jar`

The published add-on will declare Circle of Craft and GeckoLib as required runtime dependencies.

## License

Code in this repository is intended to be GPL-3.0-or-later so it can safely interoperate with/reuse GPL-covered Circle of Craft code where necessary. Disney/The Lion King names and characters remain the property of their respective rights holders; this is a non-commercial fan project.
