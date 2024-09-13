package org.hugliodev.supersurvival.ChatCore.chatutil;

import org.hugliodev.supersurvival.data.configfiles.MainConfData;

public class ChatBlockWordsRemove implements IChatUtil {
    @Override
    public String apply(String s) {
        for (String blocked : MainConfData.blockedWords) {
            if (s.contains(blocked)) return null;
        }
        return s;
    }
}
