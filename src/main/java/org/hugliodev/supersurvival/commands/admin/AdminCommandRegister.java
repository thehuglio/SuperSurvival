package org.hugliodev.supersurvival.commands.admin;

import org.hugliodev.supersurvival.commands.CommandMap;

public class AdminCommandRegister extends CommandMap {
    public AdminCommandRegister() {
        register(new CmdBack());
        register(new CmdClearchat());
        register(new CmdEnchant());
        register(new CmdFly());
        register(new CmdGamemode());
        register(new CmdLockchat());
        register(new CmdSuperSurvivalReload());
        register(new CmdSetwarp());
        register(new CmdSetspawn());
        register(new CmdTeleport());
        register(new CmdStaffChat());
        register(new CmdScToggle());
    }
}
