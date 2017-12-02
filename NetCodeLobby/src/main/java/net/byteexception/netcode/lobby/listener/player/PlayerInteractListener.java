package net.byteexception.netcode.lobby.listener.player;

import net.byteexception.netcode.lobby.LobbyPlugin;
import net.byteexception.netcode.lobby.inventory.Usable;
import net.byteexception.netcode.lobby.user.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 *
 * @author Mike
 */
public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onCall(PlayerInteractEvent event) {

        User user = User.getUser(event.getPlayer());
        if(event.getAction()== Action.RIGHT_CLICK_AIR||event.getAction()== Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null && event.getItem().hasItemMeta() && event.getItem().getItemMeta().hasDisplayName()) {
                Usable usable = LobbyPlugin.getInstance().getUsable(user, event.getItem());
                if (usable != null) {
                    usable.use(user, event);
                }
            }
        }
        if(!user.isBuilding()) {
            event.setCancelled(true);
        }
    }

}
