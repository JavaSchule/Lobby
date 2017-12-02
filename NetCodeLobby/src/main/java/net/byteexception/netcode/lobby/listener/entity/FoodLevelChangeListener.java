package net.byteexception.netcode.lobby.listener.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;


/**
 *
 *@author Mike
 */
public class FoodLevelChangeListener implements Listener {

    @EventHandler
    public void onCall(FoodLevelChangeEvent event){
        event.setCancelled(true);
    }

}
