package edu.mod.exam_mod;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PigDroppingDiamond {
    
    @SubscribeEvent
    public void dropDiamond(LivingDeathEvent event) {

        if (!(event.getEntity() instanceof Pig)) {
            return;
        }

        Entity entity = event.getEntity();
        ItemEntity explosion = new ItemEntity(event.getEntity().level, entity.getX(), entity.getY()+1, entity.getZ(), new ItemStack(Items.DIAMOND));

        explosion.setNoPickUpDelay();
        explosion.setUnlimitedLifetime();
        explosion.setInvisible(false);
        explosion.setItem(new ItemStack(Items.DIAMOND));
        explosion.setId(304);
        explosion.setPos(event.getEntity().position());

        if (entity.level.isClientSide) {
            event.getEntity().level.addFreshEntity(explosion);
            System.out.println("OK");
        }
    }

}
