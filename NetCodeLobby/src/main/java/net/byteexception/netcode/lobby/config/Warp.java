package net.byteexception.netcode.lobby.config;

import net.byteexception.cloud.ItemBuilder.ItemBuilder;
import net.byteexception.netcode.lobby.LobbyPlugin;
import net.byteexception.netcode.lobby.user.User;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

/**
 *Warp is a Warp Manager Class
 *
 * @author Mike
 *
 */

public enum  Warp {

    SPAWN(new ItemBuilder().setMaterial(Material.SLIME_BALL).setName("§aSpawn").build()),
    BUILD(new ItemBuilder().setMaterial(Material.GRASS).setName("§2Bauevent").build()),
    SURVIVAL(new ItemBuilder().setMaterial(Material.SKULL_ITEM).setData(2).setName("§7Survival").build()),
    RPG(new ItemBuilder().setMaterial(Material.GOLD_PICKAXE).setName("§6R§eoll §6P§elay §6G§ame").build());

    private ItemStack itemStack;

    Warp(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setLocation(Location location){
        LobbyPlugin.getInstance().getConfig().set("locations.".concat(name().toLowerCase()),location);
        LobbyPlugin.getInstance().saveConfig();
    }

    public Location getLocation() {
        LobbyPlugin plugin = LobbyPlugin.getInstance();
        String key = "locations.".concat(name().toLowerCase());
        if(plugin.getConfig().contains(key)) {
            return (Location)plugin.getConfig().get(key);
        }

        return plugin.getServer().getWorlds().get(0).getSpawnLocation();
    }

    public void teleport(User user) {

        user.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 30, 1, false, false));
        user.setVelocity(user.getLocation().getDirection().multiply(1).setY(1));

        new BukkitRunnable() {
            @Override
            public void run() {
                user.teleport(getLocation());
                user.removePotionEffect(PotionEffectType.BLINDNESS);
            }
        }.runTaskLaterAsynchronously(LobbyPlugin.getInstance(), 15);
    }

}
