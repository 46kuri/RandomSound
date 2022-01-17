package com.github.sirokuri_.randomsound.listener;

import com.github.sirokuri_.randomsound.RandomSound;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.*;

public class RandomSoundJoin implements Listener {

    private final RandomSound plugin;

    public RandomSoundJoin(RandomSound randomSound) {
        this.plugin = randomSound;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Sound sound = plugin.getRandomSound();
        Player player = event.getPlayer();
        Location location = player.getLocation();
        Timer timer = new Timer(false);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                player.playSound(location,sound,10,1);
                timer.cancel();
            }
        };
        timer.schedule(task, 7000);
    }
}
