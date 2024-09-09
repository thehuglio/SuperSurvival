package org.hugliodev.supersurvival.core;

import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.ParseMessage;

public enum Message {
    COMMAND_NOPERMISSION,
    NOT_AN_NUMBER,
    COMMAND_BACK_FINISH,
    COMMAND_ENCHANT_FINISH,
    COMMAND_FLY_FINISH,
    COMMAND_GAMEMODE_NONEXISTING,
    COMMAND_GAMEMODE_FINISH,
    COMMAND_BACK_NOLOCATION,
    COMMAND_HOME_NONEXISTING,
    FORMAT_LOCATION(new ParseMessage("%x%,%y%,%z%")),
    COMMAND_FLY_NONEXISTINGPLAYER,
    COMMAND_HOME_TELEPORTED;
    Message() {defoultMessage = null;}
    Message(ParseMessage defoult) {this.defoultMessage = defoult;}
    private final ParseMessage defoultMessage;

    @Override
    public String toString() {
        return this.defoultMessage.toString();
    }

    /**
     *
     * send a message to a player (with the player as placeholder parent)
     */
    public void send(Player player) {
        player.sendMessage(this.defoultMessage.toString(player));
    }
    public void sendserver(Player player, Message message) {
        player.sendMessage(super.toString());

    }
    public ParseMessage getMessage() {
        return defoultMessage;
    }

}
