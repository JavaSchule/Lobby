package net.byteexception.netcode.lobby.config;

import com.google.common.base.Preconditions;
import net.byteexception.netcode.lobby.LobbyPlugin;
import net.byteexception.netcode.lobby.inventory.RestrictedItem;
import net.byteexception.netcode.lobby.inventory.Usable;
import net.byteexception.netcode.lobby.user.User;
import org.bukkit.inventory.ItemStack;

/**
 * The Hotbar Layout is a Layout Manager
 *
 *@author Mike
 *
 */

public class HotbarLayout {


    private Usable[] hotbar;

    public HotbarLayout() {
        this.hotbar = new Usable[9];
    }

    public void give(User user) {
        for(int i = 0; i < hotbar.length; i++) {
            Usable usable = hotbar[i];

            if (usable != null) {
                if (usable instanceof RestrictedItem) {
                    if (!((RestrictedItem) usable).hasPermission(user)) {
                        continue;
                    }
                }

                user.getInventory().setItem(i, hotbar[i].getItemStack(user));
            }
        }
    }

    public void register(int i,Usable usable) {
        Preconditions.checkElementIndex(i,hotbar.length,"The given slot is too high");
        LobbyPlugin.getInstance().getUsables().add(usable);
        hotbar[i] = usable;
    }


}
