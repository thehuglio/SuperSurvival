package org.hugliodev.supersurvival.data.datafiles;

import com.google.gson.JsonObject;
import org.hugliodev.supersurvival.data.AData;

import java.util.HashMap;

public class ServerData extends AData {
    @Override
    protected boolean dataDistributor(JsonObject json) {
        DataHolder.warp.fromJson(json.get("warp").getAsJsonObject());
        DataHolder.spawn.fromJson(json.get("spawn").getAsJsonObject());
        return false;
    }

    @Override
    protected HashMap<String, Object> getData() {
        HashMap<String,Object> temp = new HashMap<>();
        temp.put("warp",DataHolder.warp.toHash());
        temp.put("spawn",DataHolder.spawn.toHash());
        return temp;
    }
}
