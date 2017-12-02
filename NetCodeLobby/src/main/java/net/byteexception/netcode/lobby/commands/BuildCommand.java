package net.byteexception.netcode.lobby.commands;

import net.byteexception.netcode.lobby.LobbyPlugin;
import net.byteexception.netcode.lobby.user.User;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class BuildCommand extends BukkitCommand {

    public BuildCommand() {
        super("build");
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if(commandSender.hasPermission("lobby.build")) {
            if(commandSender instanceof Player) {
                User user = User.getUser((Player) commandSender);
                boolean building;
                user.setBuilding(building = !user.isBuilding());

                if(building) {
                    user.sendMessage("§aDu darfst nun bauen");
                    user.flush(GameMode.CREATIVE);
                } else {
                    user.sendMessage("§cDu darfst nun nichtmehr bauen");
                    user.flush(GameMode.ADVENTURE);
                    LobbyPlugin.getInstance().getLobbyConfig().getLayout().give(user);
                }
            }
        } else {
            commandSender.sendMessage(getPermissionMessage());
        }
        return true;
    }
}
