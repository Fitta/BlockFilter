package com.github.fitta.blockfilter;

import com.github.fitta.blockfilter.cobble.CobbleHandler;
import com.github.fitta.blockfilter.cobble.CobbleListener;
import com.github.fitta.blockfilter.cobble.command.CobbleCommand;
import com.github.fitta.blockfilter.listeners.PlayerConnectionListener;

import lombok.Getter;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class BlockFilter extends JavaPlugin {

    private static BlockFilter instance;
    private CobbleHandler cobbleHandler;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        this.cobbleHandler = new CobbleHandler();

        getCommand("cobble").setExecutor(new CobbleCommand());
    }

    private void registerListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new CobbleListener(this), this);
        pluginManager.registerEvents(new PlayerConnectionListener(), this);
    }

    public static BlockFilter getInstance() {
        return instance;
    }
}
