package edu.mod.mod_mhps;

import edu.mod.mod_mhps.block.AntiGravityStone;
import edu.mod.mod_mhps.item.AntiGravityParticles;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SuperJump {
    
    @SubscribeEvent
    public void mkJumpHigher(LivingJumpEvent event){
        if (!(event.getEntity() instanceof Player)){
            return;
        }

        if (!(event.getEntityLiving().isHolding(AntiGravityParticles.ANTI_GRAVITY_PARTICLES.get()))
            && 
        !(event.getEntityLiving().isHolding(AntiGravityStone.ANTI_GRAVITY_STONE.get().asItem()))) {
            return;
        }
        
        Vec3 playerMovement = event.getEntity().getDeltaMovement();

        if (event.getEntityLiving().isHolding(AntiGravityParticles.ANTI_GRAVITY_PARTICLES.get())) {
            event.getEntity().setDeltaMovement(playerMovement.x, playerMovement.y*3, playerMovement.z);
        }

        else {
            event.getEntity().setDeltaMovement(playerMovement.x, playerMovement.y*6, playerMovement.z);;
        }
    }

}
