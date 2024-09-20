package org.hugliodev.supersurvival.data.datafiles;

import com.google.gson.JsonObject;

import java.util.HashMap;

public interface DataClass {
    void fromJson(JsonObject jsonObject);
    HashMap<String,Object> toHash();
}
