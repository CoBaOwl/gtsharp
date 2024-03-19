package com.coba.gtsharp.loaders.recipe;

import com.coba.gtsharp.api.recipes.GTSharpRecipeMaps;
import com.coba.gtsharp.common.block.GTSharpMetaBlocks;
import com.coba.gtsharp.common.block.blocks.BlockLargeMultiblockCasing;
import com.coba.gtsharp.multiblock.GTSharpMetaTileEntities;

import gregtech.api.GTValues;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.ADVANCED_LARGE_MINER;
import static gregtech.common.metatileentities.MetaTileEntities.HULL;

public final class GTSharpMetaTileEntityLoader {

    private GTSharpMetaTileEntityLoader() {}

    public static void init() {
        ModHandler.addShapedRecipe(true, "large_machine", GTSharpMetaTileEntities.LARGE_MACHINE.getStackForm(),
                "LCL", "PSP", "LCL",
                'L', new UnificationEntry(pipeLargeFluid, Iridium),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'P', MetaItems.ELECTRIC_PUMP_IV.getStackForm(),
                'S', MetaTileEntities.CRACKER.getStackForm());
        ModHandler.addShapedRecipe(true, "large_gas_collector", GTSharpMetaTileEntities.LARGE_GAS_COLLECTOR.getStackForm(),
                "LCL", "PSP", "LCL",
                'L', new UnificationEntry(pipeLargeFluid, Tungsten),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.LuV),
                'P', MetaItems.ELECTRIC_PISTON_IV.getStackForm(),
                'S', MetaTileEntities.GAS_COLLECTOR[IV].getStackForm());
        ModHandler.addShapedRecipe(true, "large_cable_factory", GTSharpMetaTileEntities.LARGE_CABLE_FACTORY.getStackForm(),
                "CLC", "ACW", "CLC",
                'L', MetaItems.CONVEYOR_MODULE_IV.getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.LuV),
                'A', MetaTileEntities.ASSEMBLER[IV].getStackForm(),
                'W', MetaTileEntities.WIREMILL[IV].getStackForm());
        ModHandler.addShapedRecipe(true, "void_miner_casing", GTSharpMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.VOID_MINER_CASING, 2),
                "PhP", "PFP", "PwP", 'P',
                new UnificationEntry(OrePrefix.plate, Materials.NaquadahAlloy), 'F',
                new UnificationEntry(OrePrefix.frameGt, Materials.NaquadahAlloy));
        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(VA[UV])
                .input(plate, NaquadahAlloy, 6)
                .input(frameGt, NaquadahAlloy)
                .circuitMeta(6)
                .outputs(GTSharpMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.VOID_MINER_CASING, 2))
                .duration(50).buildAndRegister();
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[ZPM])
                .input(frameGt, HSSS, 4)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_MOTOR_ZPM, 4)
                .input(ELECTRIC_PUMP_ZPM, 4)
                .input(CONVEYOR_MODULE_ZPM, 4)
                .input(gear, NaquadahAlloy, 4)
                .circuitMeta(2)
                .output(GTSharpMetaTileEntities.BASIC_INFINITE_MINER)
                .duration(400).EUt(VA[ZPM]).buildAndRegister();
    }
}
