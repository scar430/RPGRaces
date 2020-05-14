package rpgraces.races;

import org.bukkit.Material;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Race {
	
	// Name of the race.
	public String name;
	
	// Effect the race applies.
	public PotionEffect effect;
	
	// Item that represents the race in menus.
	public Material item;
	
	public Race(String newName, PotionEffectType type, int amplifier, Material newItem) {
		
		
		name = newName;
		
		// On ambient = true, the particle effects and buff indicator will not be displayed.
		effect = new PotionEffect(type, -1, amplifier, true);
		
		item = newItem;
	}
	
	/* NAME */
	
	public void SetName(String newName) {
		name = newName;
	}
	
	public String GetName() {
		return name;
	}
	
	/* EFFECT */
	
	public void SetPotionEffect(PotionEffect newEffect) {
		effect = newEffect;
	}
	
	public PotionEffect GetPotionEffect() {
		return effect;
	}
	
	public void ApplyEffect() {
		// TO DO ...
	}
}
