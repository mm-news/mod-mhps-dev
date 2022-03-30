package edu.mod.mod_mhps;

import edu.mod.mod_mhps.item.WallClimbingGlove;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class WallClimb {

    @SubscribeEvent
    public void climbWall(LivingUpdateEvent event) {

        if (!event.getEntityLiving().isHolding(WallClimbingGlove.WALL_CLIMBING_GLOVE.get())) {
            return;
        }

        if (!event.getEntity().horizontalCollision) {
            return;
        }

        event.getEntity().setDeltaMovement(0F, 0.5F, 0F);
    }
}
