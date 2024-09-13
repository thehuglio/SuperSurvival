package org.hugliodev.supersurvival.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IAdminCommand;
import org.hugliodev.supersurvival.data.configfiles.MainConfData;

import java.util.List;

public class CmdClearchat implements IAdminCommand {
    @Override
    public String getPermission() {
        return "clearchat";
    }

    @Override
    public String getCommand() {
        return "clearchat";
    }

    @Override
    public List<String> getAliases() {
        return List.of("clearchat");
    }

    @Override
    public String getUsage() {
        return "/clearchat";
    }

    @Override
    public String getDescription() {
        return "Clear te chat";
    }

    @Override
    public boolean canBeExecutedByConsole() {
        return true;
    }

    @Override
    public SurgestionSafe tabComplete() {
        return null;
    }

    @Override
    public void execute(Player player, String[] args) {
        execute();
    }

    @Override
    public void execute(ConsoleCommandSender consoleCommandSender, String[] args) {
        execute();
    }
    private void execute() {
        Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage(MainConfData.clearChatEnters));
    }
}
