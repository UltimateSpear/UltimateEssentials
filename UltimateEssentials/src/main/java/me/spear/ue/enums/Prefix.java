package me.spear.ue.enums;

import org.bukkit.plugin.java.JavaPlugin;
import me.spear.ue.UltimateEssentials;

public enum Prefix {

    STAFFCHAT(JavaPlugin.getPlugin(UltimateEssentials.class).getConfig().getString("staffchat.prefix"));

    private final String prefix;
    private final UltimateEssentials ultimateEssentials;

    Prefix(String prefix) {
        this.prefix = prefix;
        this.ultimateEssentials = JavaPlugin.getPlugin(UltimateEssentials.class);
    }

    public String getPrefix() {
        return this.prefix;
    }

}
