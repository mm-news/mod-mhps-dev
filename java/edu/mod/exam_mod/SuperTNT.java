package edu.mod.exam_mod;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion.BlockInteraction;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SuperTNT {
    //第一部分：在TNT點火時設置4秒的引信
    @SubscribeEvent
    public void spawnTNT(EntityJoinWorldEvent event) {

        System.out.println(event.getEntity().toString());

        if(!(event.getEntity() instanceof PrimedTnt)) {
            return;
        }

        System.out.println(event.getEntity());
        Entity entity = event.getEntity();
        ItemEntity explosion = new ItemEntity(event.getWorld(), entity.getX(), entity.getY(), entity.getZ(), new ItemStack(Blocks.TNT));

        explosion.setPickUpDelay(10*20);
        explosion.setDeltaMovement(0, 0, 0);
        explosion.lifespan = 4;

        if (entity.level.isClientSide) {
            event.getEntity().level.addFreshEntity(explosion);
            System.out.println("成功新增！");
        }
    }

    //第二部分：在四秒過後爆炸
    @SubscribeEvent
    public void explode(ItemExpireEvent event) {

        System.out.println(event.getEntityItem().getItem());

        if (!(event.getEntityItem().getItem() == new ItemStack(Blocks.TNT))) {
            System.out.println("遭到過濾！");
            return;
        }
        
        ItemEntity explosion = event.getEntityItem();
        System.out.println("加強爆炸成功！");
        explosion.level.explode(explosion, explosion.getX(), explosion.getY(), explosion.getZ(), 3F, BlockInteraction.DESTROY);

    }

}
