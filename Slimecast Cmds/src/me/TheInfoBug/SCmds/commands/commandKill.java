package me.TheInfoBug.SCmds.commands;

import me.TheInfoBug.SCmds.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandKill implements CommandExecutor {

	Main plugin;
	
	public commandKill(Main main){
		this.plugin = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("kill")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(p.isOp() || p.hasPermission("scmds.kill")){
					if(!(args.length < 1)){
						Player t = Bukkit.getPlayer(args[0]);
						if(t != null){
							t.setHealth(0);
							p.sendMessage(ChatColor.YELLOW + "[" + ChatColor.GREEN + "SCmds" + ChatColor.YELLOW + "] " + ChatColor.GREEN + t.getDisplayName() + " has been killed");
							t.sendMessage(ChatColor.YELLOW + "[" + ChatColor.GREEN + "SCmds" + ChatColor.YELLOW + "] " + ChatColor.GREEN + "You were killed!");
						}else{
							sender.sendMessage(ChatColor.YELLOW + "[" + ChatColor.GREEN + "SCmds" + ChatColor.YELLOW + "] " + ChatColor.GREEN + "Player not found!");
						}
						
					}else{
						p.setHealth(0);
						sender.sendMessage(ChatColor.YELLOW + "[" + ChatColor.GREEN + "SCmds" + ChatColor.YELLOW + "] " + ChatColor.GREEN + "You were killed!");
					}

				}else{
					sender.sendMessage(ChatColor.YELLOW + "[" + ChatColor.GREEN + "SCmds" + ChatColor.YELLOW + "] " + ChatColor.GREEN + "You may not use this command!");
				}
				
			}else{
				sender.sendMessage("Only players may use this command!");
			}
		}
		return true;
	}
}
