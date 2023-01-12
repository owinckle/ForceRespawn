package me.yukinox.forcerespawn;

import me.yukinox.forcerespawn.listeners.PlayerDeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ForceRespawn extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
