package org.hugliodev.supersurvival.core;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.hugliodev.supersurvival.data.datafiles.playerdata.PlayerData;

public class PlayerJoinEvent implements Listener {
    @EventHandler
    private void playerJoinEvent(org.bukkit.event.player.PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!PlayerData.containsPlayer(player)) {
            PlayerData.addPlayer(player);
        }

    }

}
