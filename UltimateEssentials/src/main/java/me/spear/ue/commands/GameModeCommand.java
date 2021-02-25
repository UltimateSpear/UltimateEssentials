package me.spear.ue.commands;

import me.spear.ue.util.CC;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModeCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(CC.translate("&cThis is a player command only"));
            return false;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("ue.gamemode")) {
            player.sendMessage(CC.translate("&cYou do not have permission to execute this command!"));
            return false;
        }

        if (args.length != 1) {
            player.sendMessage(CC.translate("&c/gamemode [s/a/c]"));
            return false;
        }

        switch (args[0]) {
            case "s":
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(CC.translate("Updated your gamemode to &SURVIVAL!"));
                break;
            case "a":
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(CC.translate("Updated your gamemode to &eADVENTURE!"));
                break;
            case "c":
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(CC.translate("Updated your gamemode to &CREATIVE!"));
                break;
            default:
                player.sendMessage(CC.translate("&cThat is not a valid gamemode!"));
                break;
        }


        return false;
    }
}
