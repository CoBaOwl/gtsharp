package com.coba.gtsharp.multiblock.standart;

import com.coba.gtsharp.api.recipes.GTSharpRecipeMaps;
import com.coba.gtsharp.api.render.GTSharpTextures;
import com.coba.gtsharp.common.block.GTSharpMetaBlocks;
import gregicality.multiblocks.api.metatileentity.GCYMRecipeMapMultiblockController;
import gregicality.multiblocks.api.render.GCYMTextures;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.blocks.BlockTurbineCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

import static gregtech.api.util.RelativeDirection.*;

public class MetaTileEntityLargeRockFactory extends GCYMRecipeMapMultiblockController {
    public MetaTileEntityLargeRockFactory(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTSharpRecipeMaps.ROCK_FACTORY_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity metaTileEntityHolder) {
        return new MetaTileEntityLargeRockFactory(this.metaTileEntityId);
    }

    @Override
    protected @NotNull BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(RIGHT, FRONT, DOWN)
                .aisle("FX#XF", "XXXXX", "#X#X#", "XXXXX", "FX#XF")
                .aisle("F###F", "##G##", "#G#G#", "##G##", "F###F").setRepeatable(3)
                .aisle("FXSXF", "XXXXX", "XXXXX", "XXXXX", "FXXXF")
                .where('S', selfPredicate())
                .where('X', states(getCasingState()).setMinGlobalLimited(25).or(autoAbilities()))
                .where('G', states(getGearState()))
                .where('F', getFrameState())
                .where('#', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GTSharpMetaBlocks.BREAK_PROOF_CASING.getDefaultState();
    }

    private static TraceabilityPredicate getFrameState() {
        return frames(Materials.HSSS);
    }

    private static IBlockState getGearState() {
        return MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TITANIUM_GEARBOX);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return GTSharpTextures.BREAK_PROOF_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Override
    protected @NotNull OrientedOverlayRenderer getFrontOverlay() {
        return GCYMTextures.LARGE_PACKAGER_OVERLAY;
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }
}
