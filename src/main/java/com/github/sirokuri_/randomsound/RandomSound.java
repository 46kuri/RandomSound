package com.github.sirokuri_.randomsound;

import com.github.sirokuri_.randomsound.listener.RandomSoundInteract;
import com.github.sirokuri_.randomsound.listener.RandomSoundJoin;
import org.bukkit.Sound;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class RandomSound extends JavaPlugin {

    private final List<Sound> soundList = Arrays.asList(Sound.values().clone());
    private final Random rand = new Random();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new RandomSoundJoin(this), this);
        getServer().getPluginManager().registerEvents(new RandomSoundInteract(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public Sound getRandomSound(){
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
