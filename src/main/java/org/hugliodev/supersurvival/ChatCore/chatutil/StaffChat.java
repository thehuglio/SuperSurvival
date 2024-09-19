package org.hugliodev.supersurvival.ChatCore.chatutil;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.hugliodev.supersurvival.data.configfiles.MainConfData;

import java.util.LinkedList;
import java.util.List;

public class StaffChat {
    public static void staffChat(String s) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.hasPermission("supersurvival.chat.sc") || p.isOp()) p.sendMessage(parse(s));

        }
    }
    public static PlayerChatEvent staffChat(PlayerChatEvent event,String s) {
         event.setFormat(parse(s));
         List<Player> staff = new LinkedList<>();
         Bukkit.getOnlinePlayers().forEach(player -> {
             if (player.hasPermission("supersurvival.chat.sc")) staff.add(player);
         });
         event.getRecipients().retainAll(staff);
         return event;
    }
    private static String parse(String s) {
        return MainConfData.staffChatFormat.toString(new String[] {"%message%"},new String[]{s});
    }
}
