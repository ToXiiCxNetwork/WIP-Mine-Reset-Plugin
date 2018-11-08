package net.toxiic.mines.util.files;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

import net.toxiic.mines.util.Util;

public class Mines {
	private Mines() {}	
	static Mines instance = new Mines();
	static Plugin p;
	static FileConfiguration Mines;
	static File dfile;
	
	public static void setup(Plugin p) {
		if (!p.getDataFolder().exists()) {
			p.getDataFolder().mkdir();
		}
		dfile = new File(p.getDataFolder(), "Mines.yml");
		if (!dfile.exists()) {
			try {
				dfile.createNewFile();
			} catch(IOException e) {
				Bukkit.getServer().getLogger().severe(Util.color("&cCould not create Mines.yml!"));
			}
		}
		Mines = YamlConfiguration.loadConfiguration(dfile);
	}
	
	public static FileConfiguration getMines() {
		return Mines;
	}
	
	public static void saveMines() {
		try {
			Mines.save(dfile);
		} catch (IOException e) {
			Bukkit.getServer().getLogger().severe(Util.color("&cCould not save Mines.yml!"));
		}
	}
	
	public static void reloadMines() {
		Mines = YamlConfiguration.loadConfiguration(dfile);
	}
	
	public static PluginDescriptionFile getDesc() {
		return p.getDescription();
	}

	public static int getInt(String path) {
		return Integer.valueOf(getString(path));
	}

	public static double getDouble(String path) {
		return Double.valueOf(getString(path));
	}

	public static long getLong(String path) {
		return getMines().getLong(path);
	}

	public static List<String> getList(String path) {
		return getMines().getStringList(path);
	}

	public static String getString(String path) {
		return getMines().getString(path);
	}

	public static Object get(String path) {
		return getMines().get(path);
	}

	public static ItemStack getItemStack(String path) {
		return getMines().getItemStack(path);
	}

	public static void setMines(String path, Object obj) {
		getMines().set(path, obj);
		saveMines();
		reloadMines();
	}

}
