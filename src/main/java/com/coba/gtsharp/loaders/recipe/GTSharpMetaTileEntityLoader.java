package com.coba.gtsharp.loaders.recipe;

import com.coba.gtsharp.common.GTSharpConfigHolder;
import com.coba.gtsharp.common.block.GTSharpMetaBlocks;
import com.coba.gtsharp.common.block.blocks.BlockBreakProof;
import com.coba.gtsharp.common.block.blocks.BlockInfiniteCasing;
import com.coba.gtsharp.multiblock.GTSharpMetaTileEntities;

import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLY_LINE_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;

public final class GTSharpMetaTileEntityLoader {

    private GTSharpMetaTileEntityLoader() {}

    public static void init() {
        if (GTSharpConfigHolder.globalMultiblocks.enableLargeOilCracker) ModHandler.addShapedRecipe(true, "large_machine", GTSharpMetaTileEntities.LARGE_MACHINE.getStackForm(),
                "LCL", "PSP", "LCL",
                'L', new UnificationEntry(pipeLargeFluid, Iridium),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'P', MetaItems.ELECTRIC_PUMP_IV.getStackForm(),
                'S', MetaTileEntities.CRACKER.getStackForm());
        if (GTSharpConfigHolder.globalMultiblocks.enableLargeGasCollector) ModHandler.addShapedRecipe(true, "large_gas_collector", GTSharpMetaTileEntities.LARGE_GAS_COLLECTOR.getStackForm(),
                "LCL", "PSP", "LCL",
                'L', new UnificationEntry(pipeLargeFluid, Tungsten),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.LuV),
                'P', MetaItems.ELECTRIC_PISTON_IV.getStackForm(),
                'S', MetaTileEntities.GAS_COLLECTOR[IV].getStackForm());
        if (GTSharpConfigHolder.globalMultiblocks.enableLargeCableFactory) ModHandler.addShapedRecipe(true, "large_cable_factory", GTSharpMetaTileEntities.LARGE_CABLE_FACTORY.getStackForm(),
                "CLC", "ACW", "CLC",
                'L', MetaItems.CONVEYOR_MODULE_IV.getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.LuV),
                'A', MetaTileEntities.ASSEMBLER[IV].getStackForm(),
                'W', MetaTileEntities.WIREMILL[IV].getStackForm());
        if (GTSharpConfigHolder.globalMultiblocks.enableLargeRockFactory) ModHandler.addShapedRecipe(true, "large_rock_factory", GTSharpMetaTileEntities.LARGE_ROCK_FACTORY.getStackForm(),
                "CPC", "LAL", "CPC",
                'P', ELECTRIC_PISTON_IV.getStackForm(),
                'L', CONVEYOR_MODULE_IV.getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'A', ROCK_BREAKER[IV].getStackForm());
        if (GTSharpConfigHolder.globalMultiblocks.enableLargeRockFactory) ModHandler.addShapedRecipe(true, "casing_large_breaker",
                GTSharpMetaBlocks.BREAK_PROOF_CASING.getItemVariant(BlockBreakProof.CasingType.BREAK_PROOF_CASING, 2),
                "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, GCYMMaterials.TitaniumTungstenCarbide),
                'F', new UnificationEntry(OrePrefix.frameGt, TungstenSteel));
        if (GTSharpConfigHolder.globalMultiblocks.enableInfiniteMiner) ModHandler.addShapedRecipe(true, "infinite_miner_casing", GTSharpMetaBlocks.INFINITE_MINER_CASING.getItemVariant(BlockInfiniteCasing.CasingType.INFINITE_MINER_CASING, 2),
                "PhP", "PFP", "PwP", 'P',
                new UnificationEntry(OrePrefix.plate, Materials.NaquadahAlloy), 'F',
                new UnificationEntry(OrePrefix.frameGt, Materials.NaquadahAlloy));
        if (GTSharpConfigHolder.globalMultiblocks.enableInfiniteMiner) ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(VA[UV])
                .input(plate, NaquadahAlloy, 6)
                .input(frameGt, NaquadahAlloy)
                .circuitMeta(6)
                .outputs(GTSharpMetaBlocks.INFINITE_MINER_CASING.getItemVariant(BlockInfiniteCasing.CasingType.INFINITE_MINER_CASING, 2))
                .duration(50).buildAndRegister();
        if (GTSharpConfigHolder.globalMultiblocks.enableLargeRockFactory) ASSEMBLER_RECIPES.recipeBuilder()
                .input(OrePrefix.plate, GCYMMaterials.TitaniumTungstenCarbide, 6)
                .input(OrePrefix.frameGt, Materials.TungstenSteel)
                .notConsumable(new IntCircuitIngredient(6))
                .outputs(GTSharpMetaBlocks.BREAK_PROOF_CASING
                        .getItemVariant(BlockBreakProof.CasingType.BREAK_PROOF_CASING, 2))
                .duration(50).EUt(16).buildAndRegister();
        if (GTSharpConfigHolder.globalMultiblocks.enableInfiniteMiner) ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy, 1)
                .input(circuit, MarkerMaterials.Tier.ZPM, 2)
                .input(ELECTRIC_MOTOR_ZPM, 4)
                .input(CONVEYOR_MODULE_ZPM, 4)
                .input(gear, NaquadahAlloy, 4)
                .circuitMeta(2)
                .output(GTSharpMetaBlocks.VOID_CASING, 2)
                .duration(400).EUt(VA[ZPM]).buildAndRegister();
        if (GTSharpConfigHolder.globalMultiblocks.enableInfiniteMiner) ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(GTSharpMetaBlocks.VOID_CASING)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(plateDouble, NaquadahAlloy, 6)
                .input(FIELD_GENERATOR_ZPM, 2)
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 64)
                .input(wireGtSingle, UraniumRhodiumDinaquadide, 32)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(NiobiumTitanium.getFluid(L * 8))
                .outputs(GTSharpMetaTileEntities.BASIC_INFINITE_MINER.getStackForm())
                .stationResearch(b -> b
                        .researchStack(ADVANCED_LARGE_MINER.getStackForm())
                        .CWUt(16)
                        .EUt(VA[ZPM]))
                .duration(800).EUt(VA[ZPM]).buildAndRegister();

    }
}
