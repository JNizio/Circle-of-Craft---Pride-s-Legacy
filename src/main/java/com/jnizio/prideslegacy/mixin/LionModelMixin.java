package com.jnizio.prideslegacy.mixin;

import io.github.ron1196.circleofcraft.client.model.LionModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Client-side compatibility polish for Circle of Craft's stock lion mesh.
 *
 * Scar, Ticket Lion and normal lions share LionModel#createBodyLayer. The original mesh/texture
 * combination can expose a hollow-looking opening directly behind the mane when viewed from above
 * and behind. Rebuilding the same layer with a small internal neck bridge closes that opening while
 * keeping Circle of Craft's entity behavior, hitboxes and animations untouched.
 */
@Mixin(LionModel.class)
public abstract class LionModelMixin {

    @Inject(method = "createBodyLayer", at = @At("HEAD"), cancellable = true)
    private static void prideslegacy$closeNeckOpening(CallbackInfoReturnable<LayerDefinition> cir) {
        cir.setReturnValue(prideslegacy$createFixedLayer());
    }

    private static LayerDefinition prideslegacy$createFixedLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        PartDefinition head = root.addOrReplaceChild(
                "head",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 8.0F)
                        .texOffs(52, 34)
                        .addBox(-2.0F, 0.0F, -9.0F, 4.0F, 4.0F, 2.0F),
                PartPose.offset(0.0F, 4.0F, -9.0F));

        // Uses the leg/coat UV area, which is opaque on the stock lion-family textures.
        // The cube sits almost entirely inside the head/body overlap and only becomes visible
        // where the original model/texture exposes the rear neck opening.
        head.addOrReplaceChild(
                "prideslegacy_neck_bridge",
                CubeListBuilder.create().texOffs(0, 19).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 6.0F, 6.0F),
                PartPose.ZERO);

        root.addOrReplaceChild(
                "headwear",
                CubeListBuilder.create()
                        .texOffs(32, 0)
                        .addBox(-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)),
                PartPose.offset(0.0F, 4.0F, -9.0F));

        root.addOrReplaceChild(
                "mane",
                CubeListBuilder.create().texOffs(0, 36).addBox(-7.0F, -7.0F, -5.0F, 14.0F, 14.0F, 9.0F),
                PartPose.offset(0.0F, 4.0F, -9.0F));

        root.addOrReplaceChild(
                "body",
                CubeListBuilder.create().texOffs(0, 68).addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F),
                PartPose.offset(0.0F, 5.0F, 2.0F));

        root.addOrReplaceChild(
                "leg1",
                CubeListBuilder.create().texOffs(0, 19).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F),
                PartPose.offset(-4.0F, 12.0F, 7.0F));
        root.addOrReplaceChild(
                "leg2",
                CubeListBuilder.create().texOffs(0, 19).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F),
                PartPose.offset(4.0F, 12.0F, 7.0F));
        root.addOrReplaceChild(
                "leg3",
                CubeListBuilder.create().texOffs(0, 19).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F),
                PartPose.offset(-4.0F, 12.0F, -5.0F));
        root.addOrReplaceChild(
                "leg4",
                CubeListBuilder.create().texOffs(0, 19).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F),
                PartPose.offset(4.0F, 12.0F, -5.0F));

        return LayerDefinition.create(mesh, 64, 96);
    }
}
