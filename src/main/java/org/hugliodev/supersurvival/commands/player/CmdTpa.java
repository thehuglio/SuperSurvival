package org.hugliodev.supersurvival.commands.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IPermissionCommand;
import org.hugliodev.supersurvival.features.Teleport;

import java.util.List;

public class CmdTpa implements IPermissionCommand {
    @Override
    public String getPermission() {
        return "Tpa";
    }

    @Override
    public String getCommand() {
        return "tpa";
    }

    @Override
    public List<String> getAliases() {
        return List.of("tpa");
    }

    @Override
    public String getUsage() {
        return "/tpa";
    }

    @Override
    public String getDescription() {
        return "teleport to a player (they need to accept with /tpaccept";
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
        Player p = Bukkit.getPlayer(args[0]);
        if (p == null) return;
        new Teleport(player,p);
    }
}
