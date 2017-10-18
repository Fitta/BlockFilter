package com.github.fitta.blockfilter;

import org.bukkit.plugin.java.JavaPlugin;

public class BlockFilter extends JavaPlugin {

    public static BlockFilter instance;

    @Override
    public void onEnable() {
        instance = this;

    }

    public BlockFilter getInstance() {
        return instance;
    }
}
