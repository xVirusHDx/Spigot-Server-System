package net.virushd.core.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import net.virushd.core.main.CoreMain;

// disable things that nosy players make xD
public class InvClickEvent implements Listener {

	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (CoreMain.getPlayers().contains(p)) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();

		if (CoreMain.getPlayers().contains(p)) {
			e.setCancelled(true);
		}
	}
}
