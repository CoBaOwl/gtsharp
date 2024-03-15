package com.coba.gtsharp.multiblock;

import com.coba.gtsharp.multiblock.standart.MetaTileEntityLargeGasCollector;
import com.coba.gtsharp.multiblock.standart.MetaTileEntityLargeOilCracker;


import static com.coba.gtsharp.api.utils.GTSharpUtil.gcymId;
import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public final class GTSharpMetaTileEntities {

    public static MetaTileEntityLargeOilCracker LARGE_MACHINE;
    public static MetaTileEntityLargeGasCollector LARGE_GAS_COLLECTOR;

    private GTSharpMetaTileEntities() {}

    public static void init() {
        // Multiblocks
        LARGE_MACHINE = registerMetaTileEntity(22620, new MetaTileEntityLargeOilCracker(gcymId("large_oil_cracker")));
        LARGE_GAS_COLLECTOR = registerMetaTileEntity(22621, new MetaTileEntityLargeGasCollector(gcymId("large_gas_collector")));
    }
}
