package net.byteexception.netcode.lobby.user;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.bukkit.Achievement;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.WeatherType;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.Vector;

/**
 *
 * @author Mike
 */
public abstract class ForwardingPlayer  implements Player {


    protected abstract Player delegate();

    @Override
    public String getDisplayName() {
        return delegate().getDisplayName();
    }

    @Override
    public void setDisplayName(String name) {
        delegate().setDisplayName(name);
    }

    @Override
    public String getPlayerListName() {
        return delegate().getPlayerListName();
    }

    @Override
    public void setPlayerListName(String name) {
        delegate().setPlayerListName(name);
    }

    @Override
    public void setCompassTarget(Location loc) {
        delegate().setCompassTarget(loc);
    }

    @Override
    public Location getCompassTarget() {
        return delegate().getCompassTarget();
    }

    @Override

    public InetSocketAddress getAddress() {
        return delegate().getAddress();
    }

    @Override
    public void sendRawMessage(String message) {
        delegate().sendRawMessage(message);
    }

    @Override
    public void kickPlayer(String message) {
        delegate().kickPlayer(message);
    }

    @Override
    public void chat(String msg) {
        delegate().chat(msg);
    }

    @Override
    public boolean performCommand(String command) {
        return delegate().performCommand(command);
    }

    @Override
    public boolean isSneaking() {
        return delegate().isSneaking();
    }

    @Override
    public void setSneaking(boolean sneak) {
        delegate().setSneaking(sneak);
    }

    @Override
    public boolean isSprinting() {
        return delegate().isSprinting();
    }

    @Override
    public void setSprinting(boolean sprinting) {
        delegate().setSprinting(sprinting);
    }

    @Override
    public void saveData() {
        delegate().saveData();
    }

    @Override
    public void loadData() {
        delegate().loadData();
    }

    @Override
    public void setSleepingIgnored(boolean isSleeping) {
        delegate().setSleepingIgnored(isSleeping);
    }

    @Override
    public boolean isSleepingIgnored() {
        return delegate().isSleepingIgnored();
    }

    @Override
    public void playNote(Location loc, byte instrument, byte note) {
        delegate().playNote(loc, instrument, note);
    }

    @Override

    public void playNote(Location loc, Instrument instrument, Note note) {
        delegate().playNote(loc, instrument, note);
    }

    @Override
    public void playSound(Location location, Sound sound, float volume, float pitch) {
        delegate().playSound(location, sound, volume, pitch);
    }

    @Override

    public void playSound(Location location, String sound, float volume, float pitch) {
        delegate().playSound(location, sound, volume, pitch);
    }

    @Override
    public void playEffect(Location loc, Effect effect, int data) {
        delegate().playEffect(loc, effect, data);
    }

    @Override
    public <T> void playEffect(Location loc, Effect effect, T data) {
        delegate().playEffect(loc, effect, data);
    }

    @Override

    public void sendBlockChange(Location loc, Material material, byte data) {
        delegate().sendBlockChange(loc, material, data);
    }

    @Override
    public boolean sendChunkChange(Location loc, int sx, int sy, int sz, byte[] data) {
        return delegate().sendChunkChange(loc, sx, sy, sz, data);
    }

    @Override
    public void sendBlockChange(Location loc, int material, byte data) {
        delegate().sendBlockChange(loc, material, data);
    }

    @Override
    public void sendSignChange(Location loc, String[] lines) throws IllegalArgumentException {
        delegate().sendSignChange(loc, lines);
    }

    @Override
    public void sendMap(MapView map) {
        delegate().sendMap(map);
    }

    @Override
    public void updateInventory() {
        delegate().updateInventory();
    }

    @Override
    public void awardAchievement(Achievement achievement) {
        delegate().awardAchievement(achievement);
    }

    @Override
    public void removeAchievement(Achievement achievement) {
        delegate().removeAchievement(achievement);
    }

    @Override
    public boolean hasAchievement(Achievement achievement) {
        return delegate().hasAchievement(achievement);
    }

    @Override
    public void incrementStatistic(Statistic statistic) throws IllegalArgumentException {
        delegate().incrementStatistic(statistic);
    }

    @Override
    public void decrementStatistic(Statistic statistic) throws IllegalArgumentException {
        delegate().decrementStatistic(statistic);
    }

