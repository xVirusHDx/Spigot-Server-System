package net.virushd.troll.main;

import org.bukkit.plugin.java.JavaPlugin;

public class TrollMain extends JavaPlugin {
	
	public static TrollMain main;
	
	@Override
	public void onEnable() {
		// instance
		main = this;

		// files
		FileManager.manager();

		// events
		// TODO register events

		// commands
		// TODO register commands (also in plugin.yml)
		
		// load message
		getLogger().info("Plugin enabled!");
	}
}
