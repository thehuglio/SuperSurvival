package org.hugliodev.supersurvival.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IAdminCommand;

import java.util.List;

public class CmdTeleport implements IAdminCommand {
    @Override
    public String getPermission() {
        return "teleport";
    }

    @Override
    public String getCommand() {
        return "tp";
    }

    @Override
    public List<String> getAliases() {
        return List.of("tp","teleport");
    }

    @Override
    public String getUsage() {
        return "/tp <player>/<x> <y> <z>";
    }

    @Override
    public String getDescription() {
        return "teleport to a player or a location";
    }

    @Override
    public int getMinArgs() {
        return 1;
    }

    @Override
    public int getMaxArgs() {
        return 3;
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
        if (args.length == 3) {
            try {
                int x = Integer.parseInt(args[0]);
                int y = Integer.parseInt(args[1]);
                int z = Integer.parseInt(args[2]);
                player.teleport(new Location(player.getWorld(), x, y, z));
                return;
            } catch (NumberFormatException Ne) {
                player.sendMessage("this is not a location");
            }
            Player to = Bukkit.getPlayer(args[0]);
            if (to != null) {
                player.teleport(to);
            }
            player.sendMessage(this.getUsage());
        }
    }
}
