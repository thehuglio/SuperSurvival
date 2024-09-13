package org.hugliodev.supersurvival.commands.admin;

import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IAdminCommand;
import org.hugliodev.supersurvival.Util.LocationExtention;
import org.hugliodev.supersurvival.features.active.warp.Warp;

import java.util.List;

public class CmdSetwarp implements IAdminCommand {
    @Override
    public String getPermission() {
        return "setwarp";
    }

    @Override
    public String getCommand() {
        return "setwarp";
    }

    @Override
    public List<String> getAliases() {
        return List.of("setwarp");
    }

    @Override
    public String getUsage() {
        return "/setwarp <Warp>";
    }

    @Override
    public String getDescription() {
        return "sets a warp at the current location";
    }

    @Override
    public int getMinArgs() {
        return 1;
    }

    @Override
    public int getMaxArgs() {
        return 2;
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
        Warp.setWarp(args[0], (LocationExtention) player.getLocation(), args.length > 1 ? args[1] : null);
    }
}
