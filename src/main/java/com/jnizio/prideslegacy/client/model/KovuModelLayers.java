package com.jnizio.prideslegacy.client.model;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

/**
 * Kovu-specific lion mesh.
 *
 * This layer is intentionally self-contained: it reuses Circle of Craft's LionModel animation
 * contract (head/headwear/mane/body/leg1..4) without modifying the base mod's model layer.
 */
public final class KovuModelLayers {

    private KovuModelLayers() {}

    public static LayerDefinition createBodyLayer() {
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

        // Small real ears replace the stock inflated headwear cube. They stay attached to the head
        // so they naturally inherit Circle of Craft's head animations.
        head.addOrReplaceChild(
                "left_ear",
                CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -2.0F, -0.5F, 2.0F, 3.0F, 1.0F),
                PartPose.offsetAndRotation(-2.6F, -4.1F, -1.0F, 0.0F, 0.0F, -0.18F));
        head.addOrReplaceChild(
                "right_ear",
                CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, -2.0F, -0.5F, 2.0F, 3.0F, 1.0F),
                PartPose.offsetAndRotation(2.6F, -4.1F, -1.0F, 0.0F, 0.0F, 0.18F));

        // Kovu-only bridge closes the stock lion's rear neck opening. This never touches Scar,
        // Simba, normal lions, Ticket Lion, or any other Circle of Craft entity.
        head.addOrReplaceChild(
                "neck_bridge",
                CubeListBuilder.create().texOffs(32, 54).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 6.0F, 6.0F),
                PartPose.ZERO);

        // LionModel expects this child to exist. Keep it geometry-free so the old large square
        // ears/head shell disappear without changing the base model class.
        root.addOrReplaceChild("headwear", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, -9.0F));

        // A younger Kovu mane: concentrated behind/on top of the head instead of a full square
        // helmet. Multiple cuboids keep the deliberately blocky Circle of Craft visual language.
        root.addOrReplaceChild(
                "mane",
                CubeListBuilder.create()
                        .texOffs(0, 36)
                        .addBox(-5.0F, -4.5F, -1.0F, 10.0F, 9.0F, 4.0F)
                        .texOffs(28, 36)
                        .addBox(-3.0F, -6.0F, -3.0F, 6.0F, 2.0F, 5.0F)
                        .texOffs(28, 44)
                        .addBox(-5.5F, -2.5F, -2.0F, 2.0F, 6.0F, 3.0F)
                        .texOffs(40, 44)
                        .addBox(3.5F, -2.5F, -2.0F, 2.0F, 6.0F, 3.0F),
                PartPose.offset(0.0F, 4.0F, -9.0F));

        // Keep the proven stock torso dimensions so the leg/body joints remain closed.
        PartDefinition body = root.addOrReplaceChild(
                "body",
                CubeListBuilder.create().texOffs(0, 68).addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F),
                PartPose.offset(0.0F, 5.0F, 2.0F));

        // Three-piece tail. Because it is parented under body, ModelPart rendering draws it
        // automatically while leaving Circle of Craft's shared LionModel class untouched.
        PartDefinition tailBase = body.addOrReplaceChild(
                "tail_base",
                CubeListBuilder.create().texOffs(44, 68).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F),
                PartPose.offsetAndRotation(0.0F, -4.5F, 3.0F, 0.25F, 0.0F, 0.0F));
        PartDefinition tailMid = tailBase.addOrReplaceChild(
                "tail_mid",
                CubeListBuilder.create().texOffs(44, 78).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 6.5F, 0.72F, 0.0F, 0.0F));
        tailMid.addOrReplaceChild(
                "tail_tuft",
                CubeListBuilder.create().texOffs(44, 87).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.25F, 0.0F, 0.0F));

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
