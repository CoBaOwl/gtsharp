package com.coba.gtsharp.common.block;


import com.coba.gtsharp.common.block.blocks.BlockInfiniteCasing;
import com.coba.gtsharp.common.block.blocks.BlockVoidCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

public final class GTSharpMetaBlocks {

    private GTSharpMetaBlocks() {}

    public static BlockInfiniteCasing INFINITE_MINER_CASING;
    public static BlockVoidCasing VOID_CASING;

    public static void init() {
        INFINITE_MINER_CASING = new BlockInfiniteCasing();
        INFINITE_MINER_CASING.setRegistryName("infinite_miner_casing");

        VOID_CASING = new BlockVoidCasing();
        VOID_CASING.setRegistryName("void_miner_casing");
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        registerItemModel(INFINITE_MINER_CASING);
        VOID_CASING.onModelRegister();
    }

    @SideOnly(Side.CLIENT)
    private static void registerItemModel(@NotNull Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            // noinspection ConstantConditions
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(),
                            MetaBlocks.statePropertiesToString(state.getProperties())));
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> @NotNull String getPropertyName(@NotNull IProperty<T> property,
                                                                             Comparable<?> value) {
        return property.getName((T) value);
    }
}
