package edu.mod.mod_mhps.block;

import java.util.function.Supplier;

import edu.mod.mod_mhps.item.ItemGroup;
import edu.mod.mod_mhps.item.RadioactiveMaterial;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
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
                    ItemGroup.MOD_MHPS
                )
            )
        );

    }

    public static final RegistryObject<Block>
    RADIOACTIVE_BLOCK = registerBlock(
        "radioactive_block", 
        () -> new Block(
            BlockBehaviour.Properties.of(Material.STONE)
            .requiresCorrectToolForDrops()
            .explosionResistance(5F)
            .destroyTime(10)
            .sound(SoundType.METAL)
            .jumpFactor(5F)
            .friction(0.5F)
            .strength(1.5F, 6F)
            .lightLevel((state) -> state.toString() != "BLUH BLUH BLUH BLUH" ? 15 : 15)
        )
    );

}
