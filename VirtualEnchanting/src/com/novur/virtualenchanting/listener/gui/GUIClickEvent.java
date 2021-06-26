package com.novur.virtualenchanting.listener.gui;

import com.novur.virtualenchanting.VirtualEnchanting;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIClickEvent implements Listener {
    private VirtualEnchanting virtualEnchanting;
    public GUIClickEvent(VirtualEnchanting virtualEnchanting) {
        this.virtualEnchanting = virtualEnchanting;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if(event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) return;

        if(!event.isCancelled()) {
            if (event.getView().getTitle().equalsIgnoreCase("Enchanting GUI")) {

                Player player = (Player) event.getWhoClicked();

                if (event.getCurrentItem().hasItemMeta() && (event.getCurrentItem().getItemMeta().hasLore())) {
                    if (virtualEnchanting.getVeHandler().getTier1Item().equals(event.getCurrentItem().getType())) {
                        if (virtualEnchanting.getVeHandler().isEnchantingTable(virtualEnchanting.getVeHandler().getTier1().getBlock())) {
                            event.setCancelled(true);
                            player.openEnchanting(virtualEnchanting.getVeHandler().getTier1(), true);
                        } else {
                            event.setCancelled(true);
                            player.sendMessage(virtualEnchanting.getUtilityHandler().color(virtualEnchanting.getConfig().getString("tableDoesNotExist")));
                        }
                    } else if (virtualEnchanting.getVeHandler().getTier2Item().equals(event.getCurrentItem().getType())) {
                        if (virtualEnchanting.getVeHandler().isEnchantingTable(virtualEnchanting.getVeHandler().getTier2().getBlock())) {
                            event.setCancelled(true);
                            player.updateInventory();
                            player.openEnchanting(virtualEnchanting.getVeHandler().getTier2(), true);
                        } else {
                            event.setCancelled(true);
                            player.sendMessage(virtualEnchanting.getUtilityHandler().color(virtualEnchanting.getConfig().getString("tableDoesNotExist")));
                        }
                    } else if (virtualEnchanting.getVeHandler().getTier3Item().equals(event.getCurrentItem().getType())) {
                        if (virtualEnchanting.getVeHandler().isEnchantingTable(virtualEnchanting.getVeHandler().getTier3().getBlock())) {
                            event.setCancelled(true);
                            player.openEnchanting(virtualEnchanting.getVeHandler().getTier3(), true);
                        } else {
                            event.setCancelled(true);
                            player.sendMessage(virtualEnchanting.getUtilityHandler().color(virtualEnchanting.getConfig().getString("tableDoesNotExist")));
                        }
                    }

                    } else {
                        event.setCancelled(true);
                    }
                }
        }
    }
}
