package com.coba.gtsharp.loaders.recipe;

import com.coba.gtsharp.api.recipes.GTSharpRecipeMaps;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.DustProperty;
import gregtech.api.unification.material.properties.IMaterialProperty;
import gregtech.api.unification.material.properties.IngotProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.GTUtility;
import gregtech.common.items.MetaItems;
import gregtech.loaders.recipe.handlers.MaterialRecipeHandler;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.Lubricant;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class GTSharpLargeExtrusionHandler {


    public static void register() {
        OrePrefix.pipeTinyFluid.addProcessingHandler(PropertyKey.FLUID_PIPE, GTSharpLargeExtrusionHandler::processPipeTiny);
        OrePrefix.pipeSmallFluid.addProcessingHandler(PropertyKey.FLUID_PIPE, GTSharpLargeExtrusionHandler::processPipeSmall);
        OrePrefix.pipeNormalFluid.addProcessingHandler(PropertyKey.FLUID_PIPE, GTSharpLargeExtrusionHandler::processPipeNormal);
        OrePrefix.pipeLargeFluid.addProcessingHandler(PropertyKey.FLUID_PIPE, GTSharpLargeExtrusionHandler::processPipeLarge);
        OrePrefix.pipeHugeFluid.addProcessingHandler(PropertyKey.FLUID_PIPE, GTSharpLargeExtrusionHandler::processPipeHuge);

        OrePrefix.pipeTinyItem.addProcessingHandler(PropertyKey.ITEM_PIPE, GTSharpLargeExtrusionHandler::processPipeTiny);
        OrePrefix.pipeSmallItem.addProcessingHandler(PropertyKey.ITEM_PIPE, GTSharpLargeExtrusionHandler::processPipeSmall);
        OrePrefix.pipeNormalItem.addProcessingHandler(PropertyKey.ITEM_PIPE, GTSharpLargeExtrusionHandler::processPipeNormal);
        OrePrefix.pipeLargeItem.addProcessingHandler(PropertyKey.ITEM_PIPE, GTSharpLargeExtrusionHandler::processPipeLarge);
        OrePrefix.pipeHugeItem.addProcessingHandler(PropertyKey.ITEM_PIPE, GTSharpLargeExtrusionHandler::processPipeHuge);

        OrePrefix.ingot.addProcessingHandler(PropertyKey.INGOT, GTSharpLargeExtrusionHandler::processIngot);
        OrePrefix.stickLong.addProcessingHandler(PropertyKey.DUST, GTSharpLargeExtrusionHandler::processLongStick);
        OrePrefix.rotor.addProcessingHandler(PropertyKey.INGOT, GTSharpLargeExtrusionHandler::processRotor);
        OrePrefix.bolt.addProcessingHandler(PropertyKey.DUST, GTSharpLargeExtrusionHandler::processBolt);
        OrePrefix.wireFine.addProcessingHandler(PropertyKey.INGOT, GTSharpLargeExtrusionHandler::processFineWire);
        OrePrefix.foil.addProcessingHandler(PropertyKey.INGOT, GTSharpLargeExtrusionHandler::processFoil);
        OrePrefix.gear.addProcessingHandler(PropertyKey.DUST, GTSharpLargeExtrusionHandler::processGear);
        OrePrefix.gearSmall.addProcessingHandler(PropertyKey.DUST, GTSharpLargeExtrusionHandler::processGear);
        OrePrefix.ring.addProcessingHandler(PropertyKey.INGOT, GTSharpLargeExtrusionHandler::processRing);
        OrePrefix.block.addProcessingHandler(PropertyKey.DUST, GTSharpLargeExtrusionHandler::processBlock);

    }

    private static void processBlock(OrePrefix blockPrefix, Material material, DustProperty dustProperty) {
        ItemStack blockStack = OreDictUnifier.get(blockPrefix, material);
        long materialAmount = blockPrefix.getMaterialAmount(material);

        if (!material.hasFlag(EXCLUDE_BLOCK_CRAFTING_RECIPES)) {
            if (material.hasProperty(PropertyKey.INGOT)) {
                int voltageMultiplier = getVoltageMultiplier(material);
                GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                        .input(OrePrefix.ingot, material, (int) (materialAmount / M))
                        .notConsumable(MetaItems.SHAPE_EXTRUDER_BLOCK)
                        .fluidInputs(Lubricant.getFluid(90))
                        .outputs(blockStack)
                        .duration(10).EUt(8 * voltageMultiplier)
                        .buildAndRegister();
            }
        }
    }

    private static void processRing(OrePrefix ringPrefix, Material material, IngotProperty ingotProperty) {
        GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .input(OrePrefix.ingot, material)
                .notConsumable(MetaItems.SHAPE_EXTRUDER_RING)
                .fluidInputs(Lubricant.getFluid(10))
                .outputs(OreDictUnifier.get(ringPrefix, material, 4))
                .duration((int) material.getMass() * 2)
                .EUt(6 * getVoltageMultiplier(material))
                .buildAndRegister();

        if (material.hasFlag(NO_SMASHING)) {
            GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                    .input(OrePrefix.dust, material)
                    .notConsumable(MetaItems.SHAPE_EXTRUDER_RING)
                    .fluidInputs(Lubricant.getFluid(10))
                    .outputs(OreDictUnifier.get(ringPrefix, material, 4))
                    .duration((int) material.getMass() * 2)
                    .EUt(6 * getVoltageMultiplier(material))
                    .buildAndRegister();
        }
    }

    private static void processGear(OrePrefix gearPrefix, Material material, DustProperty dustProperty) {
        ItemStack stack = OreDictUnifier.get(gearPrefix, material);
        if (gearPrefix == OrePrefix.gear && material.hasProperty(PropertyKey.INGOT)) {
            int voltageMultiplier = getVoltageMultiplier(material);
            GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                    .input(OrePrefix.ingot, material, 4)
                    .notConsumable(MetaItems.SHAPE_EXTRUDER_GEAR)
                    .fluidInputs(Lubricant.getFluid(40))
                    .outputs(OreDictUnifier.get(gearPrefix, material))
                    .duration((int) material.getMass() * 5)
                    .EUt(8 * voltageMultiplier)
                    .buildAndRegister();

            if (material.hasFlag(NO_SMASHING)) {
                GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                        .input(OrePrefix.dust, material, 4)
                        .notConsumable(MetaItems.SHAPE_EXTRUDER_GEAR)
                        .fluidInputs(Lubricant.getFluid(40))
                        .outputs(OreDictUnifier.get(gearPrefix, material))
                        .duration((int) material.getMass() * 5)
                        .EUt(8 * voltageMultiplier)
                        .buildAndRegister();
            }
        }

        if (material.hasFlag(GENERATE_PLATE) && material.hasFlag(GENERATE_ROD)) {
            if (gearPrefix == OrePrefix.gearSmall) {
                GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                        .input(OrePrefix.ingot, material)
                        .notConsumable(MetaItems.SHAPE_EXTRUDER_GEAR_SMALL)
                        .fluidInputs(Lubricant.getFluid(10))
                        .outputs(stack)
                        .duration((int) material.getMass())
                        .EUt(material.getBlastTemperature() >= 2800 ? 256 : 64)
                        .buildAndRegister();

                if (material.hasFlag(NO_SMASHING)) {
                    GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                            .input(OrePrefix.dust, material)
                            .notConsumable(MetaItems.SHAPE_EXTRUDER_GEAR_SMALL)
                            .fluidInputs(Lubricant.getFluid(10))
                            .outputs(stack)
                            .duration((int) material.getMass())
                            .EUt(material.getBlastTemperature() >= 2800 ? 256 : 64)
                            .buildAndRegister();
                }
            }
        }

    }

    private static void processFoil(OrePrefix foilPrefix, Material material, IngotProperty ingotProperty) {
        if (material.hasFlag(NO_SMASHING)) {
            GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                    .input(ingot, material)
                    .notConsumable(MetaItems.SHAPE_EXTRUDER_FOIL)
                    .fluidInputs(Lubricant.getFluid(10))
                    .output(foilPrefix, material, 4)
                    .duration((int) material.getMass())
                    .EUt(24)
                    .buildAndRegister();

            GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                    .input(dust, material)
                    .notConsumable(MetaItems.SHAPE_EXTRUDER_FOIL)
                    .fluidInputs(Lubricant.getFluid(10))
                    .output(foilPrefix, material, 4)
                    .duration((int) material.getMass())
                    .EUt(24)
                    .buildAndRegister();
        }

    }

    private static void processFineWire(OrePrefix orePrefix, Material material, IngotProperty ingotProperty) {
    }

    private static void processBolt(OrePrefix boltPrefix, Material material, DustProperty dustProperty) {
        ItemStack boltStack = OreDictUnifier.get(boltPrefix, material);
        ItemStack ingotStack = OreDictUnifier.get(OrePrefix.ingot, material);
        if (!boltStack.isEmpty() && !ingotStack.isEmpty()) {
            GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                    .input(OrePrefix.ingot, material)
                    .notConsumable(MetaItems.SHAPE_EXTRUDER_BOLT)
                    .fluidInputs(Lubricant.getFluid(10))
                    .outputs(GTUtility.copy(8, boltStack))
                    .duration(15)
                    .EUt(VA[MV])
                    .buildAndRegister();

            if (material.hasFlag(NO_SMASHING)) {
                GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                        .input(OrePrefix.dust, material)
                        .notConsumable(MetaItems.SHAPE_EXTRUDER_BOLT)
                        .fluidInputs(Lubricant.getFluid(10))
                        .outputs(GTUtility.copy(8, boltStack))
                        .duration(15)
                        .EUt(VA[MV])
                        .buildAndRegister();
            }
        }
    }

    private static void processRotor(OrePrefix rotorPrefix, Material material, IngotProperty ingotProperty) {
        ItemStack stack = OreDictUnifier.get(rotorPrefix, material);

        GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                .input(ingot, material, 4)
                .notConsumable(MetaItems.SHAPE_EXTRUDER_ROTOR)
                .fluidInputs(Lubricant.getFluid(40))
                .outputs(GTUtility.copy(stack))
                .duration((int) material.getMass() * 4)
                .EUt(material.getBlastTemperature() >= 2800 ? 256 : 64)
                .buildAndRegister();

        if (material.hasFlag(NO_SMASHING)) {
            GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                    .input(dust, material, 4)
                    .notConsumable(MetaItems.SHAPE_EXTRUDER_ROTOR)
                    .fluidInputs(Lubricant.getFluid(40))
                    .outputs(GTUtility.copy(stack))
                    .duration((int) material.getMass() * 4)
                    .EUt(material.getBlastTemperature() >= 2800 ? 256 : 64)
                    .buildAndRegister();
        }
    }

    private static void processLongStick(OrePrefix longStickPrefix, Material material, DustProperty dustProperty) {
        ItemStack stack = OreDictUnifier.get(longStickPrefix, material);

        if (material.hasProperty(PropertyKey.INGOT)) {
            GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                    .input(OrePrefix.ingot, material)
                    .notConsumable(MetaItems.SHAPE_EXTRUDER_ROD_LONG)
                    .fluidInputs(Lubricant.getFluid(10))
                    .outputs(stack)
                    .duration((int) Math.max(material.getMass(), 1L))
                    .EUt(64)
                    .buildAndRegister();

            if (material.hasFlag(NO_SMASHING)) {
                GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                        .input(OrePrefix.dust, material)
                        .notConsumable(MetaItems.SHAPE_EXTRUDER_ROD_LONG)
                        .fluidInputs(Lubricant.getFluid(10))
                        .outputs(stack)
                        .duration((int) Math.max(material.getMass(), 1L))
                        .EUt(64)
                        .buildAndRegister();
            }
        }
    }

    private static void processIngot(OrePrefix ingotPrefix, Material material, IngotProperty property) {

        if (material.hasFlag(GENERATE_ROD)) {
            if (!material.hasFlag(NO_WORKING)) {
                GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                        .input(ingotPrefix, material)
                        .notConsumable(MetaItems.SHAPE_EXTRUDER_ROD)
                        .fluidInputs(Lubricant.getFluid(10))
                        .outputs(OreDictUnifier.get(OrePrefix.stick, material, 2))
                        .duration((int) material.getMass() * 2)
                        .EUt(6 * getVoltageMultiplier(material))
                        .buildAndRegister();
            }
        }

        if (material.hasFlag(NO_SMASHING)) {
            GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                    .input(OrePrefix.dust, material)
                    .notConsumable(MetaItems.SHAPE_EXTRUDER_INGOT)
                    .fluidInputs(Lubricant.getFluid(10))
                    .outputs(OreDictUnifier.get(OrePrefix.ingot, material))
                    .duration(10)
                    .EUt(4 * getVoltageMultiplier(material))
                    .buildAndRegister();
        }

        int voltageMultiplier = getVoltageMultiplier(material);
        if (material.hasFlag(GENERATE_PLATE) && !material.hasFlag(NO_WORKING)) {
            if (!OreDictUnifier.get(plate, material).isEmpty()) {
                RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                        .input(ingotPrefix, material)
                        .notConsumable(MetaItems.SHAPE_EXTRUDER_PLATE)
                        .outputs(OreDictUnifier.get(OrePrefix.plate, material))
                        .duration((int) material.getMass())
                        .EUt(8 * voltageMultiplier)
                        .buildAndRegister();

                if (material.hasFlag(NO_SMASHING)) {
                    RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                            .input(dust, material)
                            .notConsumable(MetaItems.SHAPE_EXTRUDER_PLATE)
                            .outputs(OreDictUnifier.get(OrePrefix.plate, material))
                            .duration((int) material.getMass())
                            .EUt(8 * voltageMultiplier)
                            .buildAndRegister();
                }
            }
        }
    }

    public static void processPipeTiny(OrePrefix pipePrefix, Material material, IMaterialProperty property) {
        ItemStack pipeStack = OreDictUnifier.get(pipePrefix, material);

        // Some pipes like wood do not have an ingot
        if (material.hasProperty(PropertyKey.INGOT)) {
            GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                    .input(OrePrefix.ingot, material, 1)
                    .notConsumable(MetaItems.SHAPE_EXTRUDER_PIPE_TINY)
                    .fluidInputs(Lubricant.getFluid(10))
                    .outputs(GTUtility.copy(2, pipeStack))
                    .duration((int) (material.getMass()))
                    .EUt(6 * getVoltageMultiplier(material))
                    .buildAndRegister();
        }

        if (material.hasFlag(NO_SMASHING)) {
            GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                    .input(OrePrefix.dust, material, 1)
                    .notConsumable(MetaItems.SHAPE_EXTRUDER_PIPE_TINY)
                    .fluidInputs(Lubricant.getFluid(10))
                    .outputs(GTUtility.copy(2, pipeStack))
                    .duration((int) (material.getMass()))
                    .EUt(6 * getVoltageMultiplier(material))
                    .buildAndRegister();
        }
    }

    public static void processPipeSmall(OrePrefix pipePrefix, Material material, IMaterialProperty property) {
        ItemStack pipeStack = OreDictUnifier.get(pipePrefix, material);

        if (material.hasProperty(PropertyKey.INGOT)) {
            GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                    .input(OrePrefix.ingot, material, 1)
                    .notConsumable(MetaItems.SHAPE_EXTRUDER_PIPE_SMALL)
                    .fluidInputs(Lubricant.getFluid(10))
                    .outputs(pipeStack)
                    .duration((int) (material.getMass()))
                    .EUt(6 * getVoltageMultiplier(material))
                    .buildAndRegister();
        }

        if (material.hasFlag(NO_SMASHING)) {
            GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                    .input(OrePrefix.dust, material, 1)
                    .notConsumable(MetaItems.SHAPE_EXTRUDER_PIPE_SMALL)
                    .fluidInputs(Lubricant.getFluid(10))
                    .outputs(pipeStack)
                    .duration((int) (material.getMass()))
                    .EUt(6 * getVoltageMultiplier(material))
                    .buildAndRegister();
        }
    }

    public static void processPipeNormal(OrePrefix pipePrefix, Material material, IMaterialProperty property) {
        ItemStack pipeStack = OreDictUnifier.get(pipePrefix, material);

        if (material.hasProperty(PropertyKey.INGOT)) {
            GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                    .input(OrePrefix.ingot, material, 3)
                    .notConsumable(MetaItems.SHAPE_EXTRUDER_PIPE_NORMAL)
                    .fluidInputs(Lubricant.getFluid(30))
                    .outputs(pipeStack)
                    .duration((int) material.getMass() * 3)
                    .EUt(6 * getVoltageMultiplier(material))
                    .buildAndRegister();
        }

        if (material.hasFlag(NO_SMASHING)) {
            GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                    .input(OrePrefix.dust, material, 3)
                    .notConsumable(MetaItems.SHAPE_EXTRUDER_PIPE_NORMAL)
                    .fluidInputs(Lubricant.getFluid(30))
                    .outputs(pipeStack)
                    .duration((int) material.getMass() * 3)
                    .EUt(6 * getVoltageMultiplier(material))
                    .buildAndRegister();
        }
    }

    public static void processPipeLarge(OrePrefix pipePrefix, Material material, IMaterialProperty property) {
        ItemStack pipeStack = OreDictUnifier.get(pipePrefix, material);

        if (material.hasProperty(PropertyKey.INGOT)) {
            GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                    .input(OrePrefix.ingot, material, 6)
                    .notConsumable(MetaItems.SHAPE_EXTRUDER_PIPE_LARGE)
                    .fluidInputs(Lubricant.getFluid(60))
                    .outputs(pipeStack)
                    .duration((int) material.getMass() * 6)
                    .EUt(6 * getVoltageMultiplier(material))
                    .buildAndRegister();
        }

        if (material.hasFlag(NO_SMASHING)) {
            GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                    .input(OrePrefix.dust, material, 6)
                    .notConsumable(MetaItems.SHAPE_EXTRUDER_PIPE_LARGE)
                    .fluidInputs(Lubricant.getFluid(60))
                    .outputs(pipeStack)
                    .duration((int) material.getMass() * 6)
                    .EUt(6 * getVoltageMultiplier(material))
                    .buildAndRegister();
        }
    }

    public static void processPipeHuge(OrePrefix pipePrefix, Material material, IMaterialProperty property) {
        ItemStack pipeStack = OreDictUnifier.get(pipePrefix, material);

        if (material.hasProperty(PropertyKey.INGOT)) {
            GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                    .input(OrePrefix.ingot, material, 12)
                    .notConsumable(MetaItems.SHAPE_EXTRUDER_PIPE_HUGE)
                    .fluidInputs(Lubricant.getFluid(120))
                    .outputs(pipeStack)
                    .duration((int) material.getMass() * 24)
                    .EUt(6 * getVoltageMultiplier(material))
                    .buildAndRegister();
        }

        if (material.hasFlag(NO_SMASHING)) {
            GTSharpRecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
                    .input(OrePrefix.dust, material, 12)
                    .notConsumable(MetaItems.SHAPE_EXTRUDER_PIPE_HUGE)
                    .fluidInputs(Lubricant.getFluid(120))
                    .outputs(pipeStack)
                    .duration((int) material.getMass() * 24)
                    .EUt(6 * getVoltageMultiplier(material))
                    .buildAndRegister();
        }
    }



    private static int getVoltageMultiplier(Material material) {
        return material.getBlastTemperature() >= 2800 ? VA[LV] : VA[ULV];
    }

}
