package org.hugliodev.supersurvival.playerdata;

import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.features.DataClass;
import org.hugliodev.supersurvival.Util.LocationExtention;

import javax.annotation.Nullable;
import java.util.HashMap;

public class PlayerData implements DataClass {
    private static HashMap<OfflinePlayer,Data> playerDataHashMap;

    public static void setPlayerDataHashMap(HashMap<OfflinePlayer, Data> playerDataHashMap) {
        PlayerData.playerDataHashMap = playerDataHashMap;
    }
    public static void addPlayer(Player player) {
        playerDataHashMap.put(player, new Data());
    }
    public static void addHome(Player player, @Nullable String s, Location location) {
        playerDataHashMap.get(player).sethome(s,(LocationExtention) location);
    }
    public static void addHome(Player player, @Nullable String s) {
        playerDataHashMap.get(player).sethome(s,(LocationExtention) player.getLocation());
    }
    public static void setLastLoc(Player player, Location location) {
        playerDataHashMap.get(player).setLastLoc(location);
    }
    public static LocationExtention getLastLoc(Player player) {
        return (LocationExtention) playerDataHashMap.get(player).getLastLoc();
    }
    public static LocationExtention getHome(Player player, @Nullable String s) {
        return playerDataHashMap.get(player).getHome(s);
    }

    @Override
    public void fromJson(JsonObject jsonObject) {
        playerDataHashMap = new HashMap<>();
        jsonObject.entrySet().forEach(entry -> playerDataHashMap.put(Bukkit.getOfflinePlayer(entry.getKey()),new Data(entry.getValue().getAsJsonObject())));
    }

    @Override
    public HashMap<String,Object> toHash() {
        HashMap<String, Object> temp = new HashMap<>();
        playerDataHashMap.forEach((key, value) -> temp.put(key.getUniqueId().toString(), value.toHash()));
        return temp;
    }
}
