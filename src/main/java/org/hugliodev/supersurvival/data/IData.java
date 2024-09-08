package org.hugliodev.supersurvival.data;

import java.io.File;

public interface IData {
    IData Instance(File file);
    boolean safeFile();
    boolean reload();

}
