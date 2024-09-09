package org.hugliodev.supersurvival.commands;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.hugliodev.supersurvival.Util.SurgestionSafe;

import java.util.List;

public interface IMainCommand extends TabExecutor {

    String getCommand();
    /**
     * @return All alliases from this command
     */
    List<String> getAliases();

    /**
     * @return the useage of this command
     */
    String getUsage();

    /**
     * @return the description of this command
     */
    String getDescription();

    /**
     * @return the minimum amount of args needed to run this command
     */
    int getMinArgs();

    /**
     * @return the maximum amount of args needed to run this command
     */
    int getMaxArgs();
    /**
     * @return if the command can be run from console
     */
    boolean canBeExecutedByConsole();

    /**
     *
     */
    default boolean DefaultPermissionOp() {
        return false;
    }

    /**
     * @return if the command should be displayed
     */
    boolean displayCommand();

    /**
     * executes the command
     * @param player player who executed the command
     * @param args the subcommands
     */
    void execute(Player player, String[] args);
    /**
     * executes the command
     * @param player player who executed the command
     * @param s main command string
     * @param args the subcommands
     */
    void execute(Player player, String s, String[] args);
    /**
     * executes the command
     * @param consoleCommandSender console executed the command
     * @param args the subcommands
     */

    void execute(ConsoleCommandSender consoleCommandSender, String[] args);
    /**
     * executes the command
     * @param consoleCommandSender console executed the command
     * @param s main command string
     * @param args the subcommands
     */
    void execute(ConsoleCommandSender consoleCommandSender, String s, String[] args);
    /**
     * executes the command
     * @param args the subcommands
     */

    void execute(String[] args);
    /**
     * returns the tabcomplete for this command
     */

    SurgestionSafe tabComplete();

}
