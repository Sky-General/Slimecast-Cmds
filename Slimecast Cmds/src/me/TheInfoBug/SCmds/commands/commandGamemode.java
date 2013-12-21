package me.TheInfoBug.SCmds.commands;

import me.TheInfoBug.SCmds.Main;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandGamemode implements CommandExecutor {

	//Working [Tested]
	
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
							sender.sendMessage(ChatColor.YELLOW + "[" + ChatColor.GREEN + "SCmds" + ChatColor.YELLOW + "] " + ChatColor.YELLOW + "Gamemode: " + ChatColor.GREEN + "Survival");
						}else if(args[0].equalsIgnoreCase("c") || args[0].equals("1")){
							p.setGameMode(GameMode.CREATIVE);
							sender.sendMessage(ChatColor.YELLOW + "[" + ChatColor.GREEN + "SCmds" + ChatColor.YELLOW + "] " + ChatColor.YELLOW + "Gamemode: " + ChatColor.GREEN + "Creative");
						}else{
							sender.sendMessage(ChatColor.YELLOW + "Usage: /gm (GameMode)");
						}
						
					}else{
						sender.sendMessage(ChatColor.YELLOW + "Usage: /gm (GameMode)");
					}
					
				}else{
					sender.sendMessage(ChatColor.YELLOW + "[" + ChatColor.GREEN + "SCmds" + ChatColor.YELLOW + "] " + ChatColor.YELLOW + "You may not use this command!");
				}
				
			}else{
				sender.sendMessage("Only players may use this command!");
			}
		}
		return true;
	}
}