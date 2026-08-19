package com.jnizio.prideslegacy.registry;

import com.jnizio.prideslegacy.PridesLegacyMod;
import com.jnizio.prideslegacy.entity.KovuEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModEntityTypes {

    private ModEntityTypes() {}

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, PridesLegacyMod.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<KovuEntity>> KOVU =
            ENTITY_TYPES.register(KovuEntity.REGISTRY_NAME, () -> EntityType.Builder.of(KovuEntity::new, MobCategory.CREATURE)
                    .sized(1.3F, 1.6F)
                    .clientTrackingRange(10)
                    .build(KovuEntity.REGISTRY_NAME));
}
