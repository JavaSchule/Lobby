package net.byteexception.netcode.lobby.inventory.tools;

import net.byteexception.cloud.ItemBuilder.ItemBuilder;
import net.byteexception.netcode.lobby.inventory.Clickable;
import net.byteexception.netcode.lobby.inventory.RestrictedItem;
import net.byteexception.netcode.lobby.inventory.Usable;
import net.byteexception.netcode.lobby.user.User;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * @author Mike
 */

public class SilentModeTool implements Usable,RestrictedItem {

    private static final ItemStack ACTIVE = new ItemBuilder().setMaterial(Material.TNT).setName("§8» §aSilent Mode").build(),
            DISABLED = new ItemBuilder().setMaterial(Material.TNT).setName("§8» §7Silent Mode").build();


    @Override
    public ItemStack getItemStack(User user) {
        return user.isSilentMode() ? ACTIVE : DISABLED;
    }

    @Override
    public boolean matches(User user, ItemStack itemStack) {
        return getItemStack(user).getItemMeta().getDisplayName().equals(itemStack.getItemMeta().getDisplayName());
    }

    @Override
    public void use(User user, PlayerInteractEvent event) {
        boolean silentMode;
        user.setSilentMode(silentMode = !user.isSilentMode());

        if(silentMode) {
            user.sendMessage("§e(ℹ) §aDu bist nun im SilentMode");
            user.play(Sound.NOTE_PLING);
        } else{
            user.sendMessage("§e(ℹ) §cDu bist nun nichtmehr im SilentMode");
            user.play(Sound.ITEM_BREAK);
        }

        user.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,10,1,true,true));
        user.handleVisibility();
        user.setItemInHand(getItemStack(user));

    }

    @Override
    public boolean hasPermission(User user) {
        return user.isOp();
    }
}
