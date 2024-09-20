package org.hugliodev.supersurvival.data.datafiles;

import org.hugliodev.supersurvival.features.active.spawn.Spawn;
import org.hugliodev.supersurvival.features.active.warp.Warp;
import org.hugliodev.supersurvival.data.datafiles.playerdata.PlayerData;

public class DataHolder {
    public static DataClass warp = new Warp();
    public static DataClass spawn = new Spawn();
    public static DataClass playerdata = new PlayerData();
}
