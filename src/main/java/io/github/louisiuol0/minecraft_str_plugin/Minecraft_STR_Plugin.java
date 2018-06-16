package io.github.louisiuol0.minecraft_str_plugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class Minecraft_STR_Plugin extends 
JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info("onEnable has been invoked!");
	}

	@Override
	public void onDisable() {
		getLogger().info("onDisable has been invoked!");
	}
}
