package com.coba.gtsharp;

import com.coba.gtsharp.common.CommonProxy;
import com.coba.gtsharp.common.block.GTSharpMetaBlocks;
import com.coba.gtsharp.multiblock.GTSharpMetaTileEntities;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

@Mod(modid = Tags.MODID, version = Tags.VERSION, name = Tags.MODNAME, acceptedMinecraftVersions = "[1.12.2]", dependencies = "required-after:gcym;")
public class GTSharp {

    public static final Logger LOGGER = LogManager.getLogger(Tags.MODID);

    public static final String MODID = Tags.MODID;
    public static final String NAME = Tags.MODNAME;
    public static final String VERSION = Tags.VERSION;

    @SidedProxy(modId = Tags.MODID,
            clientSide = "com.coba.gtsharp.common.ClientProxy",
            serverSide = "com.coba.gtsharp.common.CommonProxy")
    public static CommonProxy proxy;

//    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc. (Remove if not needed)
//    public void preInit(FMLPreInitializationEvent event) {
//        // register to the event bus so that we can listen to events
//        MinecraftForge.EVENT_BUS.register(this);
//        LOGGER.info("I am " + Tags.MODNAME + " + at version " + Tags.VERSION);
//
//        GTSharpMetaTileEntities.init();
//    }

    @Mod.EventHandler
    public void onPreInit(@NotNull FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("I am " + Tags.MODNAME + " + at version " + Tags.VERSION);
        GTSharpMetaBlocks.init();
        GTSharpMetaTileEntities.init();
        proxy.preLoad();
    }

    @SubscribeEvent
    // Register recipes here (Remove if not needed)
    public void registerRecipes(RegistryEvent.Register<IRecipe> event) {

    }

    @SubscribeEvent
    // Register items here (Remove if not needed)
    public void registerItems(RegistryEvent.Register<Item> event) {

    }

    @SubscribeEvent
    // Register blocks here (Remove if not needed)
    public void registerBlocks(RegistryEvent.Register<Block> event) {

    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
    }
}
