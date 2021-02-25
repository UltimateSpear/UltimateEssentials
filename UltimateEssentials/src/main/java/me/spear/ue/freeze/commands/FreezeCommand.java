package me.spear.ue.freeze.commands;

import me.spear.ue.UltimateEssentials;
import me.spear.ue.freeze.FreezeHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import me.spear.ue.util.CC;

public class FreezeCommand implements CommandExecutor {

    private final FreezeHandler freezeHandler;

    public FreezeCommand() {
        this.freezeHandler = JavaPlugin.getPlugin(UltimateEssentials.class).getFreezeHandler();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(CC.translate("&cThis is a player command only"));
            return false;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("ue.freeze")) {
            player.sendMessage(CC.translate("&cYou do not have permissions to execute this command!"));
            return false;
        }

        if (args.length != 1) {
            player.sendMessage(CC.translate("&c/freeze <player>"));
            return false;
        }

        if (args[0].isEmpty()) {
            player.sendMessage(CC.translate("&cPlease insert a valid player name!"));
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            player.sendMessage(CC.translate("&cThat player does not exist!"));
            return false;
        }

        if (freezeHandler.isFrozen(player)) {
            freezeHandler.setFrozen(player, false);
            player.sendMessage(CC.translate("&cThe player " + target.getName() + " has been unfrozen!"));
        } else {
            freezeHandler.setFrozen(player, true);
            player.sendMessage(CC.translate("&aThe player" + target.getName() + " has been frozen!"));
        }
        return false;
    }
}
