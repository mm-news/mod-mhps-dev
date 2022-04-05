package edu.mod.mod_mhps.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ItemGroup {
    public static final CreativeModeTab MOD_MHPS = new CreativeModeTab("mod_mhps") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RadioactiveMaterial.RADIOACTIVE_MATERIAL.get());
        }

    };
}
