package com.coba.gtsharp.common;

import com.coba.gtsharp.GTSharp;
import net.minecraftforge.common.config.Config;

@Config(modid = GTSharp.MODID, name = GTSharp.MODID + '/' + GTSharp.MODID)
public class GTSharpConfigHolder {

    @Config.Comment("Enable/Disable multiblocks")
    @Config.Name("Global Multiblocks Options")
    public static GlobalMultiblocks globalMultiblocks = new GlobalMultiblocks();

    public static class GlobalMultiblocks {

        @Config.Comment({ "Enable Void Miner", "Default: true" })
        public boolean enableInfiniteMiner = true;

        @Config.Comment({ "Enable Electric Implosion Compressor recepies fix", "Default: true" })
        public boolean enableElectricImplosionCompressor = true;

        @Config.Comment({ "Enable Large Cable Factory", "Default: true" })
        public boolean enableLargeCableFactory = true;

        @Config.Comment({ "Enable Large Extruder add lubricant", "Default: false" })
        public boolean enableLargeExtruder = false;

        @Config.Comment({ "Enable Large Gas Collector", "Default: true" })
        public boolean enableLargeGasCollector = true;

        @Config.Comment({ "Enable Large Oil Cracker", "Default: true" })
        public boolean enableLargeOilCracker = true;

        @Config.Comment({ "Enable Large Rock Factory", "Default: true" })
        public boolean enableLargeRockFactory = true;
    }
}
