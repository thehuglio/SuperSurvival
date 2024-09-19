package org.hugliodev.supersurvival.data.configfiles;

import org.hugliodev.supersurvival.Util.ParseMessage;

import java.util.List;

public class MainConfData {
    // Chat Settings
    public static ParseMessage staffChatFormat;
    public static boolean chatEnabled;
    public static ParseMessage playerChatFormat;
    public static boolean allowPlayerColorCodes;
    public static boolean allowPlayerPlaceholders;
    public static boolean chatItemListing;
    public static String chatItemListingFormat;
    public static String chatItemListingReplace;
    public static List<String> blockedWords;
    public static boolean bleurBlockedWords;
    public static String bleurToken;
    public static List<String> blockedPunishment;
    public static ParseMessage blockedMessage;
    public static String clearChatEnters;

    // Combat Tag Settings
    public static boolean combatTagEnabled;
    public static List<String> combatTagBlockedCommands;
    public static boolean combatTagAllowTeleport;
    public static int combatTagCooldown;
    public static boolean onlyTriggeredByPlayer;

    // Teleport Settings
    public static boolean teleportEnabled;
    public static int teleportCooldown;

    // Blocked Commands Settings
    public static boolean blockedCommandsEnabled;
    public static List<String> blockedCommands;
}
