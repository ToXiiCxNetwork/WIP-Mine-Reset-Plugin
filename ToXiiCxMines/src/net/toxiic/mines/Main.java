package net.toxiic.mines;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;

import net.toxiic.mines.util.files.Config;

public class Main extends JavaPlugin {
	private static final Logger log = Logger.getLogger("Minecraft");
	public static WorldEditPlugin worldEditPlugin = null;
	public Player player = null;
	public static Main plugin;
	
	public void onEnable() {
		worldEditPlugin = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
        if(worldEditPlugin == null){
            log.severe(String.format("[%s] - Disabled: WorldEdit Missing", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        } else if(worldEditPlugin != null) {
        	Bukkit.getLogger().info("- Hello Worldedit!");
        	
        }
        
        plugin = this;
        Config.setup(plugin);
        registerCommands();
	}
	
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = Logger.getLogger("Minecraft");

		logger.info(pdfFile.getName() + " has been disable!");
	}

	
	public void registerCommands() {
		
	}
	
}
