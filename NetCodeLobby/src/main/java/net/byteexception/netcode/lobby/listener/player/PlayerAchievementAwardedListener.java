package net.byteexception.netcode.lobby.listener.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;


/**
 *
 * @author Mike
 */
public class PlayerAchievementAwardedListener implements Listener {

    @EventHandler
    public void onCall(PlayerAchievementAwardedEvent event) {
        event.setCancelled(true);
    }

}
