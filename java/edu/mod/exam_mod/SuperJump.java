package edu.mod.exam_mod;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SuperJump {
    
    @SubscribeEvent
    public void mkJumpHigher(LivingJumpEvent event){
        if (!(event.getEntity() instanceof Player)){
            return;
        }
        
        event.getEntity().setDeltaMovement(0.0F, 6F, 0.0F);
    }

}
