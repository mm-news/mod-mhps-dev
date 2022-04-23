package edu.mod.mod_mhps.core.init;

import edu.mod.mod_mhps.common.entity.DieBall;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister
            .create(ForgeRegistries.ENTITIES, "mod_mhps");

    public static final RegistryObject<EntityType<DieBall>> DIE_BALL = ENTITIES.register(
            "die_ball",
            () -> EntityType.Builder.of(DieBall::new, MobCategory.CREATURE).sized(8f, 8f)
                    .build(new ResourceLocation("mod_mhps", "die_ball").toString()));

    private EntityInit() {
    }
}