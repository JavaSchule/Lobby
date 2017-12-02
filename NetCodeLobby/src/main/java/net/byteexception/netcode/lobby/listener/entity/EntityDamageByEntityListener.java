package net.byteexception.netcode.lobby.listener.entity;

import net.byteexception.netcode.lobby.user.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntityListener implements Listener {

    @EventHandler(priority =  EventPriority.HIGHEST)
    public void onCall(EntityDamageByEntityEvent event) {
        if(event.getDamager() instanceof Player) {
            User damager = User.getUser((Player)event.getDamager());
            if(damager.isBuilding()) {
                event.setDamage(event.getEntity() instanceof Player ? 0 : event.getDamage());
                event.setCancelled(false);
            }
        } else {
            event.setCancelled(true);
        }
    }

}
