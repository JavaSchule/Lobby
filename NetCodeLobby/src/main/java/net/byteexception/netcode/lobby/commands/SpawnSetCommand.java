package net.byteexception.netcode.lobby.commands;

import net.byteexception.netcode.lobby.LobbyPlugin;
import net.byteexception.netcode.lobby.config.Warp;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class SpawnSetCommand extends BukkitCommand{

    public SpawnSetCommand() {
        super("setspawn");
    }

    @Override
    public boolean execute(CommandSender sender,String label, String[] args) {

        if (sender instanceof Player) {

            Player p = (Player) sender;

            if (args.length >= 1) {
                if (p.getName().equalsIgnoreCase("ByteExceptionYT")) {
                    for(Warp warp : Warp.values()) {
                        if(warp.name().equalsIgnoreCase(args[0])){
                            warp.setLocation(p.getLocation());
                            p.sendMessage(String.format("§eDu hast den §6%s§e Spawn gesetzt",args[0]));
                        }
                    }
                }else{
                    p.sendMessage("§cDu hast dazu keine Rechte!");
                }
            }else{
                p.sendMessage("§7Nutze §e/setspawn <ID/Name>");
            }

        }else{
            System.out.println("You cant set a spawn without a Bukkit:Player");
        }
        return false;
    }
}
