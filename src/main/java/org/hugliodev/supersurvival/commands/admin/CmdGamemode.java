package org.hugliodev.supersurvival.commands.admin;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IAdminCommand;
import org.hugliodev.supersurvival.core.Message;

import java.util.List;

public class CmdGamemode implements IAdminCommand {
    @Override
    public String getPermission() {
        return "gamemode";
    }

    @Override
    public String getCommand() {
        return "gamemode";
    }

    @Override
    public List<String> getAliases() {
        return List.of("gma","gmsp","gms","gmc","gamemode");
    }

    @Override
    public String getUsage() {
        return "/<gmc|gmsp|gms|gmc|gamemode> [player]";
    }

    @Override
    public String getDescription() {
        return "change the gamemode of yourself or from another player";
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
    public void execute(Player player, String s, String[] args) {
        if (s.equalsIgnoreCase("gma")) player.setGameMode(GameMode.ADVENTURE);
        else if (s.equalsIgnoreCase("gms")) player.setGameMode(GameMode.SURVIVAL);
        else if (s.equalsIgnoreCase("gmc")) player.setGameMode(GameMode.CREATIVE);
        else if (s.equalsIgnoreCase("gmsp")) player.setGameMode(GameMode.SPECTATOR);
        else if (s.equalsIgnoreCase("gamemode")) player.sendMessage("your gamemode is " + player.getGameMode());
        else {
            Message.COMMAND_GAMEMODE_NONEXISTING.send(player);
            return;
        }
        player.sendMessage(Message.COMMAND_GAMEMODE_FINISH.getMessage().toString(new String[]{"%gamemode%"},new String[]{"%gamemode%"}));
    }
}
