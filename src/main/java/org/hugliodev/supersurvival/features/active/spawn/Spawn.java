package org.hugliodev.supersurvival.features.active.spawn;

import com.google.gson.JsonObject;
import org.bukkit.Location;
import org.hugliodev.supersurvival.data.datafiles.DataClass;
import org.hugliodev.supersurvival.Util.LocationExtention;

import java.util.HashMap;

public class Spawn implements DataClass {
    private static LocationExtention location;

    public static LocationExtention getSpawn() {
        return location;
    }

    public static void setSpawn(Location spawn) {
        location = (LocationExtention) spawn;
    }

    @Override
    public void fromJson(JsonObject jsonObject) {
        location = new LocationExtention(jsonObject);
    }

    @Override
    public HashMap<String, Object> toHash() {
        return location.toHash();
    }
}
