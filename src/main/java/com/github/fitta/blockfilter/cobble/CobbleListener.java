package com.github.fitta.blockfilter.cobble;

import com.github.fitta.blockfilter.BlockFilter;
import com.github.fitta.blockfilter.cobble.listeners.BlockListener;
import com.github.fitta.blockfilter.cobble.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

public class CobbleListener implements Listener {

    public CobbleListener(BlockFilter plugin) {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new BlockListener(), plugin);
        pluginManager.registerEvents(new PlayerListener(), plugin);
    }

}