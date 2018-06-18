package io.github.louisiuol0.minecraft_str_plugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Creature;

public class STR_PluginPlayerListener implements Listener {

    private Minecraft_STR_Plugin plugin;
    private HashMap<Player, Creature> DesignedEntities;
    
    public STR_PluginPlayerListener(Minecraft_STR_Plugin instance) {
            plugin = instance;
            DesignedEntities = new HashMap<>(); 
    }
	
	@EventHandler
	public void onClickOnEntity(PlayerInteractEvent event) {
		plugin.getLogger().info("oulalalala");
		if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
			List<Block> blocks = event.getPlayer().getLineOfSight(null, 20);
			List<Entity> entities = event.getPlayer().getNearbyEntities(40, 40, 40);
			Boolean found = false;
			Creature target = null;
			for(Block block : blocks) {
				plugin.getLogger().info(block.getType().name());
				Location loc = block.getLocation();
				for(Entity entity : entities) {
					if (entity instanceof Creature) {
						Location locty = entity.getLocation();
						if(loc.getX() + 1 >= locty.getX() - entity.getWidth() && loc.getX() <= locty.getX() + entity.getWidth()
						&& loc.getY() + 1 >= locty.getY() + entity.getHeight() && loc.getY() <= locty.getY() + entity.getHeight()
						&& loc.getZ() + 1 >= locty.getZ() - entity.getWidth() && loc.getZ() <= locty.getZ() + entity.getWidth()) {
							entity.setFireTicks(50);
							target = (Creature) entity;
							found = true;
							break;
						}
					}
				}
				if(found) break;
			}
			if(!found) DesignedEntities.remove(event.getPlayer());
			else DesignedEntities.put(event.getPlayer(), target);
		}
		else if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			plugin.getLogger().info("EN Plus !!");
			if (DesignedEntities.containsKey(event.getPlayer())){
				plugin.getLogger().info("Et BIIIMMM !!");
				List<Block> blocks = event.getPlayer().getLineOfSight(null, 20);
				List<Entity> entities = event.getPlayer().getNearbyEntities(40, 40, 40);
				Boolean found = false;
				LivingEntity target = null;
				for(Block block : blocks) {
					plugin.getLogger().info(block.getType().name());
					Location loc = block.getLocation();
					for(Entity entity : entities) {
						if (entity instanceof LivingEntity) {
							Location locty = entity.getLocation();
							if(loc.getX() + 1 >= locty.getX() - entity.getWidth() && loc.getX() <= locty.getX() + entity.getWidth()
							&& loc.getY() + 1 >= locty.getY() + entity.getHeight() && loc.getY() <= locty.getY() + entity.getHeight()
							&& loc.getZ() + 1 >= locty.getZ() - entity.getWidth() && loc.getZ() <= locty.getZ() + entity.getWidth()) {
								entity.setFireTicks(50);
								target = (LivingEntity) entity;
								found = true;
								break;
							}
						}
					}
					if(found) break;
				}
				if(found) DesignedEntities.get(event.getPlayer()).setTarget(target);
			}
		}
	}
}
