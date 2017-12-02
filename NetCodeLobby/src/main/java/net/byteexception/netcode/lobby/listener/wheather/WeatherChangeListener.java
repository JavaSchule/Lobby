package net.byteexception.netcode.lobby.listener.wheather;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

/**
 *
 * @author Mike
 */
public class WeatherChangeListener implements Listener {

    @EventHandler
    public void onCall(WeatherChangeEvent event) {
        if(event.toWeatherState()) {
            event.setCancelled(true);
        }
    }

}
