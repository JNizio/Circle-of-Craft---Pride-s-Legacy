package com.jnizio.prideslegacy.event;

import com.jnizio.prideslegacy.PridesLegacyMod;
import com.jnizio.prideslegacy.client.model.KovuModelLayers;
import com.jnizio.prideslegacy.client.renderer.KovuRenderer;
import com.jnizio.prideslegacy.registry.ModEntityTypes;
import io.github.ron1196.circleofcraft.client.model.LionModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = PridesLegacyMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents {

    private ClientEvents() {}

    public static final ModelLayerLocation KOVU_LAYER =
            new ModelLayerLocation(PridesLegacyMod.id("kovu"), "main");

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(KOVU_LAYER, KovuModelLayers::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(
                ModEntityTypes.KOVU.get(),
                ctx -> new KovuRenderer(ctx, new LionModel<>(ctx.bakeLayer(KOVU_LAYER))));
    }
}
