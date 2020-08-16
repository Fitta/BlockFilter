package com.github.fitta.blockfilter.cobble.command;

import com.github.fitta.blockfilter.BlockFilter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CobbleCommand implements CommandExecutor {

    private final BlockFilter instance = BlockFilter.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Players only dummy");
            return true;
        }

        if (sender.hasPermission("blockfilter.command.cobble")) {
            sender.sendMessage(instance.getConfig().getString("MESSAGES.NO_PERMISSION"));
            return true;
        }

        Player player = ((Player) sender).getPlayer();

        if (instance.getCobbleHandler().getDisabled().contains(player)) {
            instance.getCobbleHandler().getDisabled().remove(player);
            player.sendMessage(instance.getConfig().getString("MESSAGES.COBBLE.DISABLED_PICKUP"));
            return true;
        }

        instance.getCobbleHandler().getDisabled().add(player);
        player.sendMessage(instance.getConfig().getString("MESSAGES.COBBLE.ENABLED_PICKUP"));
        return false;
    }

}