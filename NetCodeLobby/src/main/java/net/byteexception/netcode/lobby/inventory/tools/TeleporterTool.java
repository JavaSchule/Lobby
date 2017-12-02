package net.byteexception.netcode.lobby.inventory.tools;

import net.byteexception.cloud.ItemBuilder.ItemBuilder;
import net.byteexception.netcode.lobby.LobbyPlugin;
import net.byteexception.netcode.lobby.inventory.LastingItem;
import net.byteexception.netcode.lobby.inventory.inventories.WarpInventory;
import net.byteexception.netcode.lobby.user.User;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 *
 * @author Mike
 */
public class TeleporterTool extends LastingItem {

    public TeleporterTool()
    {
        super( new ItemBuilder().setMaterial(Material.COMPASS).setName("§8» §eTeleporter").build());
    }

    @Override
    public void use(User user, PlayerInteractEvent event) {
        WarpInventory warpInventory = LobbyPlugin.getInstance().getClickable(WarpInventory.class);
        user.openInventory(warpInventory.getInventory(user));
        user.play(Sound.WOOD_CLICK);
    }
}
