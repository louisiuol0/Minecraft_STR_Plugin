package io.github.louisiuol0.minecraft_str_plugin;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.plugin.java.JavaPlugin;

public final class Minecraft_STR_Plugin extends 
JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info("onEnable has been invoked!");
		getServer().getPluginManager().registerEvents(new STR_PluginPlayerListener(this), this);
	}

	@Override
	public void onDisable() {
		getLogger().info("onDisable has been invoked!");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("newzombie")) { // If the player typed /newhuman then do the following, note: If you only registered this executor for one command, you don't need this
			getLogger().info("whaou!");
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
			} else {
				getLogger().info("Yes");
				sender.sendMessage("AAAA");
				Player player = (Player) sender;
				Location target = player.getTargetBlock(null, 10).getLocation();
				// HumanEntity newhuman = (HumanEntity) player.getWorld().spawn(target.add(0.0, 1.0, 0.0), HumanEntity.class);
				Zombie newzombie = (Zombie) player.getWorld().spawnEntity(target.add(0.0, 1.0, 0.0), EntityType.ZOMBIE);
				newzombie.setAI(false);
				// newhuman.setFireTicks(400);
			}
			return true;
		} //If this has happened the function will return true. 
	        // If this hasn't happened the value of false will be returned.
		return false;
	}
	
}
