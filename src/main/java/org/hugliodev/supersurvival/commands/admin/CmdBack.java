package org.hugliodev.supersurvival.commands.admin;

import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IAdminCommand;
import org.hugliodev.supersurvival.core.Message;
import org.hugliodev.supersurvival.Util.LocationExtention;
import org.hugliodev.supersurvival.playerdata.PlayerData;

import javax.annotation.Nullable;
import java.util.List;

public class CmdBack implements IAdminCommand {
    @Override
    public String getPermission() {
        return "back";
    }

    @Override
    public String getCommand() {
        return "back";
    }

    @Override
    public List<String> getAliases() {
        return List.of("back");
    }

    @Override
    public String getUsage() {
        return "/back";
    }

    @Override
    public String getDescription() {
        return "teleport back to your last location before a warp, teleport or death";
    }

    @Override
    public int getMaxArgs() {
        return 0;
    }

    @Override
    public boolean canBeExecutedByConsole() {
        return false;
    }

    @Nullable
    @Override
    public SurgestionSafe tabComplete() {
        return null;
    }

    @Override
    public void execute(Player player, String[] args) {
        LocationExtention lastloc = PlayerData.getLastLoc(player);
        if (lastloc == null) {
            Message.COMMAND_BACK_NOLOCATION.send(player);
            return;
        }
        player.teleport(PlayerData.getLastLoc(player));
        Message.COMMAND_BACK_FINISH.send(player);
    }
}
