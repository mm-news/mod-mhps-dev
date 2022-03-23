package edu.mod.mod_mhps.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RadioactiveMaterial {
    
    public static final DeferredRegister<Item> ITEMS = 
    DeferredRegister.create(ForgeRegistries.ITEMS, "mod_mhps");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    // Register item "radioactive material" as "radioactive_material"
    public static final RegistryObject<Item> RADIOACTIVE_MATERIAL = 
    ITEMS.register(
        "radioactive_material", 
        () -> new Item(
            new Item.Properties().tab(
                CreativeModeTab.TAB_MISC
            )
        )
    );
    
    

}
