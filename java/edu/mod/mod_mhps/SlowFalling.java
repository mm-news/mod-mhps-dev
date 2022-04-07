package edu.mod.mod_mhps;

import edu.mod.mod_mhps.block.AntiGravityStone;
import edu.mod.mod_mhps.item.AntiGravityParticles;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
public class SlowFalling {
    @SubscribeEvent
    public void parachute(PlayerTickEvent event){
    
        if(!(event.player.isShiftKeyDown())){
            return;
        }

        if (!(event.player.isHolding(AntiGravityParticles.ANTI_GRAVITY_PARTICLES.get())) && !(event.player.isHolding(AntiGravityStone.ANTI_GRAVITY_STONE.get().asItem()))) {
            return;
        }

        event.player.resetFallDistance();

        Vec3 playerMovement = event.player.getDeltaMovement();

        event.player.setDeltaMovement(playerMovement.x, -0.5F, playerMovement.z);

    }
}