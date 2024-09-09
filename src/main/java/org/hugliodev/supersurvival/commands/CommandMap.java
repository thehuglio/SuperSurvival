package org.hugliodev.supersurvival.commands;

import org.hugliodev.supersurvival.Util.SurgestionSafe;
import java.util.*;

public abstract class CommandMap {
    public final List<IMainCommand> commandList = new ArrayList<>();
    public final HashMap<String, SurgestionSafe> surgestionMap = new HashMap<>();

    public void register(IMainCommand command) {
        for (String s : command.getAliases()) {
            if (command.tabComplete() == null) {
                surgestionMap.put(s.toLowerCase(Locale.ENGLISH),null);
            } else {
                surgestionMap.put(s.toLowerCase(Locale.ENGLISH),command.tabComplete());
            }
        }
        commandList.add(command);
    }
}
