package com.novur.virtualenchanting;

import com.novur.virtualenchanting.handler.UtilityHandler;
import com.novur.virtualenchanting.handler.VEHandler;
import com.novur.virtualenchanting.listener.etable.AddLapisHandler;
import com.novur.virtualenchanting.listener.etable.EnchantTableClose;
import com.novur.virtualenchanting.listener.etable.RemoveLapisHandler;
import com.novur.virtualenchanting.listener.etable.ResupplyLapisHandler;
import com.novur.virtualenchanting.listener.gui.ClickEnchantmentTable;
import com.novur.virtualenchanting.listener.gui.GUIClickEvent;
import com.novur.virtualenchanting.listener.gui.GUIDrag;
import me.bukkit.mTokens.Inkzzz.API.MySQLTokensAPI;
import me.bukkit.mTokens.Inkzzz.Tokens;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class VirtualEnchanting extends JavaPlugin {
    private VirtualEnchanting instance;
    private UtilityHandler utilityHandler;
    private VEHandler veHandler;
    private MySQLTokensAPI tokensAPI;

    @Override
    public void onEnable() {

        if(!pointsAPIEnabled()) {
            Bukkit.getPluginManager().disablePlugin(this);
            getLogger().warning("Disabling due to no MySQL-Tokens dependency!");
        }

        instance = this;

        tokensAPI = Tokens.getInstance().getAPI();

        utilityHandler = new UtilityHandler(instance);
        veHandler = new VEHandler(instance);

        getServer().getPluginManager().registerEvents(new AddLapisHandler(instance), this);
        getServer().getPluginManager().registerEvents(new EnchantTableClose(instance), this);
        getServer().getPluginManager().registerEvents(new RemoveLapisHandler(instance), this);
        getServer().getPluginManager().registerEvents(new ResupplyLapisHandler(instance), this);

        getServer().getPluginManager().registerEvents(new ClickEnchantmentTable(instance), this);
        getServer().getPluginManager().registerEvents(new GUIClickEvent(instance), this);
        getServer().getPluginManager().registerEvents(new GUIDrag(instance), this);

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

    private boolean pointsAPIEnabled() {
        return Bukkit.getPluginManager().getPlugin("MySQL-Tokens").isEnabled();
    }

    public MySQLTokensAPI getTokensAPI() {
        return tokensAPI;
    }

    public UtilityHandler getUtilityHandler() {
        return utilityHandler;
    }

    public VEHandler getVeHandler() {
        return veHandler;
    }


}
