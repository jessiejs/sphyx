package jessiejs.tcmc.sphyx.util;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class ContainerSize {
	public static int getContainerWidth(InventoryType type) {
		return 9;
	}

	public static int getInventorySize(InventoryType type) {
		Inventory inventory = Bukkit.createInventory(null, type);
		return inventory.getSize();
	}

	public static int getContainerHeight(InventoryType type) {
		return getInventorySize(type) / getContainerWidth(type);
	}
}
