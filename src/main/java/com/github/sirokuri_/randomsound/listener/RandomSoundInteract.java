package com.github.sirokuri_.randomsound.listener;

import com.github.sirokuri_.randomsound.RandomSound;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class RandomSoundInteract implements Listener {

    private final RandomSound plugin;

    public RandomSoundInteract(RandomSound randomSound) {
        this.plugin = randomSound;
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Sound sound = plugin.getRandomSound();
        Location location = player.getLocation();
        World world = location.getWorld();
        if (world == null) return;
        if (world.getName().equals("RhythmWorld")){
            Random random = new Random();
            int randomValue = random.nextInt(10000);
            if ((event.getHand() != EquipmentSlot.HAND || event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
            ItemStack itemStack = player.getInventory().getItemInMainHand();
            if (itemStack.getType() == Material.STICK){
                BaseComponent[] component = TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&',"&4" + sound + "&r のサウンド再生"));
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR,component);
                player.playSound(location,sound,randomValue,1);
                player.spawnParticle(Particle.NOTE,location,10,1,1,1,10);
            }
        }
    }
}