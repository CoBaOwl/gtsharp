package com.coba.gtsharp.common;

import com.coba.gtsharp.api.render.GTSharpTextures;
import com.coba.gtsharp.common.block.GTSharpMetaBlocks;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void preLoad() {
        super.preLoad();
        GTSharpTextures.preInit();
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        GTSharpMetaBlocks.registerItemModels();
    }
}
