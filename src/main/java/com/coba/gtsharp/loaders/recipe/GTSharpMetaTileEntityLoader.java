package com.coba.gtsharp.loaders.recipe;

import com.coba.gtsharp.common.block.GTSharpMetaBlocks;
import com.coba.gtsharp.common.block.blocks.BlockLargeMultiblockCasing;
import com.coba.gtsharp.multiblock.GTSharpMetaTileEntities;

import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public final class GTSharpMetaTileEntityLoader {

    private GTSharpMetaTileEntityLoader() {}

    public static void init() {
        ModHandler.addShapedRecipe(true, "large_machine", GTSharpMetaTileEntities.LARGE_MACHINE.getStackForm(),
                "LCL", "PSP", "LCL",
                'L', new UnificationEntry(pipeLargeFluid, Iridium),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'P', MetaItems.ELECTRIC_PUMP_IV.getStackForm(),
                'S', MetaTileEntities.CRACKER.getStackForm());
        ModHandler.addShapedRecipe(true, "void_miner_casing", GTSharpMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.VOID_MINER_CASING, 2),
                "PhP", "PFP", "PwP", 'P',
                new UnificationEntry(OrePrefix.plate, Materials.NaquadahAlloy), 'F',
                new UnificationEntry(OrePrefix.frameGt, Materials.NaquadahAlloy));
    }
}
