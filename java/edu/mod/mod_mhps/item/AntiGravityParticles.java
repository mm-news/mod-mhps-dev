package edu.mod.mod_mhps.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AntiGravityParticles {
    
    public static final DeferredRegister<Item> ITEMS = 
    DeferredRegister.create(ForgeRegistries.ITEMS, "mod_mhps");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> ANTI_GRAVITY_STONE = 
    ITEMS.register(
        "anti_gravity_particles", 
        () -> new Item(
            new Item.Properties().tab(
                CreativeModeTab.TAB_TOOLS
            )
            .stacksTo(1) //限制堆疊數量為1
        )
    );
}
