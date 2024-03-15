package com.coba.gtsharp.api.render;


import com.coba.gtsharp.GTSharp;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = GTSharp.MODID, value = Side.CLIENT)
public final class GTSharpTextures {

    // Multiblock Controllers
    public static OrientedOverlayRenderer LARGE_MACHINE_OVERLAY;
    public static SimpleOverlayRenderer OILPROOF_CASING;

    public static SimpleOverlayRenderer VOID_MINER_CASING;

    private GTSharpTextures() {}

    public static void preInit() {
        // Multiblock Controllers
        LARGE_MACHINE_OVERLAY = new OrientedOverlayRenderer("multiblock/large_oilcracker");

        OILPROOF_CASING = new SimpleOverlayRenderer("casings/large_multiblock_casing/oilproof_casing");

        VOID_MINER_CASING = new SimpleOverlayRenderer("casings/large_multiblock_casing/void_miner_casing");

    }
}
