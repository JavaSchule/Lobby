package net.byteexception.netcode.lobby.inventory;

import net.byteexception.netcode.lobby.user.User;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Mike
 */

public abstract  class LastingItem implements Usable {

    private ItemStack itemStack;

    public LastingItem(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    @Override
    public ItemStack getItemStack(User user) {
        return itemStack;
    }

    @Override
    public boolean matches(User user, ItemStack itemStack) {
        return itemStack.getItemMeta().getDisplayName().equals(this.itemStack.getItemMeta().getDisplayName());
    }
}
