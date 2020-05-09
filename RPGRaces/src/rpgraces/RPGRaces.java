package rpgraces;

import org.bukkit.plugin.java.JavaPlugin;

import rpgraces.events.NewPlayerListener;

public class RPGRaces extends JavaPlugin {
	
	public RPGRacesUtil util;
	
	// Fired when plugin is first enabled
    @Override
    public void onEnable() {
    	getServer().getPluginManager().registerEvents(new NewPlayerListener(), this);
    	util = new RPGRacesUtil();
    }
    
    // Fired when plugin is disabled
    @Override
    public void onDisable() {

    }
}
