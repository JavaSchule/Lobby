package net.byteexception.netcode.lobby;

import net.byteexception.netcode.lobby.commands.BuildCommand;
import net.byteexception.netcode.lobby.commands.SpawnSetCommand;
import net.byteexception.netcode.lobby.config.LobbyConfig;
import net.byteexception.netcode.lobby.inventory.Clickable;
import net.byteexception.netcode.lobby.inventory.Usable;
import net.byteexception.netcode.lobby.inventory.inventories.WarpInventory;
import net.byteexception.netcode.lobby.inventory.tools.SilentModeTool;
import net.byteexception.netcode.lobby.inventory.tools.TeleporterTool;
import net.byteexception.netcode.lobby.inventory.tools.VanishTool;
import net.byteexception.netcode.lobby.listener.block.*;
import net.byteexception.netcode.lobby.listener.entity.*;
import net.byteexception.netcode.lobby.listener.inventory.InventoryClickListener;
import net.byteexception.netcode.lobby.listener.player.*;
import net.byteexception.netcode.lobby.listener.wheather.ThunderChangeListener;
import net.byteexception.netcode.lobby.listener.wheather.WeatherChangeListener;
import net.byteexception.netcode.lobby.storage.Credential;
import net.byteexception.netcode.lobby.storage.mongo.MongoConnector;
import net.byteexception.netcode.lobby.storage.mongo.MongoHandler;
import net.byteexception.netcode.lobby.storage.mongo.MongoSerializer;
import net.byteexception.netcode.lobby.user.User;
import net.minecraft.server.v1_8_R3.PacketPlayOutUpdateTime;
import org.bukkit.command.CommandMap;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *@author Mike
 */
public class LobbyPlugin extends JavaPlugin {

    private static final SimpleDateFormat HOUR_FORMAT = new SimpleDateFormat("HH:mm");

    private static LobbyPlugin instance;

    private List<Usable> usables;
    private List<Clickable> clickables;
    private LobbyConfig lobbyConfig;

    private ScheduledExecutorService executorService;
    private MongoHandler mongoHandler;
    private MongoSerializer mongoSerializer;


    public LobbyPlugin() {
        instance = this;

        this.usables = new ArrayList<>();
        this.clickables = new ArrayList<>();
        this.mongoSerializer = new MongoSerializer();
        this.executorService = Executors.newScheduledThreadPool(0);
    }

    @Override
    public void onEnable() {

        init();
        runGameLoop();

    }

    @Override
    public void onDisable() {

      //  mongoHandler.close();
        executorService.shutdownNow();

    }

    private void init() {

      //  mongoHandler = new MongoHandler(new MongoConnector(),new Credential("localhost",27017,"minecraft","root","password"));


        registerListener();
        registerCommands();

        this.lobbyConfig = new LobbyConfig() {
            @Override
            public void initialize() {
                layout.register(0,new TeleporterTool());
                layout.register(1,new VanishTool());
                layout.register(8,new SilentModeTool());
            }
        };

        this.clickables.add(new WarpInventory(getServer()));
    }

    private void runGameLoop() {

       executorService.scheduleAtFixedRate(() -> {

               final long currentTime = getRealTime();

               PacketPlayOutUpdateTime packetPlayOutUpdateTime = new PacketPlayOutUpdateTime(currentTime,0,true);

               getServer().getOnlinePlayers().forEach(all ->{
                   ((CraftPlayer)all).getHandle().playerConnection.sendPacket(packetPlayOutUpdateTime);
               });

       },0,5, TimeUnit.SECONDS);

    }

    private void registerCommands() {
        CommandMap commandMap = ((CraftServer)getServer()).getCommandMap();
        commandMap.register("fallback",new BuildCommand());
        commandMap.register("fallback",new SpawnSetCommand());
    }

    private void registerListener() {
        PluginManager pluginManager = getServer().getPluginManager();

        pluginManager.registerEvents(new BlockBreakListener(),this);
        pluginManager.registerEvents(new BlockGrowListener(),this);
        pluginManager.registerEvents(new BlockPlaceListener(),this);
        pluginManager.registerEvents(new BlockSpreadListener(),this);
        pluginManager.registerEvents(new EntityBlockFormListener(),this);
        pluginManager.registerEvents(new LeavesDecayListener(),this);

        pluginManager.registerEvents(new CreatureSpawnListener(),this);
        pluginManager.registerEvents(new EntityDamageByEntityListener(),this);
        pluginManager.registerEvents(new EntityDamageListener(),this);
        pluginManager.registerEvents(new EntityDeathListener(),this);
        pluginManager.registerEvents(new FoodLevelChangeListener(),this);

        pluginManager.registerEvents(new InventoryClickListener(),this);
        pluginManager.registerEvents(new PlayerAchievementAwardedListener(),this);
        pluginManager.registerEvents(new PlayerInteractListener(),this);
        pluginManager.registerEvents(new PlayerJoinListener(),this);
        pluginManager.registerEvents(new PlayerPickupItemListener(),this);
        pluginManager.registerEvents(new PlayerQuitListener(),this);
        pluginManager.registerEvents(new PlayerKickListener(),this);
        pluginManager.registerEvents(new PlayerToggleSneakListener(),this);


        pluginManager.registerEvents(new ThunderChangeListener(),this);
        pluginManager.registerEvents(new WeatherChangeListener(),this);
    }

    public long getRealTime(){
        String[] args = HOUR_FORMAT.format(new Date()).split(":");
        Integer hours = Integer.parseInt(args[0]) * 1000;
        Integer minutes = Integer.parseInt(args[1]) * (100/60);
        return hours + minutes + 18000;
    }

    public MongoSerializer getMongoSerializer() {
        return mongoSerializer;
    }

    public Usable getUsable(User user, ItemStack item){

        for(int i = 0; i < usables.size();i++) {
            Usable usable = usables.get(i);
            if(usable.matches(user,item)) {
                return usable;
            }
        }

        return null;
    }

    public Clickable getClickable(User user,Inventory inventory) {

        for(int i = 0; i < clickables.size();i++) {
            Clickable clickable = clickables.get(i);
            if(clickable.matches(user,inventory)) {
                return clickable;
            }
        }

        return null;
    }

    public MongoHandler getMongoHandler() {
        return mongoHandler;
    }

    public LobbyConfig getLobbyConfig() {
        return lobbyConfig;
    }

    public List<Usable> getUsables() {
        return usables;
    }

    public ScheduledExecutorService getExecutorService() {
        return executorService;
    }

    public List<Clickable> getClickables() {
        return clickables;
    }

    public <E extends Clickable> E getClickable(Class<E> clazz) {
        for(Clickable clickable : clickables) {
            if(clickable.getClass().getName().equals(clazz.getName()))
            {
                return (E)clickable;
            }
        }
        return null;
    }

    public static LobbyPlugin getInstance() {
        return instance;
    }

}
