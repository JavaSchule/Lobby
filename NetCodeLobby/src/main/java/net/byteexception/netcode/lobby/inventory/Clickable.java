package net.byteexception.netcode.lobby.inventory;

import net.byteexception.netcode.lobby.user.User;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
/**
 * The Clickable interface is used to create inventories that execute a method
 * once theyre interacted on
 *
 * @author Mike
 */
public interface Clickable {

    Inventory getInventory(User user);

    boolean matches(User user,Inventory inventory);

    void click(User user,InventoryClickEvent event);

}
