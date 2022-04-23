package edu.mod.mod_mhps.common.entity;

import java.util.Random;

import edu.mod.mod_mhps.core.init.EntityInit;
import edu.mod.mod_mhps.core.init.SoundInit;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class DieBall extends Animal {
    private static final ResourceLocation LOOT_TABLE = new ResourceLocation("mod_mhps",
            "entities/die_ball");
    
    public DieBall(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }
    
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob parent) {
        return EntityInit.DIE_BALL.get().create(level);
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundInit.DIE_BALL_AMBIENT.get();
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.DIE_BALL_DEATH.get();
    }
    
    @Override
    protected ResourceLocation getDefaultLootTable() {
        return LOOT_TABLE;
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundInit.DIE_BALL_HURT.get();
    }
    
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.of(new ItemStack(Items.PORKCHOP)), true));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }
    
    public static boolean canSpawn(EntityType<DieBall> entity, LevelAccessor levelAccess, MobSpawnType spawnType,
            BlockPos pos, Random random) {
        return checkAnimalSpawnRules(entity, levelAccess, spawnType, pos, random) && pos.getY() > 70;
    }
    
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 50.0D).add(Attributes.MOVEMENT_SPEED, 0.24D);
    }
}