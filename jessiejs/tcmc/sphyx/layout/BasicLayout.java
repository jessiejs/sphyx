package jessiejs.tcmc.sphyx.layout;

import org.apache.commons.lang3.ArrayUtils;
import org.bukkit.event.inventory.InventoryType;

import net.kyori.adventure.text.Component;

public class BasicLayout implements ItemLayout {
	private InventoryType type = InventoryType.CHEST;
	private Component name = Component.text("UI");
	private ItemSlot[] slots;

	public BasicLayout type(InventoryType type) {
		this.type = type;
		return this;
	}

	public BasicLayout name(Component name) {
		this.name = name;
		return this;
	}

	public BasicLayout slots(ItemSlot... slots) {
		this.slots = slots;
		return this;
	}

	public BasicLayout add(ItemSlot... slots) {
		for (ItemSlot slot : slots) {
			this.slots = ArrayUtils.add(this.slots, slot);
		}
		return this;
	}

	public BasicLayout clear() {
		this.slots = new ItemSlot[0];
		return this;
	}

	public InventoryType getInventoryType() {
		return type;
	}

	public Component getName() {
		return name;
	}

	public ItemSlot getSlot(int slot) {
		if (slot >= slots.length) {
			return null;
		}

		return slots[slot];
	}
}
