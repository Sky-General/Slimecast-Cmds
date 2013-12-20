package me.TheInfoBug.SCmds;

import me.TheInfoBug.SCmds.commands.commandClear;
import me.TheInfoBug.SCmds.commands.commandGamemode;
import me.TheInfoBug.SCmds.commands.commandKill;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	PluginManager pm = Bukkit.getPluginManager();
	
	public void onEnable(){
		
		setCommands();
		
	}
	
	//I like using methods. To keep the onEnable() clean 
	public void setCommands(){
		
		getCommand("ci").setExecutor(new commandClear(this));
		getCommand("gm").setExecutor(new commandGamemode(this));
		getCommand("kill").setExecutor(new commandKill(this));
		
	}
}
