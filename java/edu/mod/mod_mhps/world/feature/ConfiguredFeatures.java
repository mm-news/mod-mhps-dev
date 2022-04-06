package edu.mod.mod_mhps.world.feature;

import java.util.List;

import edu.mod.mod_mhps.block.AntiGravityStone;
import edu.mod.mod_mhps.block.RadioactiveBlock;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class ConfiguredFeatures {

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_CITRINE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, RadioactiveBlock.RADIOACTIVE_BLOCK.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, RadioactiveBlock.RADIOACTIVE_BLOCK.get().defaultBlockState()), 
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, AntiGravityStone.ANTI_GRAVITY_STONE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, AntiGravityStone.ANTI_GRAVITY_STONE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> CITRINE_ORE = FeatureUtils.register("citrine_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_CITRINE_ORES, 9));

}