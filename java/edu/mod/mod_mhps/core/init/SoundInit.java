package edu.mod.mod_mhps.core.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class SoundInit {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister
            .create(ForgeRegistries.SOUND_EVENTS, "mod_mhps");

    public static final RegistryObject<SoundEvent> DIE_BALL_AMBIENT = SOUNDS.register(
            "entity.die.ambient",
            () -> new SoundEvent(new ResourceLocation("minecraft", "entity.pig.ambient")));

    public static final RegistryObject<SoundEvent> DIE_BALL_HURT = SOUNDS.register(
            "entity.die.hurt",
            () -> new SoundEvent(new ResourceLocation("minecraft", "entity.pig.hurt")));

    public static final RegistryObject<SoundEvent> DIE_BALL_DEATH = SOUNDS.register(
            "entity.die.death",
            () -> new SoundEvent(new ResourceLocation("minecraft", "entity.pig.death")));

    private SoundInit() {
    }
}