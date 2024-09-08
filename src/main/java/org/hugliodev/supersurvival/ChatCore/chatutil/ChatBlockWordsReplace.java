package org.hugliodev.supersurvival.ChatCore.chatutil;

import org.hugliodev.supersurvival.data.configfiles.ConfMain;

public class ChatBlockWordsReplace implements IChatUtil {
    @Override
    public String apply(String s) {
        for (String blocked : ConfMain.blockedWords) {
            if (s.contains(blocked)) {
                s = s.replace(blocked,createBleur(blocked.length()));
            }
        }
        return s;
    }
    private String createBleur(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        for (;i>0; i--) {
            stringBuilder.append(ConfMain.bleurToken);
        }
        return stringBuilder.toString();
    }
}
