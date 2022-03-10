package edu.mod.exam_mod;

import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
public class SlowFalling {
    @SubscribeEvent
    public void sendMessage(PlayerTickEvent event){
    if(!(event.player.fallDistance==0) && !(event.player.isShiftKeyDown())){
        return;
    }

    event.player.setDeltaMovement(0F, -0.05F, 0F);

}
}