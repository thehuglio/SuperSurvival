package org.hugliodev.supersurvival.Util;

import java.util.HashMap;
import java.util.List;

public class SurgestionSafe {
    public HashMap<String,SurgestionSafe> hash = null;
    public List<String> currentcommands;
    public SurgestionSafe(HashMap<String,SurgestionSafe> hash) {
        this.hash = hash;
        this.currentcommands = hash.keySet().stream().toList();
    }
    public SurgestionSafe(List<String> list) {
        this.currentcommands = list;
    }
}
