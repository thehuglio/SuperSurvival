package org.hugliodev.supersurvival.features;

import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;
import org.hugliodev.supersurvival.Main;
import org.hugliodev.supersurvival.data.configfiles.ConfMain;
import org.bukkit.entity.Player;

import java.util.LinkedList;

public class Teleport extends BukkitRunnable {
    private static final LinkedList<Teleport> teleportList = new LinkedList<>();
    Player target = null;
    Player player;
    Location loc = null;
    int cooldown = ConfMain.teleportCooldown;
    BukkitRunnable timeOut = new BukkitRunnable() {
        @Override
        public void run() {
            kill();
        }
    };
    public Teleport(Player player, Player target) {
        this.player = player;
        this.target = target;
        teleportList.addLast(this);
    }
    public Teleport(Player player, Location loc) {
        this.loc = loc;
        this.player = player;
        start();
        teleportList.addLast(this);
    }
    public Teleport(Player player, Player target, int cooldown) {
        this.player = player;
        this.target = target;
        this.cooldown = cooldown;
        teleportList.addLast(this);
    }
    public Teleport(Player player, Location loc, int cooldown) {
        this.player = player;
        this.loc = loc;
        this.cooldown = cooldown;
        start();
        teleportList.addLast(this) ;
    }
    public void kill() {
        teleportList.remove(this);
    }
    private void start() {
        super.runTaskLater(Main.plugin,cooldown);
    }
    @Override
    public void run() {
        if (target != null) {
            player.teleport(player);
        } else if (loc != null) {
            player.teleport(loc);
        }
    }
    public static void cancel(Player player) {
        for(Teleport t : teleportList) {
            if (t.player == player) {
                t.timeOut.cancel();
                teleportList.remove(t);
                break;
            }
            else {
            }
        }
            //ToDo add messages
    }
    public static void accept(Player player){
            for (Teleport t : teleportList) {
                if (t.player == player) {
                    t.start();
                    t.timeOut.cancel();
                    break;
                }
                else {
                }
                //ToDo add messages
            }
        }
}
