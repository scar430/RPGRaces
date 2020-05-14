package rpgraces;

import java.util.ArrayList;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import rpgraces.events.NewPlayerListener;
import rpgraces.gui.ExampleGui;
import rpgraces.gui.RaceSelectionGUI;

public class RPGRaces extends JavaPlugin {
	
	public RPGRacesUtil util;
	
	// All the players that have been loaded/saved
	public ArrayList<String> players = new ArrayList<String>();
	
	// All the players that have not been saved yet, this is basically a cache.
	public ArrayList<String> playersToSave = new ArrayList<String>();
	
	// Fired when plugin is first enabled
    @Override
    public void onEnable() { 
        
    	util = new RPGRacesUtil();
    	getServer().getPluginManager().registerEvents(new NewPlayerListener(this), this);
    	getServer().getPluginManager().registerEvents(new RaceSelectionGUI(), this);
        
        
    	//getServer().getPluginManager().registerEvents(new ExampleGui(), this);
    }
    
    // Fired when plugin is disabled
    @Override
    public void onDisable() {
    	
    }
}
