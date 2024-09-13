package org.hugliodev.supersurvival.ChatCore.chatutil;

import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.ParseMessage;
import org.hugliodev.supersurvival.data.configfiles.MainConfData;

public class ChatFormat implements IChatUtil{
    public String apply(Player player, String message) {
        if (MainConfData.allowPlayerColorCodes) {
            if (MainConfData.allowPlayerPlaceholders) message = new ParseMessage(message).toString(player);
            else message = new ParseMessage(message).toString();
        }
        return MainConfData.playerChatFormat.toString(player,new String[]{"%message%"}, new String[]{message});
    }
}
