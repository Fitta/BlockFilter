package com.github.fitta.blockfilter.listeners;

import com.github.fitta.blockfilter.BlockFilter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnectionListener implements Listener {

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (BlockFilter.getInstance().getCobbleHandler().getDisabled().contains(player)) {
            BlockFilter.getInstance().getCobbleHandler().getDisabled().remove(player);
        }
    }

    @EventHandler
    public void onPlayerKicked(PlayerKickEvent event) {
        Player player = event.getPlayer();

        if (BlockFilter.getInstance().getCobbleHandler().getDisabled().contains(player)) {
            BlockFilter.getInstance().getCobbleHandler().getDisabled().remove(player);
        }
    }

}