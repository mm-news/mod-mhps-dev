package edu.mod.exam_mod;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SuperTNT {
    
    @SubscribeEvent
    public void spawnTNT(EntityJoinWorldEvent event) {

        if(!(event.getEntity() instanceof PrimedTnt)) {
            return;
        }

        Entity entity = event.getEntity();
        ItemEntity explosion = new ItemEntity(event.getWorld(), entity.getX(), entity.getY(), entity.getZ(), new ItemStack(Blocks.TNT));

        explosion.setPickUpDelay(10*20);
        explosion.setDeltaMovement(0, 0, 0);

    }

}
