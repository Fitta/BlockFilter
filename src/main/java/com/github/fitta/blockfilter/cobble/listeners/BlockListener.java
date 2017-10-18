package com.github.fitta.blockfilter.cobble.listeners;

import com.github.fitta.blockfilter.BlockFilter;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import java.util.Arrays;

public class BlockListener implements Listener {

    @EventHandler
    public void onCobbleBreak(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
        Material material = event.getItem().getItemStack().getType();

        if (BlockFilter.getInstance().getCobbleHandler().getDisabled().contains(player)) {
            if (material.equals(Arrays.asList(Material.COBBLESTONE, Material.STONE))) {
                event.setCancelled(true);
            }
        }
    }

}
