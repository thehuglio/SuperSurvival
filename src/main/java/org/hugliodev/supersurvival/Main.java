package org.hugliodev.supersurvival;

import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.hugliodev.supersurvival.ChatCore.ChatCoreManager;
import org.hugliodev.supersurvival.commands.CommandManager;
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
