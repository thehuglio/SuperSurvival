package org.hugliodev.supersurvival.playerdata;

import com.google.gson.JsonObject;
import org.bukkit.Location;
import org.hugliodev.supersurvival.Util.LocationExtention;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class Data {
    @Nullable
    private Location lastLoc;
    @Nullable public LocationExtention mainHome;
    private final HashMap<String, LocationExtention> playerHomes;
    public boolean sc = false;


    public Data(@Nullable Location location, @Nullable LocationExtention mainHome, @Nullable HashMap<String,LocationExtention> playerHomes, @Nullable LocationExtention spawn) {
        this.lastLoc = location;
        this.mainHome = mainHome;
        this.playerHomes = playerHomes;
    }
    public Data(JsonObject jsonObject) {
        this.lastLoc = null;
        this.mainHome = new LocationExtention(jsonObject.get("MainHome").getAsJsonObject());
        this.playerHomes = new HashMap<>();
        jsonObject.get("Homes").getAsJsonObject().entrySet().forEach(entry -> playerHomes.put(entry.getKey(), new LocationExtention(entry.getValue().getAsJsonObject())));
    }
    public Data() {
        this.lastLoc = null;
        this.mainHome = null;
        this.playerHomes = new HashMap<>();
    }

    public void sethome(@Nullable String s, LocationExtention home) {
        if (s == null) {
            mainHome = home;
        } else if (playerHomes.containsKey(s)) {
            playerHomes.replace(s,home);
        } else {
            playerHomes.put(s,home);
        }
    }

    @Nullable
    public Location getLastLoc() {
        return lastLoc;
    }

    public void setLastLoc(@Nullable Location lastLoc) {
        this.lastLoc = lastLoc;
    }

    @Nullable
    public LocationExtention getHome(@Nullable String s) {
        return s == null ? mainHome : playerHomes.get(s);
    }
    public HashMap<String, Object> toHash() {
        HashMap<String,Object> temp = new HashMap<>();
        HashMap<String,Object> homes = new HashMap<>();
        for (Map.Entry<String, LocationExtention> home : playerHomes.entrySet()) {
            homes.put(home.getKey(),home.getValue().toHash());
        }
        temp.put("Homes",homes);
        temp.put("MainHome",mainHome.toHash());
        return temp;
    }

    public boolean getSc() {
        return sc;
    }

    public void toggleSc() {
        sc = !sc;
    }
}
