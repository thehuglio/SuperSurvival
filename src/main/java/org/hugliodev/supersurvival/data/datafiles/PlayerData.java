package org.hugliodev.supersurvival.data.datafiles;

import com.google.gson.JsonObject;
import org.hugliodev.supersurvival.data.AData;

import java.util.HashMap;

public class PlayerData extends AData {
    @Override
    protected boolean dataDistributor(JsonObject json) {
        return false;
    }

    @Override
    protected HashMap<String, Object> getData() {
        return null;
    }
}
