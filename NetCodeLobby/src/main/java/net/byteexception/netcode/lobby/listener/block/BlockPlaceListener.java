package net.byteexception.netcode.lobby.listener.block;

import net.byteexception.netcode.lobby.user.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void onCall(BlockPlaceEvent event) {
        event.setCancelled(!User.getUser(event.getPlayer()).isBuilding());
    }

}
