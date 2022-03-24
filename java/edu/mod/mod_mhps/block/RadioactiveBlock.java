package edu.mod.mod_mhps.block;

import java.util.function.Supplier;

import edu.mod.mod_mhps.item.RadioactiveMaterial;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RadioactiveBlock {
    
    public static final DeferredRegister<Block> BLOCKS =
    DeferredRegister.create(ForgeRegistries.BLOCKS, "mod_mhps");

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static <T extends Block>RegistryObject<T> 
    registerBlock(String name, Supplier<T> block) {
        
        RegistryObject<T> toReturn = 
        BLOCKS.register(name, block);

        registerBlockItem(name, toReturn);
        return toReturn;

    }

    private static <T extends Block> void 
    registerBlockItem(String name, RegistryObject<T> block) {

        RadioactiveMaterial.ITEMS.register(
            name, 
            () -> new BlockItem(
                block.get(), 
                new Item.Properties().tab(
                    CreativeModeTab.TAB_BUILDING_BLOCKS
                )
            )
        );

    }

    public static final RegistryObject<Block>
    RADIOACTIVE_BLOCK = registerBlock(
        "radioactive_block", 
        () -> new Block(
            BlockBehaviour.Properties.of(Material.STONE).strength(5F)
        )
    );

}