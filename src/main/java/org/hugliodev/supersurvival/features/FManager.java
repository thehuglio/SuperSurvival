package org.hugliodev.supersurvival.features;

import org.bukkit.plugin.Plugin;
import org.hugliodev.supersurvival.features.passive.FPManager;

public class FManager {
    public static void start(Plugin plugin) {
        FPManager.start(plugin);
    }
}
