package edu.mod.exam_mod;

import net.minecraft.world.level.Explosion;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ExplodeWhenEntityDie {
    
    @SubscribeEvent
    public void explodeWhenEntityDie(LivingDeathEvent event) {

        if(event.getEntity().level.isClientSide) {
            event.getEntity().level.explode(event.getEntity(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), 3F, Explosion.BlockInteraction.DESTROY);
        }

    }
}
