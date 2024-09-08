package org.hugliodev.supersurvival.commands.player;

import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IPermissionCommand;
import org.hugliodev.supersurvival.features.LocationExtention;
import org.hugliodev.supersurvival.features.base.warp.Warp;

import java.util.List;

public class CmdWarp implements IPermissionCommand {
    @Override
    public String getPermission() {
        return "warp";
    }
    @Override
    public String getCommand() {
        return "warp";
    }
    @Override
    public List<String> getAliases() {
        return List.of("warp");
    }

    @Override
    public String getUsage() {
        return "/warp <Warp>";
    }

    @Override
    public String getDescription() {
        return "warps the player to the warp location";
    }

    @Override
    public int getMinArgs() {
        return 1;
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
        LocationExtention warp = Warp.getWarp(player, args[0]);
    }
}
