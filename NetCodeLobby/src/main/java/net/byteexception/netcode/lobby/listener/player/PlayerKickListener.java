package net.byteexception.netcode.lobby.listener.player;

import net.byteexception.netcode.lobby.user.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

/**
 *
 * @author Mike
 */
public class PlayerKickListener implements Listener {

    @EventHandler
    public void onCall(PlayerKickEvent event) {
        event.setLeaveMessage("");
        User.getUsers().remove(event.getPlayer().getUniqueId());
    }

}
