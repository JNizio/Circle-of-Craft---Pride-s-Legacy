package com.jnizio.prideslegacy.client.model;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

/** Kovu-specific take on Circle of Craft's lion mesh. */
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

        // The stock lion/Scar mesh leaves a visible opening at the rear of the head from
        // high/behind camera angles. This small coat-coloured bridge sits inside the shoulder
        // overlap and hides the opening without changing hitboxes.
        head.addOrReplaceChild(
                "neck_bridge",
                CubeListBuilder.create().texOffs(0, 19).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 6.0F, 6.0F),
                PartPose.ZERO);

        root.addOrReplaceChild(
                "headwear",
                CubeListBuilder.create()
                        .texOffs(32, 0)
                        .addBox(-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 8.0F, new net.minecraft.client.model.geom.builders.CubeDeformation(0.5F)),
                PartPose.offset(0.0F, 4.0F, -9.0F));

        // Kovu is intentionally leaner and younger-looking than Scar.
        root.addOrReplaceChild(
                "mane",
                CubeListBuilder.create().texOffs(0, 36).addBox(-6.0F, -5.0F, -4.0F, 12.0F, 11.0F, 7.0F),
                PartPose.offset(0.0F, 4.0F, -9.0F));

        root.addOrReplaceChild(
                "body",
                CubeListBuilder.create().texOffs(0, 68).addBox(-5.0F, -9.0F, -6.0F, 10.0F, 17.0F, 9.0F),
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
