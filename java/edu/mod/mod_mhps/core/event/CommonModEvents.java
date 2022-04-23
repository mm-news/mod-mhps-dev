package edu.mod.mod_mhps.core.event;

import edu.mod.mod_mhps.common.entity.DieBall;
import edu.mod.mod_mhps.core.init.EntityInit;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;;

@Mod.EventBusSubscriber(modid = "mod_mhps", bus = Bus.MOD)
public class CommonModEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityInit.DIE_BALL.get(), DieBall.createAttributes().build());
    }

}
