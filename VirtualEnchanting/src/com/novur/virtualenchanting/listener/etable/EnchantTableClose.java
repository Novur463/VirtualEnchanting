package com.novur.virtualenchanting.listener.etable;

import com.novur.virtualenchanting.VirtualEnchanting;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.EnchantingInventory;

public class EnchantTableClose implements Listener {
    private VirtualEnchanting virtualEnchanting;
    public EnchantTableClose(VirtualEnchanting virtualEnchanting) {
        this.virtualEnchanting = virtualEnchanting;
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        if(event.getInventory() instanceof EnchantingInventory) {
            if(event.getInventory().getItem(1) != null) {
                event.getInventory().setItem(1, null);
            }
        }
    }


}
