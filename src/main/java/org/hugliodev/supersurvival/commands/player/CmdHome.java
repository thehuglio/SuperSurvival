package org.hugliodev.supersurvival.commands.player;

import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IPermissionCommand;
import org.hugliodev.supersurvival.core.Message;
import org.hugliodev.supersurvival.features.LocationExtention;
import org.hugliodev.supersurvival.playerdata.PlayerData;

import java.util.List;

public class CmdHome implements IPermissionCommand {
    @Override
    public String getPermission() {
        return "home";
    }


    @Override
    public String getCommand() {
        return "home";
    }

    @Override
    public List<String> getAliases() {
        return List.of("home");
    }

    @Override
    public String getUsage() {
        return "/home [Home]";
    }

    @Override
    public String getDescription() {
        return "teleport to your main home or specified home";
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
        return null;
    }

    @Override
    public void execute(Player player, String[] args) {
        LocationExtention location = PlayerData.getHome(player,args[0]);
        if (location == null) {
            Message.COMMAND_HOME_NONEXISTING.send(player);
            return;
        }
        player.teleport(location);
        player.sendMessage(Message.COMMAND_HOME_TELEPORTED.getMessage().toString(new String[]{"%home%"},new String[]{args[0]}));
    }
}
