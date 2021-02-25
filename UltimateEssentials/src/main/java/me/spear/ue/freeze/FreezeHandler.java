package me.spear.ue.freeze;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class FreezeHandler {

    private final HashMap<UUID, String> frozenPlayer;

    public FreezeHandler() {
        this.frozenPlayer = new HashMap<>();
    }

    public void setFrozen(Player player, boolean set) {
        if (set == true) {
            if (isFrozen(player)) {
                frozenPlayer.remove(player.getUniqueId());
                frozenPlayer.put(player.getUniqueId(), player.getName());
            } else {
                frozenPlayer.put(player.getUniqueId(), player.getName());
            }
        } else {
            if (frozenPlayer.containsKey(player.getUniqueId())) {
                frozenPlayer.remove(player.getUniqueId());
            }
         }
    }

    public boolean isFrozen(Player player) {
        return this.frozenPlayer.containsKey(player.getUniqueId());
    }

    public HashMap<UUID, String> getFrozenMap() {
        return this.frozenPlayer;
    }

}
