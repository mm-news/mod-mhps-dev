package edu.mod.mod_mhps;

import net.minecraft.world.item.Items;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class NoGravity {
    
    @SubscribeEvent
    public void noGravity(PlayerTickEvent event) {

        if (!(event.player.isHolding(Items.DRAGON_EGG))) {
            event.player.setNoGravity(false);
            return;
        }

        event.player.setNoGravity(true);
    }

}
