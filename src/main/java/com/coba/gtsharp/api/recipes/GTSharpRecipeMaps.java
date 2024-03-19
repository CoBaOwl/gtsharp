package com.coba.gtsharp.api.recipes;

import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.AssemblerRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;

public final class GTSharpRecipeMaps {

    public static final RecipeMap<AssemblerRecipeBuilder> LARGE_CABLE_MILL_RECIPES = new RecipeMap<>("large_cable_factory", 2, 1,
            3, 0, new AssemblerRecipeBuilder(), false)
                    .setSound(GTSoundEvents.ASSEMBLER);

    public static final RecipeMap<SimpleRecipeBuilder> INFINITE_MINER_RECIPES = new RecipeMap<>("infinite_miner_factory", 1, 3,
            1, 0, new SimpleRecipeBuilder(), false)
            .setSound(GTSoundEvents.MINER);
    private GTSharpRecipeMaps() {}
}
