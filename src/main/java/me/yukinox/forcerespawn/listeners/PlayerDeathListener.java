package me.yukinox.forcerespawn.listeners;

import me.yukinox.forcerespawn.ForceRespawn;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerDeathListener implements Listener {

    ForceRespawn plugin;

    public PlayerDeathListener(ForceRespawn plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        event.getDrops().clear();
        player.setHealth(20);
        player.setFireTicks(0);
        player.setFoodLevel(20);
        player.setSaturation(20);
        for (ItemStack item : player.getInventory().getContents()) {
            if (item != null && item.getType() != Material.AIR) {
                player.getWorld().dropItem(player.getLocation(), item);
            }
        }
        player.getInventory().clear();
        player.getActivePotionEffects().forEach(effect -> player.removePotionEffect(effect.getType()));
        player.teleport(player.getWorld().getSpawnLocation());
    }
}
