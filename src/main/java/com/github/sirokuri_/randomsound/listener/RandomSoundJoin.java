package com.github.sirokuri_.randomsound.listener;

import com.github.sirokuri_.randomsound.RandomSound;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.*;

public class RandomSoundJoin implements Listener {

    private final List<Sound> soundList = Arrays.asList(Sound.values().clone());
    private final Random rand = new Random();
    private final RandomSound plugin;

    public RandomSoundJoin(RandomSound randomSound) {
        this.plugin = randomSound;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Sound sound = getRandomSound();
        Player player = event.getPlayer();
        Location location = player.getLocation();
        Timer timer = new Timer(false);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                player.playSound(location,sound,3,1);
                timer.cancel();
            }
        };
        timer.schedule(task, 7000);
    }

    private Sound getRandomSound(){
        Sound sound = null;
        if(isValidItem(sound)) {
           sound = soundList.get(rand.nextInt(soundList.size()));
        }
        return sound;
    }

    private final List<Sound> invalids = Arrays.asList(Sound.ENTITY_SPIDER_AMBIENT,Sound.ENTITY_SPIDER_STEP);

    private boolean isValidItem(Sound sound) {
        return !invalids.contains(sound);
    }
}
