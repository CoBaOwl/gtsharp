package com.coba.gtsharp.loaders.recipe;

import com.coba.gtsharp.api.recipes.GTSharpRecipeMaps;
import gregtech.api.GTValues;
import gregtech.api.items.armor.ArmorMetaItem;
import gregtech.api.items.metaitem.MetaItem.MetaValueItem;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.category.RecipeCategories;
import gregtech.api.recipes.ingredients.nbtmatch.NBTCondition;
import gregtech.api.recipes.ingredients.nbtmatch.NBTMatcher;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.MarkerMaterials.Color;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.loaders.recipe.CraftingComponent;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class GTSharpMiscRecipeLoader {

    public static void init() {
        GTSharpRecipeMaps.ROCK_FACTORY_RECIPES.recipeBuilder()
                .notConsumable(Water.getFluid(1000))
                .notConsumable(Lava.getFluid(1000))
                .notConsumable(new ItemStack(Blocks.COBBLESTONE))
                .outputs(new ItemStack(Blocks.COBBLESTONE))
                .duration(16)
                .EUt(VA[ULV])
                .buildAndRegister();

        GTSharpRecipeMaps.ROCK_FACTORY_RECIPES.recipeBuilder()
                .notConsumable(Water.getFluid(1000))
                .notConsumable(Lava.getFluid(1000))
                .notConsumable(new ItemStack(Blocks.STONE, 1, 0))
                .outputs(new ItemStack(Blocks.STONE, 1, 0))
                .duration(16)
                .EUt(VA[ULV])
                .buildAndRegister();

        GTSharpRecipeMaps.ROCK_FACTORY_RECIPES.recipeBuilder()
                .notConsumable(Water.getFluid(1000))
                .notConsumable(Lava.getFluid(1000))
                .notConsumable(stone, Andesite)
                .output(stone, Andesite)
                .duration(16)
                .EUt(60)
                .buildAndRegister();

        GTSharpRecipeMaps.ROCK_FACTORY_RECIPES.recipeBuilder()
                .notConsumable(Water.getFluid(1000))
                .notConsumable(Lava.getFluid(1000))
                .notConsumable(stone, Granite)
                .output(stone, Granite)
                .duration(16)
                .EUt(60)
                .buildAndRegister();

        GTSharpRecipeMaps.ROCK_FACTORY_RECIPES.recipeBuilder()
                .notConsumable(Water.getFluid(1000))
                .notConsumable(Lava.getFluid(1000))
                .notConsumable(stone, Diorite)
                .output(stone, Diorite)
                .duration(16)
                .EUt(60)
                .buildAndRegister();

        GTSharpRecipeMaps.ROCK_FACTORY_RECIPES.recipeBuilder()
                .notConsumable(Water.getFluid(1000))
                .notConsumable(Lava.getFluid(1000))
                .notConsumable(dust, Redstone)
                .outputs(new ItemStack(Blocks.OBSIDIAN, 1))
                .duration(16)
                .EUt(240)
                .buildAndRegister();

        GTSharpRecipeMaps.ROCK_FACTORY_RECIPES.recipeBuilder()
                .notConsumable(Water.getFluid(1000))
                .notConsumable(Lava.getFluid(1000))
                .notConsumable(stone, Marble)
                .output(stone, Marble)
                .duration(16)
                .EUt(240)
                .buildAndRegister();

        GTSharpRecipeMaps.ROCK_FACTORY_RECIPES.recipeBuilder()
                .notConsumable(Water.getFluid(1000))
                .notConsumable(Lava.getFluid(1000))
                .notConsumable(stone, Basalt)
                .output(stone, Basalt)
                .duration(16)
                .EUt(240)
                .buildAndRegister();

        GTSharpRecipeMaps.ROCK_FACTORY_RECIPES.recipeBuilder()
                .notConsumable(Water.getFluid(1000))
                .notConsumable(Lava.getFluid(1000))
                .notConsumable(stone, GraniteRed)
                .output(stone, GraniteRed)
                .duration(16)
                .EUt(960)
                .buildAndRegister();

        GTSharpRecipeMaps.ROCK_FACTORY_RECIPES.recipeBuilder()
                .notConsumable(Water.getFluid(1000))
                .notConsumable(Lava.getFluid(1000))
                .notConsumable(stone, GraniteBlack)
                .output(stone, GraniteBlack)
                .duration(16)
                .EUt(960)
                .buildAndRegister();

        GTSharpRecipeMaps.ROCK_FACTORY_RECIPES.recipeBuilder()
                .notConsumable(LiquidEnderAir.getFluid(1000))
                .notConsumable(Lava.getFluid(1000))
                .notConsumable(stone, Endstone)
                .outputs(new ItemStack(Blocks.END_STONE))
                .duration(16)
                .EUt(3600)
                .buildAndRegister();

        GTSharpRecipeMaps.ROCK_FACTORY_RECIPES.recipeBuilder()
                .notConsumable(Water.getFluid(1000))
                .notConsumable(Blaze.getFluid(1000))
                .notConsumable(stone, Netherrack)
                .outputs(new ItemStack(Blocks.NETHERRACK))
                .duration(16)
                .EUt(3600)
                .buildAndRegister();
    }
}
