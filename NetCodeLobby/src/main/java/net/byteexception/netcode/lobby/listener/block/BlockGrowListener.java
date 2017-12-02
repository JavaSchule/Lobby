package net.byteexception.netcode.lobby.listener.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;

/**
 *
 * @author Mike
 */
public class BlockGrowListener  implements Listener {

    @EventHandler
    public void onCall(BlockGrowEvent event) {
        event.setCancelled(true);
    }

}
