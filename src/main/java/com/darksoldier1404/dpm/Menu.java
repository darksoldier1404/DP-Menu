package com.darksoldier1404.dpm;

import com.darksoldier1404.dpm.commands.DPMCommand;
import com.darksoldier1404.dpm.events.DPMEvent;
import com.darksoldier1404.dpm.functions.DPMFunction;
import com.darksoldier1404.dppc.utils.DataContainer;
import com.darksoldier1404.dppc.utils.PluginUtil;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class Menu extends JavaPlugin {
    private static Menu plugin;
    public static DataContainer data;
    public static final Map<String, YamlConfiguration> menus = new HashMap<>();

    public static Menu getInstance() {
        return plugin;
    }

    @Override
    public void onLoad() {
        plugin = this;
        PluginUtil.addPlugin(plugin, 26570);
    }

    @Override
    public void onEnable() {
        plugin = this;
        data = new DataContainer(plugin, true);
        plugin.getServer().getPluginManager().registerEvents(new DPMEvent(), plugin);
        getCommand("dpm").setExecutor(new DPMCommand().getExecuter());
        DPMFunction.loadAllMenus();
    }

    @Override
    public void onDisable() {
        data.save();
    }
}
