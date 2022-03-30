package edu.mod.mod_mhps;

import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class WallClimb {

    @SubscribeEvent
    public void climbWall(LivingUpdateEvent event) {
        if (!event.getEntity().horizontalCollision) {
            return;
        }

        event.getEntity().setDeltaMovement(0F, 0.5F, 0F);
    }
}
