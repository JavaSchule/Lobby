package net.byteexception.netcode.lobby.listener.player;

import net.byteexception.netcode.lobby.user.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 *
 * @author Mike
 */
public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onCall(PlayerQuitEvent event) {
        event.setQuitMessage("");
        User.getUsers().remove(event.getPlayer().getUniqueId());
    }

}
