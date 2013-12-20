package me.TheInfoBug.SCmds.commands;

import me.TheInfoBug.SCmds.Main;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandGamemode implements CommandExecutor {

	Main plugin;
	
	public commandGamemode(Main main){
		this.plugin = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("gm")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(p.isOp() || p.hasPermission("scmds.gm")){
					if(!(args.length < 1)){
						if(args[0].equalsIgnoreCase("s") || args[0].equals("0")){
							p.setGameMode(GameMode.SURVIVAL);
						}else if(args[0].equalsIgnoreCase("c") || args[0].equals("1")){
							p.setGameMode(GameMode.CREATIVE);
						}else{
							sender.sendMessage(ChatColor.GOLD + "Usage: /gm (GameMode)");
						}
						
					}else{
						sender.sendMessage(ChatColor.GOLD + "Usage: /gm (GameMode)");
					}
					
				}else{
					sender.sendMessage(ChatColor.GOLD + "[" + ChatColor.GREEN + "SCmds" + ChatColor.GOLD + "] " + ChatColor.GREEN + "You may not use this command!");
				}
				
			}else{
				sender.sendMessage("Only players may use this command!");
			}
		}
		return true;
	}
}