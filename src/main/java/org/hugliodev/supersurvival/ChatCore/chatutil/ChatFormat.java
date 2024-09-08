package org.hugliodev.supersurvival.ChatCore.chatutil;

import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.ParseMessage;
import org.hugliodev.supersurvival.data.configfiles.ConfMain;

public class ChatFormat implements IChatUtil{
    public String apply(Player player, String message) {
        if (ConfMain.allowplayercollorcodes) {
            if (ConfMain.allowplayerplaceholders) message = new ParseMessage(message).toString(player);
            else message = new ParseMessage(message).toString();
        }
        return ConfMain.playerchatformat.toString(player,new String[]{"%message%"}, new String[]{message});
    }
}
