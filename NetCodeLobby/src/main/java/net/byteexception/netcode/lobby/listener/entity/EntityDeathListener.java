package net.byteexception.netcode.lobby.listener.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

/**
 *
 * @author Mike
 */
public class EntityDeathListener implements Listener {

    @EventHandler
    public void onCall(EntityDeathEvent event) {
        event.setDroppedExp(0);
        event.getDrops().clear();
    }

}
