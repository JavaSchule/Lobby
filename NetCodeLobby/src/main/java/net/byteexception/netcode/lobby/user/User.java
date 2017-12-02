package net.byteexception.netcode.lobby.user;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Mike
 */
public class User extends ForwardingPlayer {

    private static final String JSON_FORMAT  = " {text: \"%s\"}";
    private static Map<UUID,User> users = new HashMap<>();

    private CraftPlayer player;

    private long lastSneak;
    private int sneakTimer;

    private boolean building;
    private boolean silentMode;
    private LobbySettings lobbySettings;

    public User (Player player) {
        this.player = (CraftPlayer) player;

        //TODO: Load lobby settings from database
        this.lobbySettings = new LobbySettings();
    }

    @Override
    protected Player delegate() {
        return player;
    }


    public void play(Sound sound) {
        this.playSound(getEyeLocation(),sound,1,1);
    }

    public void flush(GameMode gameMode) {
        setGameMode(gameMode);
        setHealth(getMaxHealth());
        setFoodLevel(20);
        getActivePotionEffects().forEach((activeEffect)-> {
            removePotionEffect(activeEffect.getType());
        });
        getInventory().clear();
        getInventory().setArmorContents(null);
        setLevel(0);
        setExp(0);
    }

    public void displayActionBar(String string) {
        PacketPlayOutChat packet = new PacketPlayOutChat(
                IChatBaseComponent.ChatSerializer.a(String.format(JSON_FORMAT,string)),(byte)2);
        player.getHandle().playerConnection.sendPacket(packet);
    }

    public void displayTitle(String title,String subTitle,int fadeIn,int fadeOut,int stay) {
        PlayerConnection playerConnection = player.getHandle().playerConnection;

        PacketPlayOutTitle packetPlayOutTitleTime = new PacketPlayOutTitle(fadeIn,stay,fadeOut);

        playerConnection.sendPacket(packetPlayOutTitleTime);

        if(title!=null) {
            PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE,
                    IChatBaseComponent.ChatSerializer.a(String.format(JSON_FORMAT, title)));
            playerConnection.sendPacket(packetPlayOutTitle);
        }

        if(subTitle!=null) {
            PacketPlayOutTitle packetPlayOutSubTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE,
                    IChatBaseComponent.ChatSerializer.a(String.format(JSON_FORMAT, subTitle)));
            playerConnection.sendPacket(packetPlayOutSubTitle);
        }
    }

    public void handleVisibility() {
        getServer().getOnlinePlayers().forEach((online)-> {
            if(equals(online))  {
                return;
            }

            User user = getUser(online);
            handleVisibility(user);

        });
    }

    public void handleVisibility(User user) {
        if(silentMode||user.isSilentMode()||!lobbySettings.getVisibilityLevel().canBeSeen(user)) {
            hidePlayer(user.delegate());
        }   else {
            showPlayer(user.delegate());
        }

        if(user.silentMode||!user.lobbySettings.getVisibilityLevel().canBeSeen(this)) {
            user.hidePlayer(delegate());
        }   else {
            user.showPlayer(delegate());
        }
    }

    public boolean isSilentMode() {
        return silentMode;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        if(obj instanceof Player) {
            Player player = ((Player)obj);
            return player.getUniqueId().equals(getUniqueId());
        }

        return false;
    }

    public void setBuilding(boolean building) {
        this.building = building;
    }

    public boolean isBuilding() {
        return building;
    }

    public LobbySettings getLobbySettings() {
        return lobbySettings;
    }

    public void setSilentMode(boolean silentMode) {
        this.silentMode = silentMode;
    }

    public void setLastSneak(long lastSneak) {
        this.lastSneak = lastSneak;
    }

    public long getLastSneak() {
        return lastSneak;
    }

    public int getSneakTimer() {
        return sneakTimer;
    }

    public void addSneak(){
        sneakTimer++;
    }

    public static Map<UUID, User> getUsers() {
        return users;
    }


    public static User getUser(Player player) {
        if(users.containsKey(player.getUniqueId())) {
            return users.get(player.getUniqueId());
        }

        User user = new User(player);
        users.put(player.getUniqueId(),user);
        return user;
    }
}
