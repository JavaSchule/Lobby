package net.byteexception.netcode.lobby.listener.player;

import net.byteexception.netcode.lobby.user.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PlayerPickupItemListener implements Listener {

        @EventHandler
        public void onCall(PlayerPickupItemEvent event) {
            event.setCancelled(!User.getUser(event.getPlayer()).isBuilding());
        }

}



