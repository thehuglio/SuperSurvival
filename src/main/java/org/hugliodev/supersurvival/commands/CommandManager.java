package org.hugliodev.supersurvival.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.hugliodev.supersurvival.commands.admin.AdminCommandRegister;
import org.hugliodev.supersurvival.commands.player.PlayerCommandRegister;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class CommandManager {

    private static CommandMap playerCommandMap = new PlayerCommandRegister();
    private static CommandMap adminCommandMap = new AdminCommandRegister();
    public static void reload(JavaPlugin plugin) {
        for (IMainCommand command : playerCommandMap.commandList) {
            System.out.println(command.getCommand());
        }
        for (IMainCommand command : adminCommandMap.commandList) {
            System.out.println(command.getCommand());
        }
        for (IMainCommand command : playerCommandMap.commandList) {
            PluginCommand Bcommand = plugin.getServer().getPluginCommand(command.getCommand());
            Bcommand.setAliases(command.getAliases());
            Bcommand.setDescription(command.getDescription());
            Bcommand.setUsage(command.getUsage());
            if (command instanceof IPermissionCommand pcommand) {
                Bcommand.setPermission("supersurvival.cmd." + pcommand.getPermission());
                Bcommand.setPermissionMessage(pcommand.noPermission().toString());
            }
            Bcommand.setExecutor(command);
        }
        for (IMainCommand command : adminCommandMap.commandList) {
            PluginCommand Bcommand = Bukkit.getServer().getPluginCommand(command.getCommand());
            Bcommand.setAliases(command.getAliases());
            Bcommand.setDescription(command.getDescription());
            Bcommand.setUsage(command.getUsage());
            if (command instanceof IPermissionCommand pcommand) {
                Bcommand.setPermission("supersurvival.cmd." + pcommand.getPermission());
                Bcommand.setPermissionMessage(pcommand.noPermission().toString());
            }
            Bcommand.setExecutor(command);
        }
    }
}
