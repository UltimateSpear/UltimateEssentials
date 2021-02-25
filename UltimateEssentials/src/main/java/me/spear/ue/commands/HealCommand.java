package me.spear.ue.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.spear.ue.util.CC;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(CC.translate("&cThis is a player command only"));
            return false;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("ue.heal")) {
            player.sendMessage(CC.translate("&cYou do not have permissions to execute this command!"));
            return false;
        }

        if (player.getHealth() >= 20D) {
            player.sendMessage(CC.translate("&aYou are already at full health!"));
            return false;
        }

        player.setHealth(20D);
        player.sendMessage(CC.translate("&aYou have been healed!"));

        return false;
    }
}
