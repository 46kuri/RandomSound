package com.github.sirokuri_.randomsound.listener;

import com.github.sirokuri_.randomsound.RandomSound;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class RandomSoundInteract implements Listener {

    private final RandomSound plugin;

    public RandomSoundInteract(RandomSound randomSound) {
        this.plugin = randomSound;
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        Sound sound = plugin.getRandomSound();
        Location location = player.getLocation();
        if(!(block.getType() == Material.AIR)){
            player.playSound(location,sound,10,1);
        }
    }
}
