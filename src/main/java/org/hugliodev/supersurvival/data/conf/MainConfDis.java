package org.hugliodev.supersurvival.data.conf;

import com.google.gson.JsonObject;
import org.hugliodev.supersurvival.Util.ParseMessage;
import org.hugliodev.supersurvival.data.AConfig;
import static org.hugliodev.supersurvival.data.configfiles.MainConfData.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainConfDis extends AConfig {
    @Override
    protected boolean dataDistributor(JsonObject json) {
        try {
            System.out.println("test - dataDis");

            // Parse ChatSettings
            JsonObject chatSettings = json.get("ChatSettings").getAsJsonObject();
            chatEnabled = chatSettings.get("Enabled").getAsBoolean();
            playerChatFormat = new ParseMessage(chatSettings.get("PlayerChatFormat"));
            allowPlayerColorCodes = chatSettings.get("AllowPlayerColorCodes").getAsBoolean();
            allowPlayerPlaceholders = chatSettings.get("AllowPlayerPlaceholders").getAsBoolean();
            chatItemListing = chatSettings.get("ChatItemListing").getAsBoolean();
            chatItemListingFormat = chatSettings.get("ChatItemListingFormat").getAsString();
            chatItemListingReplace = chatSettings.get("ChatItemListingReplace").getAsString();
            bleurBlockedWords = chatSettings.get("BleurBlockedWords").getAsBoolean();
            bleurToken = chatSettings.get("BleurToken").getAsString();
            blockedMessage = new ParseMessage(chatSettings.get("BlockedMessage"));

            // List for BlockedWords
            blockedWords = new ArrayList<>();
            chatSettings.get("BlockedWords").getAsJsonArray().forEach(jsonElement -> blockedWords.add(jsonElement.getAsString()));

            // List for BlockedPunishment
            blockedPunishment = new ArrayList<>();
            chatSettings.get("BlockedPunishment").getAsJsonArray().forEach(jsonElement -> blockedPunishment.add(jsonElement.getAsString()));

            clearChatEnters = "\n".repeat(Math.max(0, chatSettings.get("ClearChatEnters").getAsInt())) + "The chat has been cleared";

            // Parse CombatTagSettings
            JsonObject combatTagSettings = json.get("CombatTagSettings").getAsJsonObject();
            combatTagEnabled = combatTagSettings.get("Enabled").getAsBoolean();
            combatTagBlockedCommands = new ParseMessage(combatTagSettings.get("BlockedCommands")).toList();
            combatTagAllowTeleport = combatTagSettings.get("AllowTeleport").getAsBoolean();
            combatTagCooldown = combatTagSettings.get("Cooldown").getAsInt();
            onlyTriggeredByPlayer = combatTagSettings.get("OnlyTriggeredByPlayer").getAsBoolean();

            // Parse TeleportSettings
            JsonObject teleportSettings = json.get("TeleportSettings").getAsJsonObject();
            teleportEnabled = teleportSettings.get("Enabled").getAsBoolean();
            teleportCooldown = teleportSettings.get("TeleportCooldown").getAsInt();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    static {
        defaultconfig = new HashMap<>();

        // ChatSettings configuration
        HashMap<String, Object> chatSettings = new HashMap<>();

        chatSettings.put("Enabled", true);
        chatSettings.put("PlayerChatFormat", "%player_name% : %message%");
        chatSettings.put("AllowPlayerColorCodes", true);
        chatSettings.put("AllowPlayerPlaceholders", false);
        chatSettings.put("ChatItemListing", true);
        chatSettings.put("ChatItemListingFormat", "[item]");
        chatSettings.put("ChatItemListingReplace", "%material%");

        // List for BlockedWords
        List<String> blockedWords = new ArrayList<>();
        blockedWords.add("Nigger"); // Caution: Usage of this term is strictly for example based on input
        chatSettings.put("BlockedWords", blockedWords);

        chatSettings.put("BleurBlockedWords", true);
        chatSettings.put("BleurToken", "*");

        // List for BlockedPunishment
        List<String> blockedPunishment = new ArrayList<>();
        blockedPunishment.add("Mute %player_name% 20m banned words");
        chatSettings.put("BlockedPunishment", blockedPunishment);

        // List for BlockedMessage
        List<String> blockedMessage = new ArrayList<>();
        blockedMessage.add("---------Blocked--------");
        blockedMessage.add("You are not allowed to use %word%");
        blockedMessage.add("Punishment: 20 minute mute");
        blockedMessage.add("-------------------------");
        chatSettings.put("BlockedMessage", blockedMessage);

        // ClearChatEnters setting
        chatSettings.put("ClearChatEnters", 20);

        defaultconfig.put("ChatSettings", chatSettings);

        // CombatTagSettings configuration
        HashMap<String, Object> combatTagSettings = new HashMap<>();

        combatTagSettings.put("Enabled", true);

        // List for BlockedCommands
        List<String> combatTagBlockedCommands = new ArrayList<>();
        combatTagBlockedCommands.add("/tpa");
        combatTagSettings.put("BlockedCommands", combatTagBlockedCommands);

        combatTagSettings.put("AllowTeleport", false);
        combatTagSettings.put("Cooldown", 15);
        combatTagSettings.put("OnlyTriggeredByPlayer", true);

        defaultconfig.put("CombatTagSettings", combatTagSettings);

        // TeleportSettings configuration
        HashMap<String, Object> teleportSettings = new HashMap<>();
        teleportSettings.put("Enabled", true);
        teleportSettings.put("TeleportCooldown", 15);

        defaultconfig.put("TeleportSettings", teleportSettings);

        // BlockedCommandsEnable and BlockedCommands settings (if they exist)
        List<String> blockedCommands = new ArrayList<>();
        blockedCommands.add("/ban");
        blockedCommands.add("/kick");
        defaultconfig.put("BlockedCommands", blockedCommands);
    }
}
