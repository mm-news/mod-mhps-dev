package edu.mod.exam_mod;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
public class SlowFalling {
    @SubscribeEvent
    public void parachutePartI(PlayerTickEvent event){
    if(!(event.player.isShiftKeyDown())){
        return;
    }

    Vec3 playerMovement = event.player.getDeltaMovement();

    event.player.setDeltaMovement(playerMovement.x, -0.5F, playerMovement.z);
    }

    @SubscribeEvent
    public void parachutePartII(LivingFallEvent event){
        if (!(event.getEntity() instanceof Player)){
            return;
        }

        Player player = (Player)event.getEntity();

        if (!player.isShiftKeyDown()) {
            return;
        }

        event.setCanceled(true);

    }
}