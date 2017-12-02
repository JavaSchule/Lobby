package net.byteexception.netcode.lobby.user;

import net.byteexception.cloud.ItemBuilder.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.Serializable;

/**
 *
 * @author Mike
 */
public enum VisibilityLevel implements Serializable {

    ALL("§8» §aAlle Spieler",10),

    VIP("§8» §5Nur VIP's",5) {
        @Override
        public boolean canBeSeen(Player player) {
            return player.isOp();
        }
    },

    NONE("§8» §4Niemand",1) {
        @Override
        public boolean canBeSeen(Player player) {
            return false;
        }
    };

   private String displayName;
   private short inkId;
   private ItemStack itemStack;

   VisibilityLevel(String displayName,int inkId) {
       this.displayName = displayName;
       this.inkId = (short)inkId;
       this.itemStack = new ItemBuilder().setMaterial(Material.INK_SACK).setName(displayName).setData(inkId).build();
   }

   public boolean canBeSeen(Player player) {
       return true;
   }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public String getDisplayName() {
        return displayName;
    }

    public short getInkId() {
        return inkId;
    }
}
