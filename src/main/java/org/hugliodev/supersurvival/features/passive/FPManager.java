package org.hugliodev.supersurvival.features.passive;

import org.bukkit.plugin.Plugin;
import org.hugliodev.supersurvival.data.configfiles.MainConfData;

public class FPManager {
    public static void start(Plugin plugin) {
        if (MainConfData.blockedCommandsEnable) plugin.getServer().getPluginManager().registerEvents(new BlockCommands(),plugin);
        if (MainConfData.combatTagEnable) plugin.getServer().getPluginManager().registerEvents(new CombatTag(),plugin);
    }
}
