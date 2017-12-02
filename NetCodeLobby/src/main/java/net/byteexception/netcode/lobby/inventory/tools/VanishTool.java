package net.byteexception.netcode.lobby.inventory.tools;

import net.byteexception.netcode.lobby.inventory.Usable;
import net.byteexception.netcode.lobby.user.User;
import net.byteexception.netcode.lobby.user.VisibilityLevel;
import org.apache.commons.lang3.Validate;
import org.bukkit.Sound;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Mike
 */
public class VanishTool implements Usable {


    @Override
    public boolean matches(User user,ItemStack itemStack) {
        Validate.notNull(itemStack);
        return getItemStack(user).getItemMeta().getDisplayName().equals(itemStack.getItemMeta().getDisplayName());
    }

    @Override
    public void use(User user,PlayerInteractEvent event) {
       int ordinal = user.getLobbySettings().getVisibilityLevel().ordinal()+  1;
       if(ordinal >= VisibilityLevel.values().length) {
           ordinal = 0;
       }

       VisibilityLevel visibilityLevel = VisibilityLevel.values()[ordinal];
       user.getLobbySettings().setVisibilityLevel(visibilityLevel);
       user.handleVisibility();
       user.setItemInHand(getItemStack(user));

       user.play(Sound.ITEM_PICKUP);
       user.displayActionBar("§e(ℹ) §7Du siehst nun: ".concat(visibilityLevel.getDisplayName()));
    }

    @Override
    public ItemStack getItemStack(User user) {
       return user.getLobbySettings().getVisibilityLevel().getItemStack();
    }


}

