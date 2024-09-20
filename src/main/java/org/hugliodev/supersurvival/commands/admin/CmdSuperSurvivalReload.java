package org.hugliodev.supersurvival.commands.admin;

import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IAdminCommand;

import java.util.List;

public class CmdSuperSurvivalReload implements IAdminCommand {
    @Override
    public String getPermission() {
        return "reload";
    }

    @Override
    public String getCommand() {
        return "supersurvivalreload";
    }

    @Override
    public List<String> getAliases() {
        return List.of("supersurvivalreload");
    }

    @Override
    public String getUsage() {
        return "/supersurvivalreload";
    }

    @Override
    public String getDescription() {
        return "";
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
        return true;
    }

    @Override
    public SurgestionSafe tabComplete() {
        return null;
    }

    @Override
    public boolean displayCommand() {
        return false;
    }
}
