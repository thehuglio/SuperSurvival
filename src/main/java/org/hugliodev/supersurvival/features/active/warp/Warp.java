package org.hugliodev.supersurvival.features.active.warp;

import com.google.gson.JsonObject;
import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.data.datafiles.DataClass;
import org.hugliodev.supersurvival.Util.LocationExtention;

import javax.annotation.Nullable;
import java.util.HashMap;

public class Warp implements DataClass {
    public record warp(
            String name,
            LocationExtention location,
            @Nullable String permission
    ){
        public HashMap<String,Object> toHash() {
            HashMap<String,Object> temp = new HashMap<>();
            temp.put("name", name);
            temp.put("permission",permission);
            temp.put("location",location.toHash());
            return temp;
        }
    }
    private static HashMap<String,warp> warpMap;

    public static void setWarp(String name, LocationExtention location,@Nullable String permission) {
        if (!warpMap.containsKey(name)) warpMap.put(name,new warp(name,location,permission));
        else warpMap.replace(name,new warp(name,location,permission));
    }
    public static LocationExtention getWarp(Player player, String name) {
        warp warp = warpMap.get(name);
        if (warp.permission != null) {
            if (player.hasPermission("superskyblock.warp.permission." + warp.permission) || player.isOp()) {
                return warp.location;
            }
            return null;
        }
        return warp.location;
    }
    @Override
    public void fromJson(JsonObject jsonObject) {
        setWarp(jsonObject.get("name").getAsString(),new LocationExtention(jsonObject.get("location").getAsJsonObject()),jsonObject.get("permission").isJsonNull() ? null : jsonObject.get("permission").getAsString());
    }
    @Override
    public HashMap<String,Object> toHash() {
        HashMap<String,Object> hashMapList = new HashMap<>();
        warpMap.values().forEach(warp -> hashMapList.put(warp.name,warp.toHash()));
        return hashMapList;
    }
}
