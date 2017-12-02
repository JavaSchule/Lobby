package net.byteexception.netcode.lobby.inventory;

import net.byteexception.netcode.lobby.user.User;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * The Usable interface is used to create items that execute a method once
 * theyre interacted on
 *
 * @author Mike
 */

public interface Usable {

    ItemStack getItemStack(User user);

    boolean matches (User user,ItemStack itemStack);

    void use(User user,PlayerInteractEvent event);
}
