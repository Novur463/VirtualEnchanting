package com.novur.virtualenchanting.listener.etable;

import com.novur.virtualenchanting.VirtualEnchanting;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.inventory.ItemStack;

public class RemoveLapisHandler implements Listener {
    private VirtualEnchanting virtualEnchanting;
    public RemoveLapisHandler(VirtualEnchanting virtualEnchanting) {
        this.virtualEnchanting = virtualEnchanting;
    }

    @EventHandler
    public void onInteract(InventoryClickEvent event) {
        if(event.getInventory() instanceof EnchantingInventory) {

            if(event.getSlotType() == InventoryType.SlotType.CRAFTING) {
                if(!event.isCancelled()) {
                    if (event.getSlot() == 1 && event.getInventory().getItem(1) != null) {
                        ItemStack itemStack = event.getInventory().getItem(1);
                        if (itemStack.getType() == Material.LAPIS_LAZULI) {
                            event.setCancelled(true);
                            event.getWhoClicked().sendMessage(virtualEnchanting.getUtilityHandler().color(virtualEnchanting.getConfig().getString("cannotRemoveLapis")));
                        }
                    }
                }
            }
        }
    }


}
