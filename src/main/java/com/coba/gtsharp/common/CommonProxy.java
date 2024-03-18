package com.coba.gtsharp.common;

import com.coba.gtsharp.GTSharp;
import com.coba.gtsharp.common.block.GTSharpMetaBlocks;
import com.coba.gtsharp.loaders.recipe.GTSharpCableRecipeHandler;
import com.coba.gtsharp.loaders.recipe.GTSharpRecipeLoader;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregtech.api.block.VariantItemBlock;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Objects;
import java.util.function.Function;

@Mod.EventBusSubscriber(modid = GTSharp.MODID)
public class CommonProxy {

    public void preLoad() {}

    @SubscribeEvent
    public static void syncConfigValues(ConfigChangedEvent.OnConfigChangedEvent event) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(GTSharpMetaBlocks.LARGE_MULTIBLOCK_CASING);

    }

    private static <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(Objects.requireNonNull(block.getRegistryName()));

        return itemBlock;
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(createItemBlock(GTSharpMetaBlocks.LARGE_MULTIBLOCK_CASING, VariantItemBlock::new));

    }

    @SubscribeEvent()
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        GTSharpRecipeLoader.init();
        GTSharpCableRecipeHandler.register();
    }
}
