package jessiejs.tcmc.sphyx.layout;

import java.util.function.Function;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import net.kyori.adventure.text.Component;

public class ItemSlot {
	private Material type;
	private Function<Player, Boolean> callback;
	private Component name;

	public ItemSlot type(Material type) {
		this.type = type;
		return this;
	}

	public ItemSlot callback(Function<Player, Boolean> callback) {
		this.callback = callback;
		return this;
	}

	public ItemSlot name(Component name) {
		this.name = name;
		return this;
	}

	public Material getType() {
		return type;
	}
	public Function<Player, Boolean> getCallback() {
		return callback;
	}
	public Component getName() {
		return name;
	}
}
