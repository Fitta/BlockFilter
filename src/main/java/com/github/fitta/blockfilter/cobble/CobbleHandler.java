package com.github.fitta.blockfilter.cobble;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

@Getter
public class CobbleHandler {

    private final Set<Player> disabled;

    public CobbleHandler() {
        disabled = new HashSet<>();
    }

}