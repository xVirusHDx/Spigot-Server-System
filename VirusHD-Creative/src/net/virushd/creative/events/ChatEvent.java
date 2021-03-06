package net.virushd.creative.events;

import net.virushd.creative.main.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.virushd.core.main.CoreMain;
import net.virushd.creative.main.CreativeMain;
import net.virushd.creative.main.FileManager;
import net.virushd.core.api.PlaceHolder;

public class ChatEvent implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {

		Player p = e.getPlayer();

		if (PlayerManager.getPlayers().contains(p)) {

			// debug
			if (CoreMain.debug()) {
				CreativeMain.main.getLogger().info("DEBUG: (Chat) " + p.getName() + ": " + e.getMessage());
			}

			String ChatFormat = PlaceHolder.withPlayer(FileManager.messages.getString("ChatFormat"), p);

			// send all players in creative the message
			for (Player players : PlayerManager.getPlayers()) {
				players.sendMessage(ChatFormat.replace("{Message}", e.getMessage()));
			}
		}
	}
}
