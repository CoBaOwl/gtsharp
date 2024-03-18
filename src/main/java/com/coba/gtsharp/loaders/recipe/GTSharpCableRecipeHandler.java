package com.coba.gtsharp.loaders.recipe;

import com.google.common.collect.ImmutableMap;
import gregtech.api.GTValues;
import gregtech.api.recipes.builders.AssemblerRecipeBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.material.properties.WireProperties;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.GTUtility;

import java.util.Map;


import static com.coba.gtsharp.api.recipes.GTSharpRecipeMaps.LARGE_CABLE_MILL_RECIPES;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.Materials.StyreneButadieneRubber;
import static gregtech.api.unification.ore.OrePrefix.*;

public class GTSharpCableRecipeHandler {

    private static final Map<OrePrefix, Integer> INSULATION_AMOUNT = ImmutableMap.of(
            cableGtSingle, 1,
            cableGtDouble, 1,
            cableGtQuadruple, 2,
            cableGtOctal, 3,
            cableGtHex, 5);
    private static final Map<OrePrefix, Double> OUT_AMOUNT = ImmutableMap.of(
            cableGtSingle, 2.0,
            cableGtDouble, 1.0,
            cableGtQuadruple, 0.5,
            cableGtOctal, 0.25,
            cableGtHex, 0.125);

    private static final Map<OrePrefix, Integer> CABLE_SIZES = ImmutableMap.of(
            cableGtSingle, 1,
            cableGtDouble, 2,
            cableGtQuadruple, 4,
            cableGtOctal, 8,
            cableGtHex, 16
    );

    public static void register() {
        // Generate Cable Covering Recipes
        wireGtSingle.addProcessingHandler(PropertyKey.WIRE, GTSharpCableRecipeHandler::generateCableCovering);
        wireGtDouble.addProcessingHandler(PropertyKey.WIRE, GTSharpCableRecipeHandler::generateCableCovering);
        wireGtQuadruple.addProcessingHandler(PropertyKey.WIRE, GTSharpCableRecipeHandler::generateCableCovering);
        wireGtOctal.addProcessingHandler(PropertyKey.WIRE, GTSharpCableRecipeHandler::generateCableCovering);
        wireGtHex.addProcessingHandler(PropertyKey.WIRE, GTSharpCableRecipeHandler::generateCableCovering);
    }

    public static void generateCableCovering(OrePrefix wirePrefix, Material material, WireProperties property) {
        // Superconductors have no Cables, so exit early
        if (property.isSuperconductor()) return;

        OrePrefix cablePrefix = OrePrefix.getPrefix("cable" + wirePrefix.name().substring(4));
        OrePrefix inputItemPrefix = material.hasProperty(PropertyKey.INGOT) ? ingot : dust;

        int voltageTier = GTUtility.getTierByVoltage(property.getVoltage());
        int insulationAmount = INSULATION_AMOUNT.get(cablePrefix);
        int cableAmount = 1;
        int ingotAmount = (int) (1.0 / OUT_AMOUNT.get(cablePrefix));
        int euT = getVoltageMultiplier(material);
        if (ingotAmount == 0) {
            ingotAmount = 1;
            cableAmount = 2;
        }
        int recipeDuration = (int) material.getMass() * ingotAmount;

        // Rubber Recipe (ULV-EV cables)
        if (voltageTier <= GTValues.EV) {
            AssemblerRecipeBuilder builder = LARGE_CABLE_MILL_RECIPES.recipeBuilder()
                    .EUt(euT)
                    .duration(recipeDuration)
                    .circuitMeta(CABLE_SIZES.get(cablePrefix))
                    .input(inputItemPrefix, material, ingotAmount)
                    .output(cablePrefix, material, cableAmount)
                    .fluidInputs(Rubber.getFluid(GTValues.L * cableAmount * insulationAmount));

            if (voltageTier == GTValues.EV) {
                builder.fluidInputs(PolyvinylChloride.getFluid(GTValues.L * cableAmount * insulationAmount / 4));
            }
            builder.buildAndRegister();
        }

        // Silicone Rubber Recipe (all cables)
        AssemblerRecipeBuilder builder = LARGE_CABLE_MILL_RECIPES.recipeBuilder()
                .EUt(euT)
                .duration(recipeDuration)
                .circuitMeta(CABLE_SIZES.get(cablePrefix))
                .input(inputItemPrefix, material, ingotAmount)
                .output(cablePrefix, material, cableAmount);

        // Apply a Polyphenylene Sulfate Foil if LuV or above.
        if (voltageTier >= GTValues.LuV) {
            builder.fluidInputs(PolyphenyleneSulfide.getFluid(GTValues.L * cableAmount * insulationAmount / 4));
        }

        // Apply a PVC Foil if EV or above.
        if (voltageTier >= GTValues.EV) {
            builder.fluidInputs(PolyvinylChloride.getFluid(GTValues.L * cableAmount * insulationAmount / 4));
        }

        builder.fluidInputs(SiliconeRubber.getFluid(GTValues.L * cableAmount * insulationAmount / 2))
                .buildAndRegister();

        // Styrene Butadiene Rubber Recipe (all cables)
        builder = LARGE_CABLE_MILL_RECIPES.recipeBuilder()
                .EUt(euT)
                .duration(recipeDuration)
                .circuitMeta(CABLE_SIZES.get(cablePrefix))
                .input(inputItemPrefix, material, ingotAmount)
                .output(cablePrefix, material, cableAmount);

        // Apply a Polyphenylene Sulfate Foil if LuV or above.
        if (voltageTier >= GTValues.LuV) {
            builder.fluidInputs(PolyphenyleneSulfide.getFluid(GTValues.L * cableAmount * insulationAmount / 4));
        }

        // Apply a PVC Foil if EV or above.
        if (voltageTier >= GTValues.EV) {
            builder.fluidInputs(PolyvinylChloride.getFluid(GTValues.L * cableAmount * insulationAmount / 4));
        }

        builder.fluidInputs(StyreneButadieneRubber.getFluid(GTValues.L * cableAmount * insulationAmount / 4))
                .buildAndRegister();
    }

    private static int getVoltageMultiplier(Material material) {
        return material.getBlastTemperature() >= 2800 ? VA[LV] : VA[ULV];
    }

}
