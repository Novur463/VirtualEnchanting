package com.novur.virtualenchanting.handler;

import com.novur.virtualenchanting.VirtualEnchanting;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class UtilityHandler {
    private VirtualEnchanting virtualEnchanting;
    public UtilityHandler(VirtualEnchanting virtualEnchanting) {
        this.virtualEnchanting = virtualEnchanting;
    }

    public String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public List<String> color(List<String> string) {
        List<String> colorList = new ArrayList<>();
        for(String s : string) {
            colorList.add(color(s));
        }
        return colorList;
    }
}
