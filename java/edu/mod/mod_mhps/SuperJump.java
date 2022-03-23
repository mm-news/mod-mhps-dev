package edu.mod.mod_mhps;

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
        
        Vec3 playerMovement = event.getEntity().getDeltaMovement();

        event.getEntity().setDeltaMovement(playerMovement.x, playerMovement.y*6, playerMovement.z);
    }

}
