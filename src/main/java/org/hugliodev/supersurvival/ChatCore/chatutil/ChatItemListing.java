package org.hugliodev.supersurvival.ChatCore.chatutil;

import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

import static org.hugliodev.supersurvival.data.configfiles.ConfMain.*;

public class ChatItemListing implements IChatUtil {
    public String apply(Player player, String s) {
        if (s.contains(chatItemListingFormat)) {
            TextComponent text = new TextComponent();
            text.setText(chatItemListingReplace);
            ItemMeta itemMeta = player.getInventory().getItemInMainHand().getItemMeta();
            assert itemMeta != null;
            List<String> lore = itemMeta.getLore();
            if (lore == null) lore = new ArrayList<>();
            lore.addFirst(itemMeta.getItemName());
            text.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(lore.toString()).create()));
            return s.replace(chatItemListingFormat,text.toString());
        }
        return s;
    }
    public String permission() {
        return "ItemListing";
    }
}
