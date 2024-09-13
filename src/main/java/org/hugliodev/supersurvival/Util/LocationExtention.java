package org.hugliodev.supersurvival.Util;

import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.hugliodev.supersurvival.core.Message;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class LocationExtention extends org.bukkit.Location {
    /**
     * Constructs a new Location with the given coordinates
     *
     * @param world The world in which this location resides
     * @param x     The x-coordinate of this new location
     * @param y     The y-coordinate of this new location
     * @param z     The z-coordinate of this new location
     */
    public LocationExtention(@Nullable World world, double x, double y, double z) {
        super(world, x, y, z);
    }
    public LocationExtention(JsonObject jsonObject) {
        super(Bukkit.getWorld(UUID.fromString(jsonObject.get("world").getAsString())),
                jsonObject.get("x").getAsDouble(),
                jsonObject.get("y").getAsDouble(),
                jsonObject.get("z").getAsDouble());
    }
    public HashMap<String,Object> toHash() {
        HashMap<String,Object> temp = new HashMap<>();
        temp.put("world", Objects.requireNonNull(super.getWorld().getUID()));
        temp.put("x",super.getX());
        temp.put("y",super.getY());
        temp.put("z",super.getZ());
        return temp;
    }

    public ParseMessage toMessage() {
        ParseMessage message = Message.FORMAT_LOCATION.getMessage();
        message.extraPlaceholders(new String[]{"%world%","%x%","%y%","%z%"},new String[]{getWorld().toString(),String.valueOf(getBlockX()),String.valueOf(getBlockY()),String.valueOf(getBlockZ())});
        return message;
    }

    @Override
    public String toString() {
        return toMessage().toString();
    }
}
