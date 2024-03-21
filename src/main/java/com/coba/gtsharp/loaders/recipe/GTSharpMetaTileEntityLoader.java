package com.coba.gtsharp.loaders.recipe;

import com.coba.gtsharp.common.block.GTSharpMetaBlocks;
import com.coba.gtsharp.common.block.blocks.BlockInfiniteCasing;
import com.coba.gtsharp.multiblock.GTSharpMetaTileEntities;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
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
import static gregtech.common.blocks.BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL;
import static gregtech.common.blocks.MetaBlocks.FUSION_CASING;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;

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
        ModHandler.addShapedRecipe(true, "infinite_miner_casing", GTSharpMetaBlocks.INFINITE_MINER_CASING.getItemVariant(BlockInfiniteCasing.CasingType.INFINITE_MINER_CASING, 2),
                "PhP", "PFP", "PwP", 'P',
                new UnificationEntry(OrePrefix.plate, Materials.NaquadahAlloy), 'F',
                new UnificationEntry(OrePrefix.frameGt, Materials.NaquadahAlloy));
        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(VA[UV])
                .input(plate, NaquadahAlloy, 6)
                .input(frameGt, NaquadahAlloy)
                .circuitMeta(6)
                .outputs(GTSharpMetaBlocks.INFINITE_MINER_CASING.getItemVariant(BlockInfiniteCasing.CasingType.INFINITE_MINER_CASING, 2))
                .duration(50).buildAndRegister();
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy, 1)
                .input(circuit, MarkerMaterials.Tier.ZPM, 2)
                .input(ELECTRIC_MOTOR_ZPM, 4)
                .input(CONVEYOR_MODULE_ZPM, 4)
                .input(gear, NaquadahAlloy, 4)
                .circuitMeta(2)
                .output(GTSharpMetaBlocks.VOID_CASING, 2)
                .duration(400).EUt(VA[ZPM]).buildAndRegister();
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
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
