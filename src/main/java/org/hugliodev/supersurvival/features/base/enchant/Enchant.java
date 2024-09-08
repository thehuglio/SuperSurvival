package org.hugliodev.supersurvival.features.base.enchant;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Enchant {
    public static void enchantItem(Player player, Enchantment enchantment, int level) {
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item.containsEnchantment(enchantment)) item.removeEnchantment(enchantment);
        item.addUnsafeEnchantment(enchantment,level);
        player.getInventory().setItemInMainHand(item);
    }
}
