package me.az0code.customlocate;

import org.bukkit.Bukkit;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;

public class CustomLocate extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        String pluginFolderPath = getConfig().getString("custom-plugin-folder", "plugins_custom");
        File pluginFolder = new File(pluginFolderPath);

        if (!pluginFolder.exists()) {
            if (!pluginFolder.mkdirs()) {
                getLogger().log(Level.SEVERE, "Failed to create custom plugin folder: " + pluginFolder.getPath());
            }
        }

        loadCustomPlugins(pluginFolder);
    }

    private void loadCustomPlugins(File folder) {
        if (folder == null || !folder.isDirectory()) {
            return;
        }

        File[] files = folder.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".jar")) {
                try {
                    Plugin plugin = Bukkit.getPluginManager().loadPlugin(file);
                    if (plugin != null) {
                        plugin.onLoad();
                        Bukkit.getPluginManager().enablePlugin(plugin);
                        getLogger().log(Level.INFO, "Loaded custom plugin: " + plugin.getDescription().getName());
                    }
                } catch (InvalidDescriptionException | InvalidPluginException e) {
                    getLogger().log(Level.SEVERE, "Failed to load plugin from " + file.getPath(), e);
                }
            }
        }
    }
}