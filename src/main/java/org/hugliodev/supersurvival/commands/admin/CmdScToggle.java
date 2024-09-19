package org.hugliodev.supersurvival.commands.admin;

import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IAdminCommand;
import org.hugliodev.supersurvival.playerdata.PlayerData;

import java.util.Date;
import java.util.List;

public class CmdScToggle implements IAdminCommand {

    @Override
    public String getPermission() {
        return "sctoggle";
    }

    @Override
    public String getCommand() {
        return "sctoggle";
    }

    @Override
    public List<String> getAliases() {
        return List.of("sctoggle","staffchattoggle");
    }

    @Override
    public String getUsage() {
        return "/sctoggle";
    }

    @Override
    public String getDescription() {
        return "toggle staffchat";
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
        PlayerData.toggleSc(player);
    }
}
