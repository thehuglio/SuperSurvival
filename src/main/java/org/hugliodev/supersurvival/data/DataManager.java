package org.hugliodev.supersurvival.data;

import org.hugliodev.supersurvival.data.conf.MainConfDis;
import org.hugliodev.supersurvival.data.datafiles.PlayerData;
import org.hugliodev.supersurvival.data.datafiles.ServerData;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DataManager {
    final private static HashMap<String,IData> dataHashMap = new HashMap<>();
    public static void reload() {
        for (Map.Entry<String, IData> data : dataHashMap.entrySet()) {
            data.getValue().reload();
            System.out.println(data.getKey() + " has been reloaded");
        }
    }
    public static void initialize(File dataFile) {
        dataHashMap.put("MainConf.json",new MainConfDis().Instance(new File(dataFile,"MainConf.json")));
        dataHashMap.put("PlayerData.conf",new PlayerData().Instance(new File(dataFile,"PlayerData.conf")));
        dataHashMap.put("ServerData.conf",new ServerData().Instance(new File(dataFile,"ServerData.conf")));
        reload();
    }
}
