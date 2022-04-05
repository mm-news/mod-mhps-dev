package edu.mod.mod_mhps.world;

import edu.mod.mod_mhps.world.gen.OreGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "mod_mhps")
public class WorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {

        OreGeneration.generateOres(event);

    }
}