package com.jnizio.prideslegacy;

import com.jnizio.prideslegacy.registry.ModEntityTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(PridesLegacyMod.MOD_ID)
public class PridesLegacyMod {

    public static final String MOD_ID = "prideslegacy";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public PridesLegacyMod(IEventBus modEventBus) {
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        LOGGER.info("Pride's Legacy is loading");
    }
}
