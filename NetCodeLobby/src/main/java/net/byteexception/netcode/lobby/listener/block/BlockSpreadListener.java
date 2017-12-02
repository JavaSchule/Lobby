package net.byteexception.netcode.lobby.listener.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockSpreadEvent;

/**
 *
 * @author Mike
 */
public class BlockSpreadListener implements Listener {

    @EventHandler
    public void onCall(BlockSpreadEvent event) {
        event.setCancelled(true);
    }

}
