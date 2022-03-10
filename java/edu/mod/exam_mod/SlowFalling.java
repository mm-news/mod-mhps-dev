package edu.mod.exam_mod;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
public class SlowFalling {
    @SubscribeEvent
    public void parachutePartI(PlayerTickEvent event){
    if(!(event.player.isShiftKeyDown())){
        return;
    }

    event.player.setDeltaMovement(0F, -0.5F, 0F);
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