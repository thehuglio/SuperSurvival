package org.hugliodev.supersurvival.commands.admin;

import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IAdminCommand;

import java.util.List;

public class CmdLockchat implements IAdminCommand {
    @Override
    public String getPermission() {
        return "lockchat";
    }

    @Override
    public String getCommand() {
        return "lockchat";
    }

    @Override
    public List<String> getAliases() {
        return List.of("lockchat");
    }

    @Override
    public String getUsage() {
        return "/lockchat";
    }

    @Override
    public String getDescription() {
        return "locks the chat for all players";
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
    public void execute(String[] args) {
        //ToDo set a system for the lockchat
    }
}
