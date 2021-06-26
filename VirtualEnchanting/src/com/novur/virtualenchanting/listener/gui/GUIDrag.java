package com.novur.virtualenchanting.listener.gui;

import com.novur.virtualenchanting.VirtualEnchanting;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;

public class GUIDrag implements Listener {
    private VirtualEnchanting virtualEnchanting;
    public GUIDrag(VirtualEnchanting virtualEnchanting) {
        this.virtualEnchanting = virtualEnchanting;
    }

    @EventHandler
    public void onDrag(InventoryDragEvent event) {
        if(event.getView().getTitle().equalsIgnoreCase("Enchanting GUI")) {
            if (!event.isCancelled()) {
                event.setCancelled(true);
            }
        }
    }
}
