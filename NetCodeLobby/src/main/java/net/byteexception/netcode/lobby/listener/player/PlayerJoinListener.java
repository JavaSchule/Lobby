package net.byteexception.netcode.lobby.listener.player;

import net.byteexception.netcode.lobby.LobbyPlugin;
import net.byteexception.netcode.lobby.config.Warp;
import net.byteexception.netcode.lobby.user.User;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 *
 * @author Mike
 */
public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onCall(PlayerJoinEvent event) {
        event.setJoinMessage("");

        User user = User.getUser(event.getPlayer());

        user.flush(GameMode.ADVENTURE);
        user.displayTitle("§3Willkommen auf Netcode",String.format("§b+ LOBBY UPDATE"),15,15,20);
        LobbyPlugin.getInstance().getLobbyConfig().getLayout().give(user);

        user.teleport(Warp.SPAWN.getLocation());
        user.handleVisibility();
    }

}
