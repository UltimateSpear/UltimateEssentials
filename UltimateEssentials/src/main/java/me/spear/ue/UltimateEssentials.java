package me.spear.ue;

import lombok.Getter;
import me.spear.ue.commands.FeedCommand;
import me.spear.ue.commands.HealCommand;
import me.spear.ue.commands.InvSeeCommand;
import org.bukkit.plugin.java.JavaPlugin;
import me.spear.ue.commands.GameModeCommand;
import me.spear.ue.listeners.InvSeeListener;
import me.spear.ue.freeze.commands.FreezeCommand;
import me.spear.ue.freeze.FreezeHandler;
import me.spear.ue.freeze.tasks.FreezeTask;

public class UltimateEssentials extends JavaPlugin {

    @Getter private FreezeHandler freezeHandler;

    @Override
    public void onEnable() {
        registerCommands();
        getServer().getPluginManager().registerEvents(new InvSeeListener(), this);

        this.freezeHandler = new FreezeHandler();
        new FreezeTask().runTaskTimerAsynchronously(this, 10L, 10L);
    }

    private void registerCommands() {
        getCommand("gamemode").setExecutor(new GameModeCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("invsee").setExecutor(new InvSeeCommand());
        getCommand("freeze").setExecutor(new FreezeCommand());
    }

}
