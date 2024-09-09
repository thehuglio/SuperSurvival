package org.hugliodev.supersurvival;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.hugliodev.supersurvival.ChatCore.ChatCoreManager;
import org.hugliodev.supersurvival.data.DataManager;

public final class Main extends JavaPlugin {
    public static Plugin plugin;

    @Override
    public void onEnable() {
        System.out.println("supersurvival has been started");
        DataManager.initialize(getDataFolder());
        new ChatCoreManager(this);
    }

    @Override
    public void onDisable() {

    }
}
