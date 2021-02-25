package me.spear.ue.freeze.tasks;

import me.spear.ue.UltimateEssentials;
import me.spear.ue.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;

public class FreezeTask extends BukkitRunnable {

    private final UltimateEssentials ultimateEssentials;
    private final String serverIP;

    public FreezeTask() {
        this.ultimateEssentials = JavaPlugin.getPlugin(UltimateEssentials.class);
        this.serverIP = ultimateEssentials.getConfig().getString("server-ip");
    }

    @Override
    public void run() {
        if (ultimateEssentials.getFreezeHandler().getFrozenMap().isEmpty()) {
            return;
        }

        ultimateEssentials.getFreezeHandler().getFrozenMap().keySet().forEach(uuid -> {
            Player player = Bukkit.getPlayer(uuid);

            if (player == null) {
                return;
            }

            Inventory inventory = Bukkit.createInventory(null, 9, "Frozen");

            ItemStack stack = new ItemStack(Material.BOOK);
            ItemMeta meta = stack.getItemMeta();

            meta.setDisplayName(CC.translate("&cFrozen"));
            meta.setLore(Arrays.asList(CC.translate("&cYou are currently frozen, please join ts." + this.serverIP)));
            stack.setItemMeta(meta);

            inventory.setItem(5 - 1, stack);

            if (!player.getOpenInventory().getTitle().equalsIgnoreCase("Frozen")) {
                player.closeInventory();
                player.openInventory(inventory);
            }

        });

    }
}
