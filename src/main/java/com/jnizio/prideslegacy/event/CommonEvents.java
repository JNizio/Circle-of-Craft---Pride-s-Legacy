package com.jnizio.prideslegacy.event;

import com.jnizio.prideslegacy.PridesLegacyMod;
import com.jnizio.prideslegacy.entity.KovuEntity;
import com.jnizio.prideslegacy.registry.ModEntityTypes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = PridesLegacyMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class CommonEvents {

    private CommonEvents() {}

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.KOVU.get(), KovuEntity.createAttributes().build());
    }
}
