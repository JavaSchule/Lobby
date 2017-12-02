package net.byteexception.netcode.lobby.listener.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.EntityBlockFormEvent;

public class EntityBlockFormListener implements Listener {

    @EventHandler
    public void onCall(EntityBlockFormEvent event) {
        event.setCancelled(true);
    }

}
