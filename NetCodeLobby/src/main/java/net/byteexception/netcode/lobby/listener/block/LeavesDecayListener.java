package net.byteexception.netcode.lobby.listener.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;


/**
 *
 * @author Mike
 */
public class LeavesDecayListener implements Listener {

    @EventHandler
    public void onCall(LeavesDecayEvent event) {
        event.setCancelled(true);
    }

}
