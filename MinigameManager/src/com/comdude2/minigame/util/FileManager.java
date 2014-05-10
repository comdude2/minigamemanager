package com.comdude2.minigame.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.comdude2.minigame.managers.MinigameManager;

public class FileManager {
	MinigameManager plugin;

	public FileManager(MinigameManager instance) {
		plugin = instance;
	}

	public class CustomConfig {
		private String name;
		private File file;
		private FileConfiguration fileConfig;

		public CustomConfig(String name) {
			this.name = name;
		}
	}

	public FileConfiguration getCustomConfig(CustomConfig config) {
		if (config.fileConfig == null) {
			reloadCustomConfig(config);
		}
		return config.fileConfig;
	}

	public void reloadCustomConfig(CustomConfig config) {
		if (config.fileConfig == null) {
			config.file = new File(plugin.getDataFolder(), config.name + ".yml");
		}
		config.fileConfig = YamlConfiguration.loadConfiguration(config.file);

		InputStream defConfigStream = plugin.getResource(config.name + ".yml");
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
			config.fileConfig.setDefaults(defConfig);
		}
	}

	public void saveCustomConfig(CustomConfig config) {
		if (config.fileConfig == null || config.file == null) {
			return;
		}
		try {
			getCustomConfig(config).save(config.file);
		} catch (IOException ex) {
			plugin.getLogger().log(Level.SEVERE, "Could not save config to " + config.file, ex);
		}
	}

	public void saveDefaultConfig(CustomConfig config) {
		if (config.file == null) {
			config.file = new File(plugin.getDataFolder(), config.name + ".yml");
		}
		if (!config.file.exists()) {
			plugin.saveResource(config.name + ".yml", false);
		}
	}
}
