package org.hugliodev.supersurvival.commands.admin;

import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IAdminCommand;
import org.hugliodev.supersurvival.features.base.spawn.Spawn;

import java.util.List;

public class CmdSetspawn implements IAdminCommand {
    @Override
    public String getPermission() {
        return "setspawn";
    }

    @Override
    public String getCommand() {
        return "setspawn";
    }

    @Override
    public List<String> getAliases() {
        return List.of("setspawn");
    }

    @Override
    public String getUsage() {
        return "/setspawn [player]";
    }

    @Override
    public String getDescription() {
        return "sets the worldspawn or the spawn of a player";
    }

    @Override
    public int getMinArgs() {
        return 0;
    }

    @Override
    public int getMaxArgs() {
        return 0;
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
        Spawn.setSpawn(player.getLocation());
    }
}
