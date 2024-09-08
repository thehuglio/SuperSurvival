package org.hugliodev.supersurvival.commands.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IPermissionCommand;
import java.util.List;

public class CmdLocation implements IPermissionCommand {
    @Override
    public String getPermission() {
        return "location";
    }

    @Override
    public String getCommand() {
        return "loc";
    }

    @Override
    public List<String> getAliases() {
        return List.of("location","loc");
    }

    @Override
    public String getUsage() {
        return "/location [player]";
    }

    @Override
    public String getDescription() {
        return "sends your current location in chat or to a player";
    }

    @Override
    public int getMinArgs() {
        return 0;
    }

    @Override
    public int getMaxArgs() {
        return 1;
    }

    @Override
    public boolean canBeExecutedByConsole() {
        return false;
    }

    @Override
    public SurgestionSafe tabComplete() {
        return null;
    }

    @Override
    public void execute(Player player, String[] args) {
        if (args == null) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage();
            }
        }
    }
}
