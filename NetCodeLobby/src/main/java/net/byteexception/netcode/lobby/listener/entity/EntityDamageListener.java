package net.byteexception.netcode.lobby.listener.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;


/**
 *
 * @author Mike
 */
public class EntityDamageListener implements Listener {

    @EventHandler
    public void onCall(EntityDamageEvent event) {
        event.setCancelled(true);
    }

}
