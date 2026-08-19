package com.jnizio.prideslegacy.client.renderer;

import com.jnizio.prideslegacy.PridesLegacyMod;
import com.jnizio.prideslegacy.entity.KovuEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import io.github.ron1196.circleofcraft.client.model.LionModel;
import io.github.ron1196.circleofcraft.client.renderer.AnimalRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class KovuRenderer extends AnimalRenderer<KovuEntity, LionModel<KovuEntity>> {

    private static final ResourceLocation TEXTURE = PridesLegacyMod.id("textures/entity/kovu.png");

    public KovuRenderer(EntityRendererProvider.Context context, LionModel<KovuEntity> model) {
        super(context, model, "lion", 0.62F, 0.75F);
    }

    @Override
    protected void scale(@NotNull KovuEntity entity, @NotNull PoseStack poseStack, float partialTick) {
        super.scale(entity, poseStack, partialTick);
        // Slightly younger/slimmer silhouette than Scar while staying in Circle of Craft's style.
        poseStack.scale(0.94F, 0.94F, 0.94F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull KovuEntity entity) {
        return TEXTURE;
    }
}
