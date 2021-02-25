package me.spear.ue.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvSeeListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        if (!(e.getWhoClicked() instanceof Player)) {
            return;
        }

        if (e.getClickedInventory() == null) {
            return;
        }

        if (!e.getClickedInventory().getTitle().contains("'s Inventory")) {
            return;
        }

        if (e.getCurrentItem() != null) {
            e.setCancelled(true);
        }
    }

}
