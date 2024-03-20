package com.coba.gtsharp.multiblock.standart;

import com.coba.gtsharp.api.recipes.GTSharpRecipeMaps;
import com.coba.gtsharp.api.render.GTSharpTextures;
import com.coba.gtsharp.common.block.GTSharpMetaBlocks;
import gregicality.multiblocks.api.render.GCYMTextures;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import static gregtech.api.util.RelativeDirection.*;

public class MetaTileEntityInfiniteMiner extends RecipeMapMultiblockController {
    public MetaTileEntityInfiniteMiner(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTSharpRecipeMaps.INFINITE_MINER_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity metaTileEntityHolder) {
        return new MetaTileEntityInfiniteMiner(this.metaTileEntityId);
    }

    @Override
    protected @NotNull BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(RIGHT, FRONT, DOWN)
                .aisle("###", "#F#", "###").setRepeatable(3)
                .aisle("#F#", "FVF", "#F#").setRepeatable(3)
                .aisle("XSX", "XXX", "XXX")
                .where('V', states(getVoidCasing()))
                .where('S', selfPredicate())
                .where('X', states(getCasingState())
                    .or(abilities(MultiblockAbility.EXPORT_ITEMS).setMaxGlobalLimited(1).setPreviewCount(1))
                    .or(abilities(MultiblockAbility.IMPORT_FLUIDS).setExactLimit(1).setPreviewCount(1))
                    .or(metaTileEntities(Arrays
                            .stream(MetaTileEntities.ENERGY_INPUT_HATCH)
                            .filter(mte -> mte != null && GTValues.LuV <= mte.getTier())
                            .toArray(MetaTileEntity[]::new))
                            .setExactLimit(1).setPreviewCount(1))
                    .or(abilities(MultiblockAbility.IMPORT_ITEMS).setMaxGlobalLimited(1).setPreviewCount(1).setPreviewCount(1))
                )
                .where('C', states(getCasingState()))
                .where('F', getFramePredicate())
                .where('#', any())
                .build();
    }

    @NotNull
    protected static IBlockState getCasingState() {
        return GTSharpMetaBlocks.INFINITE_MINER_CASING.getDefaultState();
    }

    @NotNull
    protected static IBlockState getVoidCasing() {
        return GTSharpMetaBlocks.VOID_CASING.getDefaultState();
    }

    @NotNull
    private TraceabilityPredicate getFramePredicate() {
        return frames(Materials.NaquadahAlloy);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return GTSharpTextures.INFINITE_MINER_CASING;
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

    @Override
    public boolean hasMaintenanceMechanics() {
        return false;
    }
}
