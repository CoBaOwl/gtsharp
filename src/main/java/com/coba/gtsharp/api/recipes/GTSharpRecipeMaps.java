package com.coba.gtsharp.api.recipes;

import gregtech.api.gui.GuiTextures;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.AssemblerRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;

public final class GTSharpRecipeMaps {

    public static final RecipeMap<AssemblerRecipeBuilder> LARGE_CABLE_MILL_RECIPES = new RecipeMap<>("large_cable_factory", 2, 1,
            3, 0, new AssemblerRecipeBuilder(), false)
                    .setSound(GTSoundEvents.ASSEMBLER);

    private GTSharpRecipeMaps() {}
}
