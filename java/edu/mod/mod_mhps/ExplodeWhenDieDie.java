package edu.mod.mod_mhps;

import edu.mod.mod_mhps.common.entity.DieBall;
import net.minecraft.world.level.Explosion;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ExplodeWhenDieDie {
    
    @SubscribeEvent
    public void explodeWhenEntityDie(LivingDeathEvent event) {


        if(event.getEntity() instanceof DieBall) {
            event.getEntity().level.explode(event.getEntity(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), 1F, Explosion.BlockInteraction.DESTROY);
        }
    }
}
