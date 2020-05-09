package rpgraces;

import java.util.ArrayList;

import org.bukkit.Material;

import rpgraces.races.Race;

public final class RPGRacesUtil {
	public ArrayList<Race> races = new ArrayList<Race>();
	
	private final static Race HUMAN = new Race("human", "absorption", 1, Material.PLAYER_HEAD);
	private final static Race DWARF = new Race("dwarf", "haste", 1, Material.IRON_PICKAXE);
	private final static Race WATER_NYMPH = new Race("water_nymph", "conduit_power", 1, Material.KELP);
	private final static Race CAVE_ELF = new Race("cave_elf", "night_vision", 1, Material.STONE);
	private final static Race ORC = new Race("orc", "strength", 1, Material.IRON_AXE);
	private final static Race GOBLIN = new Race("goblin", "luck", 1, Material.GOLD_NUGGET);
	private final static Race MEADOW_ELF = new Race("meadow_elf", "speed", 1, Material.POPPY);
	private final static Race WOOD_ELF = new Race("wood_elf", "jump_boost", 1, Material.BAMBOO);
	
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
}
