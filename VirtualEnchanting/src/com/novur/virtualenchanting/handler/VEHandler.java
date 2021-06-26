package com.novur.virtualenchanting.handler;

import com.novur.virtualenchanting.VirtualEnchanting;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class VEHandler {
    private VirtualEnchanting virtualEnchanting;
    private Inventory inventory;
    private Location tier1, tier2, tier3;
    private Material tier1Item, tier2Item, tier3Item;
    private String tier1ItemName, tier2ItemName, tier3ItemName;
    private int tier1Amount, tier2Amount, tier3Amount;

    public VEHandler(VirtualEnchanting virtualEnchanting) {
        this.virtualEnchanting = virtualEnchanting;

        inventory = Bukkit.createInventory(null,27, "Enchanting GUI");


        tier1 = new Location(Bukkit.getWorld(virtualEnchanting.getConfig().getString("tier1.location.world")), virtualEnchanting.getConfig().getDouble("tier1.location.x"), virtualEnchanting.getConfig().getDouble("tier1.location.y"), virtualEnchanting.getConfig().getDouble("tier1.location.z"));
        tier2 = new Location(Bukkit.getWorld(virtualEnchanting.getConfig().getString("tier2.location.world")), virtualEnchanting.getConfig().getDouble("tier2.location.x"), virtualEnchanting.getConfig().getDouble("tier2.location.y"), virtualEnchanting.getConfig().getDouble("tier2.location.z"));
        tier3 = new Location(Bukkit.getWorld(virtualEnchanting.getConfig().getString("tier3.location.world")), virtualEnchanting.getConfig().getDouble("tier3.location.x"), virtualEnchanting.getConfig().getDouble("tier3.location.y"), virtualEnchanting.getConfig().getDouble("tier3.location.z"));

        tier1Item = Material.valueOf(virtualEnchanting.getConfig().getString("tier1.item.material"));
        tier2Item = Material.valueOf(virtualEnchanting.getConfig().getString("tier2.item.material"));
        tier3Item = Material.valueOf(virtualEnchanting.getConfig().getString("tier3.item.material"));

        tier1ItemName = virtualEnchanting.getConfig().getString("tier1.item.name");
        tier2ItemName = virtualEnchanting.getConfig().getString("tier2.item.name");
        tier3ItemName = virtualEnchanting.getConfig().getString("tier3.item.name");

        tier1Amount = virtualEnchanting.getConfig().getInt("tier1.item.amount");
        tier2Amount = virtualEnchanting.getConfig().getInt("tier2.item.amount");
        tier3Amount = virtualEnchanting.getConfig().getInt("tier3.item.amount");

        populateInventory();
    }

    private void populateInventory() {
        inventory.setItem(10, createItem(tier1Item,tier1Amount, tier1ItemName, virtualEnchanting.getConfig().getStringList("tier1.item.lore")));
        inventory.setItem(13, createItem(tier2Item,tier2Amount, tier2ItemName, virtualEnchanting.getConfig().getStringList("tier2.item.lore")));
        inventory.setItem(16, createItem(tier3Item,tier3Amount, tier3ItemName, virtualEnchanting.getConfig().getStringList("tier3.item.lore")));
    }

    private ItemStack createItem(final Material itemType, int amount, String itemName, final List<String> lore) {
        final ItemStack itemStack = new ItemStack(itemType);
        final ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(virtualEnchanting.getUtilityHandler().color(itemName));

        itemMeta.setLore(virtualEnchanting.getUtilityHandler().color(lore));
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemStack.setItemMeta(itemMeta);

        itemStack.setAmount(amount);
        return itemStack;
    }

    public void open(Player player) {
        player.openInventory(inventory);
    }

    public boolean isEnchantingTable(Block block) {
        return block.getType().equals(Material.ENCHANTING_TABLE);
    }

    public Location getTier1() {
        return tier1;
    }

    public Location getTier2() {
        return tier2;
    }

    public Location getTier3() {
        return tier3;
    }

    public Material getTier1Item() {
        return tier1Item;
    }

    public Material getTier2Item() {
        return tier2Item;
    }

    public Material getTier3Item() {
        return tier3Item;
    }

}
