package edu.mod.exam_mod;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
public class BlockBreakMessage {
    @SubscribeEvent
    public void sendMessage(BreakEvent event){
    event.
        getPlayer()
        .sendMessage(new TextComponent(ChatFormatting.GREEN+"you broke a block!"), event.getPlayer().getUUID());
    System.out.println("you broke a block!");
}
}