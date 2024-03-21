package com.coba.gtsharp.api.utils;

import com.coba.gtsharp.GTSharp;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public final class GTSharpUtil {

    public static @NotNull ResourceLocation gtsId(@NotNull String path) {
        return new ResourceLocation(GTSharp.MODID, path);
    }

    private GTSharpUtil() {}
}
