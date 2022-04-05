package edu.mod.mod_mhps.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

import edu.mod.mod_mhps.block.RadioactiveBlock;

public class ConfiguredFeatures {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> EBONY_TREE =
            FeatureUtils.register("ebony", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(RadioactiveBlock.RADIOACTIVE_BLOCK.get()),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(RadioactiveBlock.RADIOACTIVE_BLOCK.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final Holder<PlacedFeature> EBONY_CHECKED = PlacementUtils.register("ebony_checked", EBONY_TREE,
                    PlacementUtils.filteredByBlockSurvival(RadioactiveBlock.RADIOACTIVE_BLOCK.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> EBONY_SPAWN =
            FeatureUtils.register("ebony_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(EBONY_CHECKED,
                            0.5F)), EBONY_CHECKED));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_CITRINE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, RadioactiveBlock.RADIOACTIVE_BLOCK.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, RadioactiveBlock.RADIOACTIVE_BLOCK.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> CITRINE_ORE = FeatureUtils.register("citrine_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_CITRINE_ORES, 9));

}