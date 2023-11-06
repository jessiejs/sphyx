package jessiejs.tcmc.sphyx.layout;

import org.bukkit.event.inventory.InventoryType;

import net.kyori.adventure.text.Component;

public interface ItemLayout {
	public InventoryType getInventoryType();
	public ItemSlot getSlot(int slot);
	public Component getName();
}
