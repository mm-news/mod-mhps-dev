package edu.mod.mod_mhps.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
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
                ItemGroup.MOD_MHPS
            )
            .food(
                new FoodProperties
                .Builder()
                .nutrition(2)
                .saturationMod(1.5F)
                .effect(
                    () -> new MobEffectInstance(MobEffects.POISON, 5*20), 0.1F
                )
                .effect(
                    () -> new MobEffectInstance(MobEffects.BLINDNESS, 5*20), 0.1F
                )
                .effect(
                    () -> new MobEffectInstance(MobEffects.SATURATION, 180*20), 0.1F
                )
                .effect(
                    () -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 180*20), 0.1F
                )
                .effect(
                    () -> new MobEffectInstance(MobEffects.INVISIBILITY, 100*20), 0.1F)
                .build()
            )
        )
    );
    
    

}
