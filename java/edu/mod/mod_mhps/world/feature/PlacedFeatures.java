package edu.mod.mod_mhps.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

public class PlacedFeatures {

    public static final Holder<PlacedFeature> CITRINE_ORE_PLACED = PlacementUtils.register("citrine_ore_placed",
            ConfiguredFeatures.CITRINE_ORE, OrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

}