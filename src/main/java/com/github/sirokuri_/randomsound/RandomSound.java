package com.github.sirokuri_.randomsound;

import com.github.sirokuri_.randomsound.listener.RandomSoundJoin;
import org.bukkit.plugin.java.JavaPlugin;

public final class RandomSound extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new RandomSoundJoin(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
