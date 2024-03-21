package com.coba.gtsharp.loaders.recipe;

import com.coba.gtsharp.api.recipes.GTSharpRecipeMaps;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.properties.*;
import gregtech.api.unification.ore.OrePrefix;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class GTSharpMaterialRecipeHandler {

    public static void register() {
        OrePrefix.dust.addProcessingHandler(PropertyKey.DUST, GTSharpMaterialRecipeHandler::processDust);
    }

    public static void processDust(OrePrefix dustPrefix, Material mat, DustProperty property) {
        if (mat.hasProperty(PropertyKey.GEM)) {

            if (!mat.hasFlag(EXPLOSIVE) && !mat.hasFlag(FLAMMABLE)) {
                GTSharpRecipeMaps.ELECTRIC_IMPLOSION_COMPRESSOR_RECIPES.recipeBuilder()
                        .input(dustPrefix, mat, 4)
                        .output(OrePrefix.gem, mat, 3)
                        .chancedOutput(dust, Materials.DarkAsh, 2500, 0)
                        .duration(60)
                        .EUt(VA[IV])
                        .buildAndRegister();
            }
        }
    }
}
