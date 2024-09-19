package org.hugliodev.supersurvival.commands.player;

import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IPermissionCommand;
import org.hugliodev.supersurvival.features.Teleport;

import java.util.List;

public class CmdTpdecline implements IPermissionCommand {
    @Override
    public String getCommand() {
        return "tpdecline";
    }

    @Override
    public List<String> getAliases() {
        return List.of("tpd","tpdecline");
    }

    @Override
    public String getUsage() {
        return "tpd/tpdecline";
    }

    @Override
    public String getDescription() {
        return "declines a tp request";
    }

    @Override
    public boolean canBeExecutedByConsole() {
        return false;
    }

    @Override
    public void execute(Player player,String[] args) {
        Teleport.decline(player);
    }

    @Override
    public SurgestionSafe tabComplete() {
        return null;
    }

    @Override
    public String getPermission() {
        return "tpd";
    }
}
