package me.TheInfoBug.SCmds;

import me.TheInfoBug.SCmds.commands.commandClear;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	PluginManager pm = Bukkit.getPluginManager();
	
	public void onEnable(){
		
		setCommands();
		
	}
	
	
	public void setCommands(){
		
		getCommand("ci").setExecutor(new commandClear(this));
		
	}
}
