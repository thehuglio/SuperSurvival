package org.hugliodev.supersurvival.ChatCore.chatutil;

import org.bukkit.entity.Player;

public interface IChatUtil {
    default String use(Player p, String s) {
        if (permission() != null) {
            if (!p.hasPermission("supersurvival.chat."+permission())) {
                //todo add nopermission logic
            }
        }
        return apply(p,s);
    }
    default String apply(Player player,String s) {
        return apply(s);
    }
    default String apply(String s) {return null;}
    default String permission() {
        return null;
    }
}
