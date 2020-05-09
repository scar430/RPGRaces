package rpgraces.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class NewPlayerListener implements Listener {
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
		// TO DO
		// Logic gate to check if the player has selected a race before.
    }
}
