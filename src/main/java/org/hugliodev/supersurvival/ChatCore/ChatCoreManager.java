package org.hugliodev.supersurvival.ChatCore;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.hugliodev.supersurvival.ChatCore.chatutil.*;

import static org.hugliodev.supersurvival.data.configfiles.ConfMain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ChatCoreManager implements Listener {

    public ChatCoreManager(Plugin plugin) {
        if (chatEnabled) {
            plugin.getServer().getPluginManager().registerEvents(this,plugin);
            loadChatCoreManager();

        }
    }
    private static final List<IChatUtil> chatCoreMessageActions = new ArrayList<>();
    private static void loadChatCoreManager() {
        if (bleurBlockedWords) addAction(new ChatBlockWordsReplace());
        else addAction(new ChatBlockWordsRemove());
        addAction(new ChatFormat());
        if (chatItemListing) new ChatItemListing();
    }
    public static void addAction(IChatUtil i) {
        chatCoreMessageActions.add(i);
    }

    @EventHandler
    private void getMessages(PlayerChatEvent event) {
        System.out.println(event.getMessage());
        AtomicReference<String> s = new AtomicReference<>(event.getMessage());
        chatCoreMessageActions.forEach(i -> {
            s.set(i.use(event.getPlayer(), s.get()));
            System.out.println(s.get());
        });
        event.setMessage(s.get());
        System.out.println(s.get());
    }

}
