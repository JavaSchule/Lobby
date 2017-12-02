package net.byteexception.netcode.lobby.listener.inventory;

import net.byteexception.netcode.lobby.LobbyPlugin;
import net.byteexception.netcode.lobby.inventory.Clickable;
import net.byteexception.netcode.lobby.user.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 *
 * @author Mike
 */
public class InventoryClickListener implements Listener {

    @EventHandler
    public void onCall(InventoryClickEvent event) {
        User user = User.getUser((Player)event.getWhoClicked());
        if(event.getClickedInventory()!=null&&event.getInventory().getTitle()!=null) {
            if(event.getCurrentItem()!=null&&event.getCurrentItem().hasItemMeta()&&event.getCurrentItem().getItemMeta().hasDisplayName()) {
                Clickable clickable = LobbyPlugin.getInstance().getClickable(user,event.getClickedInventory());
                if(clickable!=null){
                    clickable.click(user,event);

                }
            }
        }
        if(!user.isBuilding()) {
            event.setCancelled(true);
        }
    }

}
