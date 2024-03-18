package com.coba.gtsharp.api.capability.impl.miner;

import gregtech.api.worldgen.config.OreDepositDefinition;
import gregtech.api.worldgen.config.WorldGenRegistry;

import java.util.List;

public class GTSharpDimensionOres {
    public static List<OreDepositDefinition> ORES = WorldGenRegistry.getOreDeposits();


    public GTSharpDimensionOres(int dimension) {
    }
}
