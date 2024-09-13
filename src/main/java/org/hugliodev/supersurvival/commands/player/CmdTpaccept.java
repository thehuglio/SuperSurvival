package org.hugliodev.supersurvival.commands.player;

import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IPermissionCommand;
import org.hugliodev.supersurvival.features.Teleport;

import java.util.List;

public class CmdTpaccept implements IPermissionCommand {

    @Override
    public String getPermission() {
        return "tpaccept";
    }

    @Override
    public String getCommand() {
        return "tpaccept";
    }

    @Override
    public List<String> getAliases() {
        return List.of("tpaccept");
    }

    @Override
    public String getUsage() {
        return "/tpaccept";
    }

    @Override
    public String getDescription() {
        return "accepts a teleportrequest";
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
        Teleport.accept(player);
    }
}
