package rpgraces;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.potion.PotionEffectType;

import rpgraces.gui.RaceSelectionGUI;
import rpgraces.races.Race;

public final class RPGRacesUtil {
	
	// This needs to be changed so races can be made from a config.
	
	//public ArrayList<Race> races = new ArrayList<Race>();
	
	public final static Race HUMAN = new Race("Human", PotionEffectType.ABSORPTION, 1, Material.PLAYER_HEAD);
	public final static Race DWARF = new Race("Dwarf", PotionEffectType.FAST_DIGGING, 1, Material.IRON_PICKAXE);
	public final static Race WATER_NYMPH = new Race("Water Nymph", PotionEffectType.CONDUIT_POWER, 1, Material.KELP);
	public final static Race CAVE_ELF = new Race("Cave Elf", PotionEffectType.NIGHT_VISION, 1, Material.STONE);
	public final static Race ORC = new Race("Orc", PotionEffectType.INCREASE_DAMAGE, 1, Material.IRON_AXE);
	public final static Race GOBLIN = new Race("Goblin", PotionEffectType.LUCK, 1, Material.GOLD_NUGGET);
	public final static Race MEADOW_ELF = new Race("Meadow_elf", PotionEffectType.SPEED, 1, Material.POPPY);
	public final static Race WOOD_ELF = new Race("Wood Elf", PotionEffectType.JUMP, 1, Material.BAMBOO);
	
	/*
	// Add appropriate races to the list of races so these can be read and implemented properly
	public void RegisterRaces(){
		races.add(HUMAN);
		races.add(DWARF);
		races.add(WATER_NYMPH);
		races.add(CAVE_ELF);
		races.add(ORC);
		races.add(GOBLIN);
		races.add(MEADOW_ELF);
		races.add(WOOD_ELF);
	}
	*/
}
