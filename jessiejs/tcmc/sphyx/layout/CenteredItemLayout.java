package jessiejs.tcmc.sphyx.layout;

import org.apache.commons.lang3.ArrayUtils;
import org.bukkit.event.inventory.InventoryType;

import jessiejs.tcmc.sphyx.util.ContainerSize;
import net.kyori.adventure.text.Component;

public class CenteredItemLayout implements ItemLayout {
	InventoryType type = InventoryType.CHEST;
	Component name = Component.text("UI");
	ItemSlot[] slots;

	public CenteredItemLayout type(InventoryType type) {
		this.type = type;
		return this;
	}

	public CenteredItemLayout name(Component name) {
		this.name = name;
		return this;
	}

	public CenteredItemLayout slots(ItemSlot... slots) {
		this.slots = slots;
		return this;
	}

	public CenteredItemLayout add(ItemSlot... slots) {
		for (ItemSlot slot : slots) {
			this.slots = ArrayUtils.add(this.slots, slot);
		}
		return this;
	}

	public CenteredItemLayout clear() {
		this.slots = new ItemSlot[0];
		return this;
	}

	@Override
	public InventoryType getInventoryType() {
		return type;
	}

	@Override
	public Component getName() {
		return name;
	}

	@Override
	public ItemSlot getSlot(int slot) {
		int startSlot = (ContainerSize.getInventorySize(type) - slots.length) / 2;

		if (slot >= startSlot && slot < startSlot + slots.length) {
			return slots[slot - startSlot];
		}

		return null;
	}
}
