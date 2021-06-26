package com.novur.virtualenchanting.listener.gui;

import com.novur.virtualenchanting.VirtualEnchanting;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ClickEnchantmentTable implements Listener {
    private VirtualEnchanting virtualEnchanting;
    public ClickEnchantmentTable(VirtualEnchanting virtualEnchanting) {
        this.virtualEnchanting = virtualEnchanting;
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if(!event.isCancelled()) {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK && (event.getClickedBlock().getType() == Material.ENCHANTING_TABLE)) {
                event.setCancelled(true);
                virtualEnchanting.getVeHandler().open(event.getPlayer());
            }
        }
    }
}
