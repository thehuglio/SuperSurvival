package org.hugliodev.supersurvival.data.configfiles;

import org.bukkit.entity.Entity;
import org.hugliodev.supersurvival.Util.ParseMessage;

import java.util.List;

public class ConfMain {
    public static boolean chatEnabled;
    public static ParseMessage playerchatformat;
    public static boolean allowplayercollorcodes;
    public static boolean allowplayerplaceholders;
    public static boolean chatItemListing;
    public static String chatItemListingFormat;
    public static String chatItemListingReplace;
    public static List<String> blockedWords;
    public static boolean bleurBlockedWords;
    public static String bleurToken;
    public static List<String> blockedPunishement;
    public static ParseMessage blockedMessage;
    public static String clearChatEnters;
    public static int teleportCooldown;
    public static boolean combatTagEnable;
    public static List<String> combatTagBlockedCommands;
    public static boolean combatTagAllowTeleport;
    public static int combatTagCooldown;
    public static boolean onlyTriggeredByPlayer;
    public static List<String> blockedCommands;
}
