package org.hugliodev.supersurvival.commands.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.ParseMessage;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IPermissionCommand;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CmdMessage implements IPermissionCommand {
    @Override
    public String getPermission() {
        return "message";
    }

    @Override
    public String getCommand() {
        return "msg";
    }

    @Override
    public List<String> getAliases() {
        return List.of("message","msg");
    }

    @Override
    public String getUsage() {
        return "/message <player> <message>";
    }

    @Override
    public String getDescription() {
        return "message a player";
    }

    @Override
    public int getMinArgs() {
        return 3;
    }

    @Override
    public boolean canBeExecutedByConsole() {
        return false;
    }

    @Override
    public SurgestionSafe tabComplete() {
        HashMap<String,SurgestionSafe> hash = new HashMap<>();
        hash.put("<player>",new SurgestionSafe(List.of("<message>")));
        return new SurgestionSafe(hash);
    }

    @Override
    public void execute(Player player, String[] args) {
        Player recever = Bukkit.getPlayer(args[0]);
        if (recever != null) {
            List<String> message = Arrays.stream(args).toList();
            message.removeFirst();
            ParseMessage parsedmessage = new ParseMessage(message);
            recever.sendMessage(parsedmessage.toString());
        } else {
            player.sendMessage(args[0] + " is not a player");
        }
    }
}
