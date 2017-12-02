package net.byteexception.netcode.lobby.inventory.inventories;

import net.byteexception.netcode.lobby.config.Warp;
import net.byteexception.netcode.lobby.inventory.Clickable;
import net.byteexception.netcode.lobby.user.User;
import org.bukkit.Server;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

/**
 * @author Mike
 */
public class WarpInventory implements Clickable {


    private static final String TITLE = "§7Warps";

    private Inventory inventory;

    public WarpInventory(Server server) {
        inventory = server.createInventory(null,9*3,TITLE);
        inventory.setItem(toSlot(4,0), Warp.SPAWN.getItemStack());
        inventory.setItem(toSlot(3,2),Warp.BUILD.getItemStack());
        inventory.setItem(toSlot(4,2),Warp.RPG.getItemStack());
        inventory.setItem(toSlot(5,2),Warp.SURVIVAL.getItemStack());
    }

    @Override
    public Inventory getInventory(User user) {
        return inventory;
    }

    @Override
    public boolean matches(User user, Inventory inventory) {
        return inventory.getTitle().equals(TITLE);
    }

    @Override
    public void click(User user, InventoryClickEvent event) {
        for(Warp warp : Warp.values()) {
            if(warp.getItemStack().getItemMeta().getDisplayName().equals(event.getCurrentItem().getItemMeta().getDisplayName())) {
                warp.teleport(user);
                event.getView().close();
            }
        }
    }

    private int toSlot(int x,int y) {
        return y *9+x;
    }
}
