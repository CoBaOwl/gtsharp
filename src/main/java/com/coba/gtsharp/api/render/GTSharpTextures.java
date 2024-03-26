package com.coba.gtsharp.api.render;


import com.coba.gtsharp.GTSharp;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = GTSharp.MODID, value = Side.CLIENT)
public final class GTSharpTextures {

    public static SimpleOverlayRenderer INFINITE_MINER_CASING;
    public static SimpleOverlayRenderer BREAK_PROOF_CASING;

    private GTSharpTextures() {}

    public static void preInit() {
        // Multiblock Controllers
        INFINITE_MINER_CASING = new SimpleOverlayRenderer("casings/large_multiblock_casing/infinite_miner_casing");
        BREAK_PROOF_CASING = new SimpleOverlayRenderer("casings/large_multiblock_casing/break_proof_casing");
    }
}
