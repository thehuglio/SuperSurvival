package org.hugliodev.supersurvival.commands.player;

import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IPermissionCommand;
import org.hugliodev.supersurvival.features.base.spawn.Spawn;

import java.util.List;

public class CmdSpawn implements IPermissionCommand {

    @Override
    public String getPermission() {
        return "spawn";
    }

    @Override
    public String getCommand() {
        return "spawn";
    }

    @Override
    public List<String> getAliases() {
        return List.of("spawn");
    }

    @Override
    public String getUsage() {
        return "/spawn";
    }

    @Override
    public String getDescription() {
        return "brings the player to spawn";
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
        player.teleport(Spawn.getSpawn());
    }
}
