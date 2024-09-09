package org.hugliodev.supersurvival.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IAdminCommand;
import org.hugliodev.supersurvival.core.Message;

import java.util.List;

public class CmdFly implements IAdminCommand {
    @Override
    public String getPermission() {
        return "fly";
    }


    @Override
    public String getCommand() {
        return "fly";
    }

    @Override
    public List<String> getAliases() {
        return List.of("fly");
    }

    @Override
    public String getUsage() {
        return "/fly [player]";
    }

    @Override
    public String getDescription() {
        return "lets yourself or another player fly";
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
        if (args.length > 0) {
            try {
                player = Bukkit.getPlayer(args[0]);

            } catch (Exception e) {
                Message.COMMAND_FLY_NONEXISTINGPLAYER.send(player);
                return;
            }
        }
        player.setAllowFlight(!player.getAllowFlight());
        Message.COMMAND_FLY_FINISH.send(player);
    }
}