    @Override
    public void incrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {
        delegate().incrementStatistic(statistic, amount);
    }

    @Override
    public void decrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {
        delegate().decrementStatistic(statistic, amount);
    }

    @Override
    public void setStatistic(Statistic statistic, int newValue) throws IllegalArgumentException {
        delegate().setStatistic(statistic, newValue);
    }

    @Override
    public int getStatistic(Statistic statistic) throws IllegalArgumentException {
        return delegate().getStatistic(statistic);
    }

    @Override
    public void incrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        delegate().incrementStatistic(statistic, material);
    }

    @Override
    public void decrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        delegate().decrementStatistic(statistic, material);
    }

    @Override
    public int getStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        return delegate().getStatistic(statistic, material);
    }

    @Override
    public void incrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException {
        delegate().incrementStatistic(statistic, material, amount);
    }

    @Override
    public void decrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException {
        delegate().decrementStatistic(statistic, material, amount);
    }

    @Override
    public void setStatistic(Statistic statistic, Material material, int newValue) throws IllegalArgumentException {
        delegate().setStatistic(statistic, material, newValue);
    }

    @Override
    public void incrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        delegate().incrementStatistic(statistic, entityType);
    }

    @Override
    public void decrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        delegate().decrementStatistic(statistic, entityType);
    }

    @Override
    public int getStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        return delegate().getStatistic(statistic, entityType);
    }

    @Override
    public void incrementStatistic(Statistic statistic, EntityType entityType, int amount) throws IllegalArgumentException {
        delegate().incrementStatistic(statistic, entityType, amount);
    }

    @Override
    public void decrementStatistic(Statistic statistic, EntityType entityType, int amount) {
        delegate().decrementStatistic(statistic, entityType, amount);
    }

    @Override
    public void setStatistic(Statistic statistic, EntityType entityType, int newValue) {
        delegate().setStatistic(statistic, entityType, newValue);
    }

    @Override
    public void setPlayerTime(long time, boolean relative) {
        delegate().setPlayerTime(time, relative);
    }

    @Override
    public long getPlayerTime() {
        return delegate().getPlayerTime();
    }

    @Override
    public long getPlayerTimeOffset() {
        return delegate().getPlayerTimeOffset();
    }

    @Override
    public boolean isPlayerTimeRelative() {
        return delegate().isPlayerTimeRelative();
    }

    @Override
    public void resetPlayerTime() {
        delegate().resetPlayerTime();
    }

    @Override
    public void setPlayerWeather(WeatherType type) {
        delegate().setPlayerWeather(type);
    }

    @Override
    public WeatherType getPlayerWeather() {
        return delegate().getPlayerWeather();
    }

    @Override
    public void resetPlayerWeather() {
        delegate().resetPlayerWeather();
    }

    @Override
    public void giveExp(int amount) {
        delegate().giveExp(amount);
    }

    @Override
    public void giveExpLevels(int amount) {
        delegate().giveExpLevels(amount);
    }

    @Override
    public float getExp() {
        return delegate().getExp();
    }

    @Override
    public void setExp(float exp) {
        delegate().setExp(exp);
    }

    @Override
    public int getLevel() {
        return delegate().getLevel();
    }

    @Override
    public void setLevel(int level) {
        delegate().setLevel(level);
    }

    @Override
    public int getTotalExperience() {
        return delegate().getTotalExperience();
    }

    @Override
    public void setTotalExperience(int exp) {
        delegate().setTotalExperience(exp);
    }

    @Override
    public float getExhaustion() {
        return delegate().getExhaustion();
    }

    @Override
    public void setExhaustion(float value) {
        delegate().setExhaustion(value);
    }

    @Override
    public float getSaturation() {
        return delegate().getSaturation();
    }

    @Override
    public void setSaturation(float value) {
        delegate().setSaturation(value);
    }

    @Override
    public int getFoodLevel() {
        return delegate().getFoodLevel();
    }

    @Override
    public void setFoodLevel(int value) {
        delegate().setFoodLevel(value);
    }

    @Override
    public Location getBedSpawnLocation() {
        return delegate().getBedSpawnLocation();
    }

    @Override
    public void setBedSpawnLocation(Location location) {
        delegate().setBedSpawnLocation(location);
    }

    @Override
    public void setBedSpawnLocation(Location location, boolean force) {
        delegate().setBedSpawnLocation(location, force);
    }

    @Override
    public boolean getAllowFlight() {
        return delegate().getAllowFlight();
    }

    @Override
    public void setAllowFlight(boolean flight) {
        delegate().setAllowFlight(flight);
    }

    @Override
    public void hidePlayer(Player player) {
        delegate().hidePlayer(player);
    }

    @Override
    public void showPlayer(Player player) {
        delegate().showPlayer(player);
    }

    @Override
    public boolean canSee(Player player) {
        return delegate().canSee(player);
    }

    @Override
    public boolean isOnGround() {
        return delegate().isOnGround();
    }

    @Override
    public boolean isFlying() {
        return delegate().isFlying();
    }

    @Override
    public void setFlying(boolean value) {
        delegate().setFlying(value);
    }

    @Override
    public void setFlySpeed(float value) throws IllegalArgumentException {
        delegate().setFlySpeed(value);
    }

    @Override
    public void setWalkSpeed(float value) throws IllegalArgumentException {
        delegate().setWalkSpeed(value);
    }

    @Override
    public float getFlySpeed() {
        return delegate().getFlySpeed();
    }

    @Override
    public float getWalkSpeed() {
        return delegate().getWalkSpeed();
    }

    @Override
    public void setTexturePack(String url) {
        delegate().setTexturePack(url);
    }

    @Override
    public void setResourcePack(String url) {
        delegate().setResourcePack(url);
    }

    @Override
    public Scoreboard getScoreboard() {
        return delegate().getScoreboard();
    }

    @Override
    public void setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {
        delegate().setScoreboard(scoreboard);
    }

    @Override
    public boolean isHealthScaled() {
        return delegate().isHealthScaled();
    }

    @Override
    public void setHealthScaled(boolean scale) {
        delegate().setHealthScaled(scale);
    }

    @Override
    public void setHealthScale(double scale) throws IllegalArgumentException {
        delegate().setHealthScale(scale);
    }

    @Override
    public double getHealthScale() {
        return delegate().getHealthScale();
    }

    @Override
    public Entity getSpectatorTarget() {
        return delegate().getSpectatorTarget();
    }

    @Override
    public void setSpectatorTarget(Entity entity) {
        delegate().setSpectatorTarget(entity);
    }

    @Override
    public void sendTitle(String title, String subtitle) {
        delegate().sendTitle(title, subtitle);
    }

    @Override
    public void resetTitle() {
        delegate().resetTitle();
    }

    @Override
    public Spigot spigot() {
        return delegate().spigot();
    }

    @Override
    public String getName() {
        return delegate().getName();
    }

    @Override
    public PlayerInventory getInventory() {
        return delegate().getInventory();
    }

    @Override
    public Inventory getEnderChest() {
        return delegate().getEnderChest();
    }

    @Override
    public boolean setWindowProperty(InventoryView.Property prop, int value) {
        return delegate().setWindowProperty(prop, value);
    }

    @Override
    public InventoryView getOpenInventory() {
        return delegate().getOpenInventory();
    }

    @Override
    public InventoryView openInventory(Inventory inventory) {
        return delegate().openInventory(inventory);
    }

    @Override
    public InventoryView openWorkbench(Location location, boolean force) {
        return delegate().openWorkbench(location, force);
    }

    @Override
    public InventoryView openEnchanting(Location location, boolean force) {
        return delegate().openEnchanting(location, force);
    }

    @Override
    public void openInventory(InventoryView inventory) {
        delegate().openInventory(inventory);
    }

    @Override
    public void closeInventory() {
        delegate().closeInventory();
    }

    @Override
    public ItemStack getItemInHand() {
        return delegate().getItemInHand();
    }

    @Override
    public void setItemInHand(ItemStack item) {
        delegate().setItemInHand(item);
    }

    @Override
    public ItemStack getItemOnCursor() {
        return delegate().getItemOnCursor();
    }

    @Override
    public void setItemOnCursor(ItemStack item) {
        delegate().setItemOnCursor(item);
    }

    @Override
    public boolean isSleeping() {
        return delegate().isSleeping();
    }

    @Override
    public int getSleepTicks() {
        return delegate().getSleepTicks();
    }

    @Override
    public GameMode getGameMode() {
        return delegate().getGameMode();
    }

    @Override
    public void setGameMode(GameMode mode) {
        delegate().setGameMode(mode);
    }

    @Override
    public boolean isBlocking() {
        return delegate().isBlocking();
    }

    @Override
    public int getExpToLevel() {
        return delegate().getExpToLevel();
    }

    @Override
    public double getEyeHeight() {
        return delegate().getEyeHeight();
    }

    @Override
    public double getEyeHeight(boolean ignoreSneaking) {
        return delegate().getEyeHeight(ignoreSneaking);
    }

    @Override
    public Location getEyeLocation() {
        return delegate().getEyeLocation();
    }

    @Override
    public List<Block> getLineOfSight(HashSet<Byte> transparent, int maxDistance) {
        return delegate().getLineOfSight(transparent, maxDistance);
    }

    @Override
    public List<Block> getLineOfSight(Set<Material> transparent, int maxDistance) {
        return delegate().getLineOfSight(transparent, maxDistance);
    }

    @Override
    public Block getTargetBlock(HashSet<Byte> transparent, int maxDistance) {
        return delegate().getTargetBlock(transparent, maxDistance);
    }

    @Override
    public Block getTargetBlock(Set<Material> transparent, int maxDistance) {
        return delegate().getTargetBlock(transparent, maxDistance);
    }

    @Override
    public List<Block> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance) {
        return delegate().getLastTwoTargetBlocks(transparent, maxDistance);
    }

    @Override
    public List<Block> getLastTwoTargetBlocks(Set<Material> transparent, int maxDistance) {
        return delegate().getLastTwoTargetBlocks(transparent, maxDistance);
    }

    @Override
    public Egg throwEgg() {
        return delegate().throwEgg();
    }

    @Override
    public Snowball throwSnowball() {
        return delegate().throwSnowball();
    }

    @Override
    public Arrow shootArrow() {
        return delegate().shootArrow();
    }

    @Override
    public int getRemainingAir() {
        return delegate().getRemainingAir();
    }

    @Override
    public void setRemainingAir(int ticks) {
        delegate().setRemainingAir(ticks);
    }

    @Override
    public int getMaximumAir() {
        return delegate().getMaximumAir();
    }

    @Override
    public void setMaximumAir(int ticks) {
        delegate().setMaximumAir(ticks);
    }

    @Override
    public int getMaximumNoDamageTicks() {
        return delegate().getMaximumNoDamageTicks();
    }

    @Override
    public void setMaximumNoDamageTicks(int ticks) {
        delegate().setMaximumNoDamageTicks(ticks);
    }

    @Override
    public double getLastDamage() {
        return delegate().getLastDamage();
    }

    @Override
    public void setLastDamage(double damage) {
        delegate().setLastDamage(damage);
    }

    @Override
    public int getNoDamageTicks() {
        return delegate().getNoDamageTicks();
    }

    @Override
    public void setNoDamageTicks(int ticks) {
        delegate().setNoDamageTicks(ticks);
    }

    @Override
    public Player getKiller() {
        return delegate().getKiller();
    }

    @Override
    public boolean addPotionEffect(PotionEffect effect) {
        return delegate().addPotionEffect(effect);
    }

    @Override
    public boolean addPotionEffect(PotionEffect effect, boolean force) {
        return delegate().addPotionEffect(effect, force);
    }

    @Override
    public boolean addPotionEffects(Collection<PotionEffect> effects) {
        return delegate().addPotionEffects(effects);
    }

    @Override
    public boolean hasPotionEffect(PotionEffectType type) {
        return delegate().hasPotionEffect(type);
    }

    @Override
    public void removePotionEffect(PotionEffectType type) {
        delegate().removePotionEffect(type);
    }

    @Override
    public Collection<PotionEffect> getActivePotionEffects() {
        return delegate().getActivePotionEffects();
    }

    @Override
    public boolean hasLineOfSight(Entity other) {
        return delegate().hasLineOfSight(other);
    }

    @Override
    public boolean getRemoveWhenFarAway() {
        return delegate().getRemoveWhenFarAway();
    }

    @Override
    public void setRemoveWhenFarAway(boolean remove) {
        delegate().setRemoveWhenFarAway(remove);
    }

    @Override
    public EntityEquipment getEquipment() {
        return delegate().getEquipment();
    }

    @Override
    public void setCanPickupItems(boolean pickup) {
        delegate().setCanPickupItems(pickup);
    }

    @Override
    public boolean getCanPickupItems() {
        return delegate().getCanPickupItems();
    }

    @Override
    public boolean isLeashed() {
        return delegate().isLeashed();
    }

    @Override
    public Entity getLeashHolder() throws IllegalStateException {
        return delegate().getLeashHolder();
    }

    @Override
    public boolean setLeashHolder(Entity holder) {
        return delegate().setLeashHolder(holder);
    }

    @Override
    public Location getLocation() {
        return delegate().getLocation();
    }

    @Override
    public Location getLocation(Location loc) {
        return delegate().getLocation(loc);
    }

    @Override
    public void setVelocity(Vector velocity) {
        delegate().setVelocity(velocity);
    }

    @Override
    public Vector getVelocity() {
        return delegate().getVelocity();
    }

    @Override
    public World getWorld() {
        return delegate().getWorld();
    }

    @Override
    public boolean teleport(Location location) {
        return delegate().teleport(location);
    }

    @Override
    public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause cause) {
        return delegate().teleport(this, cause);
    }

    @Override
    public boolean teleport(Entity destination) {
        return delegate().teleport(destination);
    }

    @Override
    public boolean teleport(Entity destination, PlayerTeleportEvent.TeleportCause cause) {
        return delegate().teleport(destination, cause);
    }

    @Override
    public List<Entity> getNearbyEntities(double x, double y, double z) {
        return delegate().getNearbyEntities(x, y, z);
    }

    @Override
    public int getEntityId() {
        return delegate().getEntityId();
    }

    @Override
    public int getFireTicks() {
        return delegate().getFireTicks();
    }

    @Override
    public int getMaxFireTicks() {
        return delegate().getMaxFireTicks();
    }

    @Override
    public void setFireTicks(int ticks) {
        delegate().setFireTicks(ticks);
    }

    @Override
    public void remove() {
        delegate().remove();
    }

    @Override
    public boolean isDead() {
        return delegate().isDead();
    }

    @Override
    public boolean isValid() {
        return delegate().isValid();
    }

    @Override
    public Server getServer() {
        return delegate().getServer();
    }

    @Override
    public Entity getPassenger() {
        return delegate().getPassenger();
    }

    @Override
    public boolean setPassenger(Entity passenger) {
        return delegate().setPassenger(passenger);
    }

    @Override
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override
    public boolean eject() {
        return delegate().eject();
    }

    @Override
    public float getFallDistance() {
        return delegate().getFallDistance();
    }

    @Override
    public void setFallDistance(float distance) {
        delegate().setFallDistance(distance);
    }

    @Override
    public void setLastDamageCause(EntityDamageEvent event) {
        delegate().setLastDamageCause(event);
    }

    @Override
    public EntityDamageEvent getLastDamageCause() {
        return delegate().getLastDamageCause();
    }

    @Override
    public UUID getUniqueId() {
        return delegate().getUniqueId();
    }

    @Override
    public int getTicksLived() {
        return delegate().getTicksLived();
    }

    @Override
    public void setTicksLived(int value) {
        delegate().setTicksLived(value);
    }

    @Override
    public void playEffect(EntityEffect type) {
        delegate().playEffect(type);
    }

    @Override
    public EntityType getType() {
        return delegate().getType();
    }

    @Override
    public boolean isInsideVehicle() {
        return delegate().isInsideVehicle();
    }

    @Override
    public boolean leaveVehicle() {
        return delegate().leaveVehicle();
    }

    @Override
    public Entity getVehicle() {
        return delegate().getVehicle();
    }

    @Override
    public void setCustomName(String name) {
        delegate().setCustomName(name);
    }

    @Override
    public String getCustomName() {
        return delegate().getCustomName();
    }

    @Override
    public void setCustomNameVisible(boolean flag) {
        delegate().setCustomNameVisible(flag);
    }

    @Override
    public boolean isCustomNameVisible() {
        return delegate().isCustomNameVisible();
    }

    @Override
    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
        delegate().setMetadata(metadataKey, newMetadataValue);
    }

    @Override
    public List<MetadataValue> getMetadata(String metadataKey) {
        return delegate().getMetadata(metadataKey);
    }

    @Override
    public boolean hasMetadata(String metadataKey) {
        return delegate().hasMetadata(metadataKey);
    }

    @Override
    public void removeMetadata(String metadataKey, Plugin owningPlugin) {
        delegate().removeMetadata(metadataKey, owningPlugin);
    }

    @Override
    public void sendMessage(String message) {
        delegate().sendMessage(message);
    }

    @Override
    public void sendMessage(String[] messages) {
        delegate().sendMessage(messages);
    }

    @Override
    public boolean isPermissionSet(String name) {
        return delegate().isPermissionSet(name);
    }

    @Override
    public boolean isPermissionSet(Permission perm) {
        return delegate().isPermissionSet(perm);
    }

    @Override
    public boolean hasPermission(String name) {
        return delegate().hasPermission(name);
    }

    @Override
    public boolean hasPermission(Permission perm) {
        return delegate().hasPermission(perm);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        return delegate().addAttachment(plugin, name, value);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        return delegate().addAttachment(plugin);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        return delegate().addAttachment(plugin, name, value, ticks);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        return delegate().addAttachment(plugin, ticks);
    }

    @Override
    public void removeAttachment(PermissionAttachment attachment) {
        delegate().removeAttachment(attachment);
    }

    @Override
    public void recalculatePermissions() {
        delegate().recalculatePermissions();
    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return delegate().getEffectivePermissions();
    }

    @Override
    public boolean isOp() {
        return delegate().isOp();
    }

    @Override
    public void setOp(boolean value) {
        delegate().setOp(value);
    }

    @Override
    public void damage(double amount) {
        delegate().damage(amount);
    }


    @Override
    public void damage(double amount, Entity source) {
        delegate().damage(amount, source);
    }


    @Override
    public double getHealth() {
        return delegate().getHealth();
    }


    @Override
    public void setHealth(double health) {
        delegate().setHealth(health);
    }

    @Override
    public double getMaxHealth() {
        return delegate().getMaxHealth();
    }

    @Override
    public void setMaxHealth(double health) {
        delegate().setMaxHealth(health);
    }


    @Override
    public void resetMaxHealth() {
        delegate().resetMaxHealth();
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
        return delegate().launchProjectile(projectile);
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
        return delegate().launchProjectile(projectile, velocity);
    }

    @Override
    public boolean isConversing() {
        return delegate().isConversing();
    }

    @Override
    public void acceptConversationInput(String input) {
        delegate().acceptConversationInput(input);
    }

    @Override
    public boolean beginConversation(Conversation conversation) {
        return delegate().beginConversation(conversation);
    }

    @Override
    public void abandonConversation(Conversation conversation) {
        delegate().abandonConversation(conversation);
    }

    @Override
    public void abandonConversation(Conversation conversation, ConversationAbandonedEvent details) {
        delegate().abandonConversation(conversation, details);
    }

    @Override
    public boolean isOnline() {
        return delegate().isOnline();
    }

    @Override
    public boolean isBanned() {
        return delegate().isBanned();
    }

    @Override
    public void setBanned(boolean banned) {
        delegate().setBanned(banned);
    }

    @Override
    public boolean isWhitelisted() {
        return delegate().isWhitelisted();
    }

    @Override
    public void setWhitelisted(boolean value) {
        delegate().setWhitelisted(value);
    }

    @Override
    public Player getPlayer() {
        return delegate().getPlayer();
    }

    @Override
    public long getFirstPlayed() {
        return delegate().getFirstPlayed();
    }

    @Override
    public long getLastPlayed() {
        return delegate().getLastPlayed();
    }

    @Override
    public boolean hasPlayedBefore() {
        return delegate().hasPlayedBefore();
    }

    @Override
    public Map<String, Object> serialize() {
        return delegate().serialize();
    }

    @Override
    public void sendPluginMessage(Plugin source, String channel, byte[] message) {
        delegate().sendPluginMessage(source, channel, message);
    }

    @Override
    public Set<String> getListeningPluginChannels() {
        return delegate().getListeningPluginChannels();
    }


}

