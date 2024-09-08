package org.hugliodev.supersurvival.features;

import com.google.gson.JsonObject;

import java.util.HashMap;

public interface DataClass {
    void fromJson(JsonObject jsonObject);
    HashMap<String,Object> toHash();
}
