package net.byteexception.netcode.lobby.listener.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

/**
 *
 * @author Mike
 */
public class CreatureSpawnListener implements Listener {

    @EventHandler
    public void onCall(CreatureSpawnEvent event) {
        if(event.getSpawnReason()!= CreatureSpawnEvent.SpawnReason.CUSTOM||event.getSpawnReason()== CreatureSpawnEvent.SpawnReason.SPAWNER_EGG) {
            event.setCancelled(true);
        }
    }

}
