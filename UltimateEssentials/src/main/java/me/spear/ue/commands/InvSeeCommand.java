package me.spear.ue.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import me.spear.ue.util.CC;

public class InvSeeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(CC.translate("&cThis is a player command only"));
            return false;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("ue.invsee")) {
            player.sendMessage(CC.translate("&cYou do not have enough permissions to execute this command!"));
            return false;
        }

        if (args.length != 1) {
            player.sendMessage(CC.translate("&c/invsee <player>"));
            return false;
        }

        if (args[0].isEmpty()) {
            player.sendMessage(CC.translate("&cPlease input a valid player name!"));
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            player.sendMessage(CC.translate("&cThat player does not exist or is not online!"));
            return false;
        }

        Inventory inventory = Bukkit.createInventory(null, 54, target.getName() + "'s Inventory");
        inventory.setContents(target.getInventory().getContents());
        inventory.setItem(45, target.getInventory().getHelmet());
        inventory.setItem(46, target.getInventory().getChestplate());
        inventory.setItem(47, target.getInventory().getLeggings());
        inventory.setItem(48, target.getInventory().getBoots());

        player.openInventory(inventory);
        player.sendMessage(CC.translate("&aCurrently viewing " + target.getName() + "'s inventory!"));
        return false;
    }
}
