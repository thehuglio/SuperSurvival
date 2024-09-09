package org.hugliodev.supersurvival.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ICommand extends IMainCommand {
    @Override
    default boolean displayCommand() {return true;}

    @Override
    default boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            execute(player,label,args);
            return true;
        } else if (sender instanceof ConsoleCommandSender console) {
            execute(console,label,args);
        }
        return true;
    }

    @Override
    default void execute(ConsoleCommandSender consoleCommandSender,String s ,String[] args) {execute(consoleCommandSender,args);}

    @Override
    default void execute(ConsoleCommandSender consoleCommandSender, String[] args) {
        execute(args);
    }

    @Override
    default void execute(Player player, String s, String[] args) {execute(player,args);}

    @Override
    default void execute(Player player, String[] args) {
        execute(args);
    }

    @Override
    default void execute(String[] args) {
    }

    @Override
    default int getMinArgs() {
        return 0;
    }

    @Override
    default int getMaxArgs() {
        return 127;
    }

    @Nullable
    @Override
    default List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        SurgestionSafe surgestionSafe = this.tabComplete();
        if (surgestionSafe == null) {
            return null;
        } else if (args.length < 1) {
            return surgestionSafe.currentcommands;
        } else {
            for (int i = 0; i < args.length - 1; i++) {
                surgestionSafe = surgestionSafe.hash.get(args[i]);
                if (surgestionSafe == null) {
                    return null;
                }
            }
            return surgestionSafe.currentcommands;
        }
    }
}
