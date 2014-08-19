package me.TheInfoBug.SCmds.commands;

import me.TheInfoBug.SCmds.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class commandKillall implements CommandExecutor {

	//Working [Tested]
	
	Main plugin;
	
	public commandKillall(Main main){
		this.plugin = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("killall")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(p.isOp() || p.hasPermission("scmds.killall")){
					for(Entity entity : p.getNearbyEntities(2000, 2000, 2000)){
						if((!(entity instanceof Player)) && entity instanceof LivingEntity || (!(entity instanceof Player)) && entity instanceof Entity){
							entity.remove();
						}
					}
					sender.sendMessage(ChatColor.YELLOW + "[" + ChatColor.GREEN + "SCmds" + ChatColor.YELLOW + "] " + ChatColor.YELLOW + "All Mobs killed!");
					
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
