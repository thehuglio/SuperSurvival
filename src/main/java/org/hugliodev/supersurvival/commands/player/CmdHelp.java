package org.hugliodev.supersurvival.commands.player;

import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.ICommand;

import java.util.List;

public class CmdHelp implements ICommand {

    @Override
    public String getCommand() {
        return "help";
    }

    @Override
    public List<String> getAliases() {
        return List.of();
    }

    @Override
    public String getUsage() {
        return "/help [page]";
    }

    @Override
    public String getDescription() {
        return "sends a help page to a player";
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
                int page = Integer.parseInt(args[0]);
                //ToDo:
                // - if (page < Help.maxPage()) {
                // - send page to the player
                return;
            } catch (Exception ignored) {
            }
        }
        //ToDo send player first help page
    }
}
