package com.coba.gtsharp.multiblock.standart;

import com.coba.gtsharp.api.recipes.GTSharpRecipeMaps;
import gregicality.multiblocks.api.metatileentity.GCYMRecipeMapMultiblockController;
import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.blocks.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

public class MetaTileEntityLargeCableFactory extends GCYMRecipeMapMultiblockController {
    public MetaTileEntityLargeCableFactory(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTSharpRecipeMaps.LARGE_CABLE_MILL_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity metaTileEntityHolder) {
        return new MetaTileEntityLargeCableFactory(this.metaTileEntityId);
    }

    @Override
    protected @NotNull BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXX", "FXF", "F#F")
                .aisle("XXX", "GHG", "FXF").setRepeatable(5)
                .aisle("XXX", "FSF", "F#F")
                .where('S', selfPredicate())
                .where('X', states(getCasingState()).setMinGlobalLimited(15).or(autoAbilities()))
                .where('G', states(getCasingGlass()))
                .where('H', states(getGearState()))
                .where('F', getFrameState())
                .where('#', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.STRESS_PROOF_CASING);
    }

    private static TraceabilityPredicate getFrameState() {
        return frames(GCYMMaterials.MaragingSteel300);
    }

    private static IBlockState getGearState() {
        return MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TUNGSTENSTEEL_GEARBOX);
    }

    private static IBlockState getCasingGlass() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.LAMINATED_GLASS);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return GCYMTextures.STRESS_PROOF_CASING;
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
