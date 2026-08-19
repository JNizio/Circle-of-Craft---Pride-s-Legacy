package com.jnizio.prideslegacy.entity;

import io.github.ron1196.circleofcraft.entity.animal.Gender;
import io.github.ron1196.circleofcraft.entity.animal.LionEntity;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;

/**
 * First vertical-slice entity for Pride's Legacy.
 *
 * For milestone 0 Kovu deliberately inherits Circle of Craft's LionEntity behavior so we can prove
 * that the add-on can reuse the existing lion foundation cleanly. Unique AI/dialogue comes next.
 */
public class KovuEntity extends LionEntity {

    public static final String REGISTRY_NAME = "kovu";

    public KovuEntity(EntityType<? extends Animal> type, Level level) {
        super(type, level);
        setCustomName(Component.literal("Kovu"));
        setCustomNameVisible(true);
        setPersistenceRequired();
        setGender(Gender.MALE);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return LionEntity.createAttributes();
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(
            @NotNull ServerLevelAccessor level,
            @NotNull DifficultyInstance difficulty,
            @NotNull MobSpawnType spawnType,
            @Nullable SpawnGroupData spawnData) {
        SpawnGroupData result = super.finalizeSpawn(level, difficulty, spawnType, spawnData);
        setGender(Gender.MALE);
        return result;
    }
}
