package org.hugliodev.supersurvival.commands.player;

import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IPermissionCommand;
import org.hugliodev.supersurvival.playerdata.PlayerData;

import java.util.List;

public class CmdSethome implements IPermissionCommand {
    @Override
    public String getPermission() {
        return "sethome";
    }


    @Override
    public String getCommand() {
        return "sethome";
    }

    @Override
    public List<String> getAliases() {
        return List.of("sethome");
    }

    @Override
    public String getUsage() {
        return "/sethome [Home]";
    }

    @Override
    public String getDescription() {
        return "sets a new home or overwrites an old home";
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
        return new SurgestionSafe(List.of("[home]"));
    }

    @Override
    public void execute(Player player, String[] args) {
        if (args.length > 0) {
            PlayerData.addHome(player, args[0]);
        } else {
            PlayerData.addHome(player, null);
        }
    }
}
