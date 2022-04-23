package edu.mod.mod_mhps.item;

import edu.mod.mod_mhps.core.init.EntityInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DieBallSpawnEgg {
    
    public static final DeferredRegister<Item> ITEMS = 
    DeferredRegister.create(ForgeRegistries.ITEMS, "mod_mhps");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<ForgeSpawnEggItem> DIE_BALL_EGG = ITEMS
            .register("die_ball_spawn_egg", () -> new ForgeSpawnEggItem(EntityInit.DIE_BALL,
                    0x198964, 0xFFD306, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}
