package org.hugliodev.supersurvival.commands;

public interface IAdminCommand extends IPermissionCommand {
    @Override
    default boolean DefaultPermissionOp() {
        return true;
    }
}
