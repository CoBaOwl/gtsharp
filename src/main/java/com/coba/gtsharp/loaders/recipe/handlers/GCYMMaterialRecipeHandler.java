package com.coba.gtsharp.loaders.recipe.handlers;

import gregicality.multiblocks.api.unification.properties.AlloyBlastProperty;
import gregicality.multiblocks.api.unification.properties.GCYMPropertyKey;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class GCYMMaterialRecipeHandler {

    private GCYMMaterialRecipeHandler() {}

    public static void register() {
        OrePrefix.ingot.addProcessingHandler(GCYMPropertyKey.ALLOY_BLAST,
                GCYMMaterialRecipeHandler::generateAlloyBlastRecipes);
    }

    /**
     * Generates alloy blast recipes for a material
     *
     * @param material the material to generate for
     * @param property the blast property of the material
     */
    public static void generateAlloyBlastRecipes(@Nullable OrePrefix unused, @NotNull Material material,
                                                 @NotNull AlloyBlastProperty property) {
        if (material.hasProperty(PropertyKey.BLAST)) {
            property.getRecipeProducer().produce(material, material.getProperty(PropertyKey.BLAST));
        }
    }
}
