package org.hugliodev.supersurvival.data.datafiles;

import com.google.gson.JsonObject;
import org.hugliodev.supersurvival.data.AData;
import org.hugliodev.supersurvival.data.DataManager;

import java.util.HashMap;

public class PlayerData extends AData {
    @Override
    protected boolean dataDistributor(JsonObject json) {
        DataHolder.playerdata.fromJson(json);
        return true;
    }

    @Override
    protected HashMap<String, Object> getData() {
        return DataHolder.playerdata.toHash();
    }
}
