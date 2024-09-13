package org.hugliodev.supersurvival.commands.player;

import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IPermissionCommand;
import org.hugliodev.supersurvival.features.Teleport;

import java.util.List;

public class CmdTpcancel implements IPermissionCommand {

    @Override
    public String getPermission() {
        return "tpcancel";
    }

    @Override
    public String getCommand() {
        return "tpcancel";
    }

    @Override
    public List<String> getAliases() {
        return List.of("tpcancel","tpc");
    }

    @Override
    public String getUsage() {
        return "/tpc";
    }

    @Override
    public String getDescription() {
        return "cancels a teleportation";
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
        Teleport.cancel(player);
    }
}
