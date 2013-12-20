package me.TheInfoBug.SCmds.commands;

import me.TheInfoBug.SCmds.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class commandClear implements CommandExecutor {

	Main plugin;
	
	public commandClear(Main main){
		this.plugin = main;
	}
	
	ItemStack[] empty = {};
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("ci")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				p.getInventory().setContents(empty);
			}else{
				sender.sendMessage("Only players may use this command!");
			}
		}
		return true;
	}
}
