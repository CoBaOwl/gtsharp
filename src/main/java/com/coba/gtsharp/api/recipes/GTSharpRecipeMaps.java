package com.coba.gtsharp.api.recipes;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.AssemblerRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;
import net.minecraft.init.SoundEvents;

public final class GTSharpRecipeMaps {

    public static final RecipeMap<AssemblerRecipeBuilder> LARGE_CABLE_MILL_RECIPES = new RecipeMap<>("large_cable_factory", 2, 1,
            3, 0, new AssemblerRecipeBuilder(), false)
                    .setSound(GTSoundEvents.ASSEMBLER);

    public static final RecipeMap<SimpleRecipeBuilder> INFINITE_MINER_RECIPES = new RecipeMap<>("infinite_miner_factory", 1, 3,
            1, 0, new SimpleRecipeBuilder(), false)
            .setSound(GTSoundEvents.MINER);

    public static final RecipeMap<SimpleRecipeBuilder> ELECTRIC_IMPLOSION_COMPRESSOR_RECIPES = new RecipeMap<>("electric_implosion_compressor", 1, 2,
            0, 0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.IMPLOSION_OVERLAY_1)
            .setSlotOverlay(false, false, false, GuiTextures.IMPLOSION_OVERLAY_2)
            .setSound(SoundEvents.ENTITY_GENERIC_EXPLODE);

    public static final RecipeMap<SimpleRecipeBuilder> ROCK_FACTORY_RECIPES = new RecipeMap<>("rock_factory", 1, 4,
            2, 0, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(false, false, false, GuiTextures.CRUSHED_ORE_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MACERATE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.FIRE);


    private GTSharpRecipeMaps() {}
}
