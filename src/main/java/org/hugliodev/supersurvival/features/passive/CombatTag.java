package org.hugliodev.supersurvival.features.passive;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.hugliodev.supersurvival.Main;
import org.hugliodev.supersurvival.data.configfiles.MainConfData;

import java.util.HashMap;

public class CombatTag extends BukkitRunnable implements Listener {
    private static HashMap<Player,CombatTag> tagged = new HashMap<>();
    int timer = MainConfData.combatTagCooldown;
    Player player;
    public CombatTag(){};

    public CombatTag(Player player) {
        this.player = player;
        runTaskTimer(Main.plugin,0,20);
    }
    public static boolean check(Player player) {
        return tagged.containsKey(player);
    }
    @Override
    public void run() {
        timer--;
        if (timer == 0) {
            cancel();
            tagged.remove(player);
        }
    }
    @EventHandler
    private static void playerhit(EntityDamageByEntityEvent event) {
        if ((MainConfData.onlyTriggeredByPlayer || event.getDamager() instanceof Player) && event.getEntity() instanceof Player player && !player.isOp()) {
            if (!tagged.containsKey(player)) tagged.put(player,new CombatTag(player));
            else tagged.get(player).timer = MainConfData.combatTagCooldown;

        }
    }
    @EventHandler(priority = EventPriority.HIGH)
    private static void playerCommand(PlayerCommandPreprocessEvent event) {
        if (!tagged.containsKey(event.getPlayer())) return;
        for (String s : MainConfData.combatTagBlockedCommands) {
            if (event.getMessage().contains(s)) {
                event.setCancelled(true);
                break;
            }
        }
    }
}
