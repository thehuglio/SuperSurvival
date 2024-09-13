package org.hugliodev.supersurvival.features.passive;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.hugliodev.supersurvival.data.configfiles.MainConfData;

public class BlockCommands implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    private static void playerCommand(PlayerCommandPreprocessEvent event) {
        if (event.getPlayer().isOp()) return;
        for (String s : MainConfData.blockedCommands) {
            if (event.getMessage().contains(s)) {
                event.setCancelled(true);
                break;
            }
        }
    }
}
