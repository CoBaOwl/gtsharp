package com.coba.gtsharp.multiblock;

import com.coba.gtsharp.multiblock.standart.MetaTileEntityInfiniteMiner;
import com.coba.gtsharp.multiblock.standart.MetaTileEntityLargeCableFactory;
import com.coba.gtsharp.multiblock.standart.MetaTileEntityLargeGasCollector;
import com.coba.gtsharp.multiblock.standart.MetaTileEntityLargeOilCracker;


import static com.coba.gtsharp.api.utils.GTSharpUtil.gcymId;
import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public final class GTSharpMetaTileEntities {

    public static MetaTileEntityLargeOilCracker LARGE_MACHINE;
    public static MetaTileEntityLargeGasCollector LARGE_GAS_COLLECTOR;
    public static MetaTileEntityInfiniteMiner BASIC_INFINITE_MINER;
    public static MetaTileEntityLargeCableFactory LARGE_CABLE_FACTORY;

    private GTSharpMetaTileEntities() {}

    public static void init() {
        // Multiblocks
        LARGE_MACHINE = registerMetaTileEntity(22620, new MetaTileEntityLargeOilCracker(gcymId("large_oil_cracker")));
        LARGE_GAS_COLLECTOR = registerMetaTileEntity(22621, new MetaTileEntityLargeGasCollector(gcymId("large_gas_collector")));
        LARGE_CABLE_FACTORY = registerMetaTileEntity(22622, new MetaTileEntityLargeCableFactory(gcymId("large_cable_factory")));
//        BASIC_INFINITE_MINER = registerMetaTileEntity(22632, new MetaTileEntityInfiniteMiner(gcymId("large_miner.uv"), GTValues.UV, 16, 3, 4, Materials.NaquadahAlloy, 8*4));
    }
}