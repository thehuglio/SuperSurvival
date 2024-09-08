package org.hugliodev.supersurvival.commands.admin;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.hugliodev.supersurvival.commands.IAdminCommand;
import org.hugliodev.supersurvival.core.Message;
import org.hugliodev.supersurvival.features.base.enchant.Enchant;

import java.util.List;

public class CmdEnchant implements IAdminCommand {
    @Override
    public String getPermission() {
        return "enchant";
    }

    @Override
    public String getCommand() {
        return "enchant";
    }

    @Override
    public List<String> getAliases() {
        return List.of("enchant");
    }

    @Override
    public String getUsage() {
        return "/enchant <enchantment> <level>";
    }

    @Override
    public String getDescription() {
        return "give an enchant without restrictions";
    }

    @Override
    public int getMinArgs() {
        return 1;
    }

    @Override
    public int getMaxArgs() {
        return 2;
    }

    @Override
    public boolean canBeExecutedByConsole() {
        return false;
    }

    @Override
    public SurgestionSafe tabComplete() {
        return null;
    }

    @Override
    public void execute(Player player, String[] args) {
        try {
            Enchant.enchantItem(player, Enchantment.getByKey(NamespacedKey.fromString(args[0])), Integer.parseInt(args[1]));
        } catch (Exception e) {
            if (e instanceof NumberFormatException) {
                player.sendMessage(Message.NOT_AN_NUMBER.getMessage().toString(player,new String[]{"%supersurvival_command_numberexeption%"},new String[]{args[1]}));
            } else throw e;
        }
        Message.COMMAND_ENCHANT_FINISH.send(player);
    }
}
