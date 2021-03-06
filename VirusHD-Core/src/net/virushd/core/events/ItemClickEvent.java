package net.virushd.core.events;

import java.util.ArrayList;

import net.virushd.core.main.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import net.virushd.core.inventories.Cosmetics;
import net.virushd.core.inventories.Teleporter;
import net.virushd.core.api.Utils;

public class ItemClickEvent implements Listener {

	public static ArrayList<Player> hideMode = new ArrayList<>();

	@EventHandler
	public void onItemRightClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if (PlayerManager.getPlayers().contains(p)) {
			if (e.getItem() != null) {
				if (e.getItem().isSimilar(Utils.getHideItem(p))) {

					// hide item (change hide mode)
					if (p.hasPermission("virushd.core.item.hide") || p.hasPermission("*")) {
						if (hideMode.contains(p)) {
							hideOff(p);
							hideMode.remove(p);
						} else {
							hideOn(p);
							hideMode.add(p);
						}
						p.getInventory().setItem(1, Utils.getHideItem(p));
					}
				} else if (e.getItem().isSimilar(Utils.getTeleporterItem())) {

					// teleport item (open teleport inventory)
					if (p.hasPermission("virushd.core.item.teleporter") || p.hasPermission("*")) {
						Teleporter.open(p);
					}
				} else if (e.getItem().isSimilar(Utils.getCosmeticsItem())) {

					// cosmetics item (open cosmetics inventory)
					if (p.hasPermission("virushd.core.item.cosmetics") || p.hasPermission("*")) {
						Cosmetics.open(p);
					}
				}
			}
		}
	}

	// turn hide mode on
	public static void hideOn(Player p) {
		for (Player players : PlayerManager.getPlayers()) {
			p.hidePlayer(players);
		}
	}

	// turn hide mode off
	public static void hideOff(Player p) {
		for (Player players : PlayerManager.getPlayers()) {
			p.showPlayer(players);
		}
	}
}
