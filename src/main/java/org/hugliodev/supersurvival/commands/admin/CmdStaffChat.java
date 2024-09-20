package org.hugliodev.supersurvival.commands.admin;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.ChatCore.chatutil.StaffChat;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IAdminCommand;
import org.hugliodev.supersurvival.data.datafiles.playerdata.PlayerData;

import java.util.List;

public class CmdStaffChat implements IAdminCommand {

    @Override
    public String getPermission() {
        return "sc";
    }

    @Override
    public String getCommand() {
        return "staffchat";
    }

    @Override
    public List<String> getAliases() {
        return List.of("sc","staffchat");
    }

    @Override
    public String getUsage() {
        return "/sc";
    }

    @Override
    public String getDescription() {
        return "use staffchat";
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
        if (args.length == 0) {
            PlayerData.toggleSc(player);
        }
        StringBuilder sb = new StringBuilder();
        for (String arg : args) {
            sb.append(arg);
        }
        StaffChat.staffChat(sb.toString());
    }

    @Override
    public void execute(ConsoleCommandSender consoleCommandSender, String[] args) {
        StringBuilder sb = new StringBuilder();
        for (String arg : args) {
            sb.append(arg);
        }
        StaffChat.staffChat(sb.toString());
    }
}
