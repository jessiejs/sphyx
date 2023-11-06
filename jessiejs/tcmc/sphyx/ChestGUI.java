package jessiejs.tcmc.sphyx;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import jessiejs.tcmc.sphyx.layout.ItemLayout;
import jessiejs.tcmc.sphyx.layout.ItemSlot;

public class ChestGUI implements Listener {
	ItemLayout layout;
	Inventory inventory;
	Player player;

	public ChestGUI(Plugin plugin, Player player, ItemLayout layout) {
		Inventory inv = Bukkit.createInventory(player, layout.getInventoryType(), layout.getName());

		this.inventory = inv;
		this.player = player;

		for (int i = 0; i < inv.getSize(); i++) {
			ItemSlot slot = layout.getSlot(i);

			if (slot == null) {
				continue;
			}

			ItemStack item = new ItemStack(slot.getType());

			// set name
			ItemMeta meta = item.getItemMeta();
			meta.displayName(slot.getName());
			item.setItemMeta(meta);

			inv.setItem(i, item);
		}

		this.layout = layout;

		player.openInventory(inv);

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (event.getWhoClicked() != player) {
			return;
		}

		event.setCancelled(true);

		if (event.getClickedInventory() != inventory) {
			return;
		}

		ItemSlot slot = layout.getSlot(event.getSlot());

		if (slot == null) {
			return;
		}

		slot.getCallback().apply((Player)event.getWhoClicked());
	}

	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event) {
		if (event.getPlayer() != player) {
			return;
		}

		HandlerList.unregisterAll(this);
	}
}
