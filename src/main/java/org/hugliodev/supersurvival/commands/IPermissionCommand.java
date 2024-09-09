package org.hugliodev.supersurvival.commands;

import org.hugliodev.supersurvival.Util.ParseMessage;
import org.hugliodev.supersurvival.core.Message;

public interface IPermissionCommand extends ICommand {
    String getPermission();
    default ParseMessage noPermission() {
        return Message.COMMAND_NOPERMISSION.getMessage();
    }
}
