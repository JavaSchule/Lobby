package net.byteexception.netcode.lobby.listener.wheather;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.ThunderChangeEvent;


/**
 *
 * @author Mike
 */
public class ThunderChangeListener implements Listener {

    @EventHandler
    public void onCall(ThunderChangeEvent event) {
        if(event.toThunderState()) {
            event.setCancelled(true);
        }
    }

}
