package com.novur.virtualenchanting.listener.etable;

import com.novur.virtualenchanting.VirtualEnchanting;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class ResupplyLapisHandler implements Listener {
    private VirtualEnchanting virtualEnchanting;

    public ResupplyLapisHandler(VirtualEnchanting virtualEnchanting) {
        this.virtualEnchanting = virtualEnchanting;
    }

    @EventHandler
    public void onEnchant(EnchantItemEvent event) {
        if (!event.isCancelled()) {

            Player player = event.getEnchanter();
            int amount = event.getExpLevelCost();

            int tokenAmount = 0;

            if(amount <= 10) {
                tokenAmount = 5;
            } else if(amount <= 20) {
                tokenAmount = 10;
            } else if(amount <=30) {
                tokenAmount = 20;
            }

            if ((virtualEnchanting.getTokensAPI().getTokens(player) - tokenAmount) >= 0) {
                virtualEnchanting.getTokensAPI().takeTokens(event.getEnchanter(), tokenAmount);

                ItemStack itemStack = new ItemStack(Material.LAPIS_LAZULI, 3);

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        event.getInventory().setItem(1, itemStack);
                    }
                }.runTaskLater(virtualEnchanting, 1L);

                event.getEnchanter().sendMessage(virtualEnchanting.getUtilityHandler().color(virtualEnchanting.getConfig().getString("pointsTaken").replace("{pointsTaken}", String.valueOf(tokenAmount))));
            } else {
                event.getEnchanter().sendMessage(virtualEnchanting.getUtilityHandler().color(virtualEnchanting.getConfig().getString("couldNotAfford").replace("{pointAmount}", String.valueOf(tokenAmount))));
                event.setCancelled(true);
            }

        }

    }
}
