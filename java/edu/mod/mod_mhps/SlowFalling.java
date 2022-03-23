package edu.mod.mod_mhps;

import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
public class SlowFalling {
    @SubscribeEvent
    public void parachute(PlayerTickEvent event){
    if(!(event.player.isShiftKeyDown())){
        return;
    }

    event.player.resetFallDistance();

    Vec3 playerMovement = event.player.getDeltaMovement();

    event.player.setDeltaMovement(playerMovement.x, -0.5F, playerMovement.z);

    }
}