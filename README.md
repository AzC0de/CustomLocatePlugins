[![](https://img.shields.io/badge/License-GPLv3-orange.svg)](https://choosealicense.com/licenses/gpl-3.0/)

# CustomLocatePlugins

CustomPluginLoader is a plugin for Spigot that allows plugins to be loaded from a custom location set in the config file.yml. This plugin is ideal for server administrators who want to maintain a common configuration and plugins on multiple Minecraft servers, without having to duplicate the files on each server instance.

### Functionality
- Loading plugins from a custom location on the file system.
- It allows the use of the same plugin configuration for different servers.
- It facilitates the management of plugins in environments with multiple servers.
###

### Advantage
- Saving disk space by avoiding duplication of plugin files on multiple servers.
- Easier to keep the plugins updated on all servers.
- Centralized management of plugin configuration, which facilitates the implementation of changes on all servers at once.
###

### Usage
1. Install CustomPluginLoader in the "plugins" folder of your Spigot server.
2. Edit the "config.yml" in the CustomPluginLoader folder inside the plugins folder.
3. Set the custom path to load plugins in the custom-plugin-folder option. For example, /ruta/aqui.
4. Place the plugins files (in JAR format) in the custom folder specified in the config.yml.
5. Restart your Spigot server so that CustomPluginLoader loads the plugins from the custom location.
###
