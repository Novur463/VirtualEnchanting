package com.novur.virtualenchanting.listener.etable;

import com.novur.virtualenchanting.VirtualEnchanting;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.inventory.ItemStack;

public class AddLapisHandler implements Listener {
    private VirtualEnchanting virtualEnchanting;
    public AddLapisHandler(VirtualEnchanting virtualEnchanting) {
        this.virtualEnchanting = virtualEnchanting;
    }

    @EventHandler
    public void onEnchantingTableOpen(InventoryOpenEvent event) {
        if(event.getInventory() instanceof EnchantingInventory) {
            EnchantingInventory enchantingInventory = (EnchantingInventory)event.getInventory();

            ItemStack lapis = new ItemStack(Material.LAPIS_LAZULI, 3);

            enchantingInventory.setItem(1, lapis);
        }
    }
}
