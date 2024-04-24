package com.coba.gtsharp.multiblock;

import com.coba.gtsharp.common.GTSharpConfigHolder;
import com.coba.gtsharp.multiblock.standart.*;


import static com.coba.gtsharp.api.utils.GTSharpUtil.gtsId;
import static gregicality.multiblocks.api.utils.GCYMUtil.gcymId;
import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public final class GTSharpMetaTileEntities {

    public static MetaTileEntityLargeOilCracker LARGE_MACHINE;
    public static MetaTileEntityLargeGasCollector LARGE_GAS_COLLECTOR;
    public static MetaTileEntityInfiniteMiner BASIC_INFINITE_MINER;
    public static MetaTileEntityLargeCableFactory LARGE_CABLE_FACTORY;
    public  static MetaTileEntityElectricImplosionCompressor ELECTRIC_IMPLOSION_COMPRESSOR;
    public  static MetaTileEntityLargeRockFactory LARGE_ROCK_FACTORY;
    public  static MetaTileEntityLargeExtruder LARGE_EXTRUDER;

    private GTSharpMetaTileEntities() {}

    public static void init() {
        // Multiblocks
        if (GTSharpConfigHolder.globalMultiblocks.enableLargeOilCracker) LARGE_MACHINE = registerMetaTileEntity(22620, new MetaTileEntityLargeOilCracker(gtsId("large_oil_cracker")));
        if (GTSharpConfigHolder.globalMultiblocks.enableLargeGasCollector) LARGE_GAS_COLLECTOR = registerMetaTileEntity(22621, new MetaTileEntityLargeGasCollector(gtsId("large_gas_collector")));
        if (GTSharpConfigHolder.globalMultiblocks.enableLargeCableFactory) LARGE_CABLE_FACTORY = registerMetaTileEntity(22622, new MetaTileEntityLargeCableFactory(gtsId("large_cable_factory")));
        if (GTSharpConfigHolder.globalMultiblocks.enableElectricImplosionCompressor) ELECTRIC_IMPLOSION_COMPRESSOR = registerMetaTileEntity(22623, new MetaTileEntityElectricImplosionCompressor(gcymId("electric_implosion_compressor")));
        if (GTSharpConfigHolder.globalMultiblocks.enableLargeRockFactory) LARGE_ROCK_FACTORY = registerMetaTileEntity(22624, new MetaTileEntityLargeRockFactory(gtsId("large_rock_factory")));
        if (GTSharpConfigHolder.globalMultiblocks.enableLargeExtruder) LARGE_EXTRUDER = registerMetaTileEntity(22625, new MetaTileEntityLargeExtruder(gcymId("large_extruder")));

        if (GTSharpConfigHolder.globalMultiblocks.enableInfiniteMiner) BASIC_INFINITE_MINER = registerMetaTileEntity(22632, new MetaTileEntityInfiniteMiner(gtsId("large_miner.uv")));
    }
}