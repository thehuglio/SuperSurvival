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
            JsonObject chatSettings = json.get("ChatSettings").getAsJsonObject();
            JsonObject combatTagSettings = json.get("CombatTagSettings").getAsJsonObject();
            chatEnabled = chatSettings.get("enabled").getAsBoolean();
            playerchatformat = new ParseMessage(chatSettings.get("playerchatformat"));
            allowplayercollorcodes = chatSettings.get("allowplayercollorcodes").getAsBoolean();
            allowplayerplaceholders = chatSettings.get("allowplayerplaceholders").getAsBoolean();
            chatItemListing = chatSettings.get("chatItemListing").getAsBoolean();
            chatItemListingFormat = chatSettings.get("chatItemListingFormat").getAsString();
            chatItemListingReplace = chatSettings.get("chatItemListingReplace").getAsString();
            bleurBlockedWords = chatSettings.get("bleurBlockedWords").getAsBoolean();
            bleurToken = chatSettings.get("bleurToken").getAsString();
            blockedMessage = new ParseMessage(chatSettings.get("blockedMessage"));

            blockedWords = new ArrayList<>();
            chatSettings.get("blockedWords").getAsJsonArray().forEach(jsonElement -> blockedWords.add(jsonElement.getAsString()));

            blockedPunishement = new ArrayList<>();
            chatSettings.get("blockedPunishement").getAsJsonArray().forEach(jsonElement -> blockedPunishement.add(jsonElement.getAsString()));
            clearChatEnters = "\n".repeat(Math.max(0, chatSettings.get("clearChatEnters").getAsInt())) + "The chat has been cleared";
            combatTagEnable = combatTagSettings.get("Enabled").getAsBoolean();
            combatTagBlockedCommands = new ParseMessage(combatTagSettings.get("BlockedCommands")).toList();
            combatTagAllowTeleport = combatTagSettings.get("AllowTeleport").getAsBoolean();
            combatTagCooldown = combatTagSettings.get("CombatTagCooldown").getAsInt();
            onlyTriggeredByPlayer = combatTagSettings.get("OnlyTriggeredByPlayer").getAsBoolean();
            return true;
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            return false;
        }
    }

    static {
        defaultconfig = new HashMap<>();

        // Chat settings (as implemented previously)
        HashMap<String, Object> chatSettings = new HashMap<>();

        chatSettings.put("enabled", true);
        chatSettings.put("playerchatformat", "%player_name% :");
        chatSettings.put("allowplayercollorcodes", true);
        chatSettings.put("allowplayerplaceholders", false);
        chatSettings.put("chatItemListing", true);
        chatSettings.put("chatItemListingFormat", "[item]");
        chatSettings.put("chatItemListingReplace", "%material%");

        // List for blockedWords
        List<String> blockedWords = new ArrayList<>();
        blockedWords.add("nigger");
        chatSettings.put("blockedWords", blockedWords);

        chatSettings.put("bleurBlockedWords", true);
        chatSettings.put("bleurToken", "*");

        // List for blockedPunishement
        List<String> blockedPunishement = new ArrayList<>();
        blockedPunishement.add("mute %player_name% 20m banned words");
        chatSettings.put("blockedPunishement", blockedPunishement);

        // List for blockedMessage
        List<String> blockedMessage = new ArrayList<>();
        blockedMessage.add("---------blocked--------");
        blockedMessage.add("you are not allowed to use %word%");
        blockedMessage.add("Punishement: 20 minute mute");
        blockedMessage.add("-------------------------");
        chatSettings.put("blockedMessage", blockedMessage);

        defaultconfig.put("ChatSettings", chatSettings);

        // CombatTagSettings
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
    }
}
