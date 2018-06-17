package io.github.louisiuol0.minecraft_str_plugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;

import java.util.HashMap;

import org.bukkit.entity.Entity;

public class STR_PluginPlayerListener implements Listener {

    private Minecraft_STR_Plugin plugin;
    private HashMap<Player, Entity> DesignedEntities;
    
    public STR_PluginPlayerListener(Minecraft_STR_Plugin instance) {
            plugin = instance;
            DesignedEntities = new HashMap<>(); 
    }
	
	@EventHandler
	public void onClickOnEntity(PlayerInteractEvent event) {
		plugin.getLogger().info("oulalalala");
		if (event.getAction() == Action.LEFT_CLICK_AIR) {
			plugin.getLogger().info("EN Plus !!");
		}
	}
	
}
