package rpgraces.gui;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import rpgraces.RPGRaces;
import rpgraces.RPGRacesUtil;

public class RaceSelectionGUI implements Listener {
	
	// This is so fucked
	
	private final Inventory inv;

    public RaceSelectionGUI() {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(new CustomHolder(), 9, "Race Selection");
        
        // Put the items into the inventory
        initializeItems();
    }

    // You can call this whenever you want to put the items in
    public void initializeItems() {
        inv.addItem(createGuiItem(Material.DIRT, "Human", "Absorption", ""));
        inv.addItem(createGuiItem(Material.IRON_PICKAXE, "Dwarf", "Haste", ""));
        inv.addItem(createGuiItem(Material.KELP, "Water Nymph", "Power of the Conduit", ""));
        inv.addItem(createGuiItem(Material.STONE, "Cave Elf", "Night Vision", ""));
        inv.addItem(createGuiItem(Material.IRON_AXE, "Orc", "Strength", ""));
        inv.addItem(createGuiItem(Material.GOLD_NUGGET, "Goblin", "Luck", ""));
        inv.addItem(createGuiItem(Material.POPPY, "Meadow Elf", "Speed", ""));
        inv.addItem(createGuiItem(Material.BAMBOO, "Wood Elf", "Jump Boost", ""));
        // set item 
    }

    // Nice little method to create a gui item with a custom name, and description
    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setDisplayName(name);

        // Set the lore of the item
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

        return item;
    }

    // You can open the inventory with this
    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);
    }

    // Check for clicks on items
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getInventory().getHolder() instanceof CustomHolder) {
        	final ItemStack clickedItem = e.getCurrentItem();

            // verify current item is not null
            if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

            final Player p = (Player) e.getWhoClicked();
            
            // Using slots click is a best option for your inventory click's
            p.sendMessage("§6You chose the way of the §5" + clickedItem.getItemMeta().getDisplayName() + "§r§6.");
            
            switch(clickedItem.getItemMeta().getDisplayName()) {
            // Case should be by race material, get this from main
            	case "Human":
            		//new PotionEffect(PotionEffectType.ABSORPTION, -1, 1, false).apply(e.getWhoClicked());
            		e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, Integer.MAX_VALUE, 1, true));
            		System.out.println(e.getWhoClicked() + " chose Human."); 
            		break;
            	case "Dwarf":
            		//new PotionEffect(PotionEffectType.FAST_DIGGING, -1, 1, false).apply(e.getWhoClicked());
            		e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 1, true));
            		System.out.println(e.getWhoClicked() + " chose Dwarf."); 
            		break;
            	case "Water Nymph":
            		//new PotionEffect(PotionEffectType.CONDUIT_POWER, -1, 1, false).apply(e.getWhoClicked());
            		e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER, Integer.MAX_VALUE, 1, true));
            		System.out.println(e.getWhoClicked() + " chose Water Nymph."); 
            		break;
            	case "Cave Elf":
            		//new PotionEffect(PotionEffectType.NIGHT_VISION, -1, 1, false).apply(e.getWhoClicked());
            		e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1, true));
            		System.out.println(e.getWhoClicked() + " chose Cave Elf."); 
            		break;
            	case "Meadow Elf":
            		//new PotionEffect(PotionEffectType.SPEED, -1, 1, false).apply(e.getWhoClicked());
            		e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, true));
            		System.out.println(e.getWhoClicked() + " chose Meadow Elf."); 
            		break;
            	case "Wood Elf":
            		//new PotionEffect(PotionEffectType.JUMP, -1, 1, false).apply(e.getWhoClicked());
            		e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1, true));
            		System.out.println(e.getWhoClicked() + " chose Wood Elf."); 
            		break;
            	case "Goblin":
            		//new PotionEffect(PotionEffectType.LUCK, -1, 1, false).apply(e.getWhoClicked());
            		e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1, false));
            		System.out.println(e.getWhoClicked() + " chose Goblin."); 
            		break;
            	case "Orc":
            		//new PotionEffect(PotionEffectType.INCREASE_DAMAGE, -1, 1, false).apply(e.getWhoClicked());
            		e.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1, false));
            		System.out.println(e.getWhoClicked() + " chose Orc."); 
            		break;
            }
            
            e.setCancelled(true);
        }
    }

	// Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory().equals(inv)) {
        	
          e.setCancelled(true);
        }
    }
}
