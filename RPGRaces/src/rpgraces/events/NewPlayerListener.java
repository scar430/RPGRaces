package rpgraces.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.mysql.jdbc.Statement;

import rpgraces.RPGRaces;
import rpgraces.gui.ExampleGui;
import rpgraces.gui.RaceSelectionGUI;

public class NewPlayerListener implements Listener {
	
	public NewPlayerListener(RPGRaces main) {
		
	}
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
		if (!event.getPlayer().hasPlayedBefore()) {
			RaceSelectionGUI inv = new RaceSelectionGUI();
			inv.openInventory(event.getPlayer());
		}
    }
}
