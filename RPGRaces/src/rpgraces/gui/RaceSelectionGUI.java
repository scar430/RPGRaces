package rpgraces.gui;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RaceSelectionGUI implements Listener {
	private final Inventory inv;

    public RaceSelectionGUI() {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, 8, "Race Selection");

        // Put the items into the inventory
        initializeItems();
    }

    // You can call this whenever you want to put the items in
    public void initializeItems() {
        inv.addItem(createGuiItem(Material.PLAYER_HEAD, "&cHuman", "&eAbsorption", ""));
        inv.addItem(createGuiItem(Material.IRON_PICKAXE, "&cDwarf", "&eHaste", ""));
        inv.addItem(createGuiItem(Material.KELP_PLANT, "&cWater Nymph", "&ePower of the Conduit", ""));
        inv.addItem(createGuiItem(Material.STONE, "&cCave Elf", "&eNight Vision", ""));
        inv.addItem(createGuiItem(Material.IRON_AXE, "&cOrc", "&eStrength", ""));
        inv.addItem(createGuiItem(Material.GOLD_NUGGET, "&cGoblin", "&eLuck", ""));
        inv.addItem(createGuiItem(Material.GOLD_NUGGET, "&cGoblin", "&eLuck", ""));
        inv.addItem(createGuiItem(Material.POPPY, "&cMeadow Elf", "&eSpeed", ""));
        inv.addItem(createGuiItem(Material.BAMBOO, "&cWood Elf", "&eJump Boost", ""));
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
        if (e.getInventory() != inv) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        final Player p = (Player) e.getWhoClicked();

        // Using slots click is a best option for your inventory click's
        p.sendMessage("&eYou chose the way of the " + clickedItem.getItemMeta().getDisplayName() + "&r&e.");
    }

    // Cancel dragging in our inventory
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory() == inv) {
          e.setCancelled(true);
        }
    }
}
