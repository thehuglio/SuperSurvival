package org.hugliodev.supersurvival.commands.player;

import org.hugliodev.supersurvival.commands.CommandMap;
import org.hugliodev.supersurvival.features.active.warp.Warp;

public class PlayerCommandRegister extends CommandMap {
    public PlayerCommandRegister() {
        register(new CmdHelp());
        register(new CmdHome());
        register(new CmdLocation());
        register(new CmdMessage());
        register(new CmdSethome());
        register(new CmdSpawn());
        register(new CmdWarp());
        register(new CmdTpa());
        register(new CmdTpaccept());
        register(new CmdTpcancel());
        register(new CmdTpdecline());
    }
}
