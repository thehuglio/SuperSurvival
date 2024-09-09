package org.hugliodev.supersurvival.data;

import com.google.gson.*;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public abstract class AConfig implements IData {

    protected File file;
    @Override
    public IData Instance(File file) {
        this.file = file;
        reload();
        return this;
    }

    @Override
    public boolean reload() {
        safeFile();
        if (file.exists()) {
            try {
                JsonElement jsonElement = JsonParser.parseReader(new FileReader(file));
                if (!jsonElement.isJsonNull()) {
                    if (jsonElement.isJsonObject()) {
                        dataDistributor(jsonElement.getAsJsonObject());
                        return true;
                    }
                }
            } catch (Exception ignore) {
                return false;
            }
        }
        return false;
    }
    @Override
    public boolean safeFile() {
        file.getParentFile().mkdirs();
        if (!file.exists()) {
            try {
                Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().serializeNulls().create();
                PrintWriter pw = new PrintWriter(file, StandardCharsets.UTF_8);
                pw.write(gson.toJson(defaultconfig));
                pw.flush();
                pw.close();
                return true;
            } catch (Exception e) {
                System.out.println(e);
                return false;
            }
        }
        return false;
    }
    protected abstract boolean dataDistributor(JsonObject json);
    protected static HashMap<String,Object> defaultconfig;
}

