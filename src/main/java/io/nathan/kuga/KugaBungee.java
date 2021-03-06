package io.nathan.kuga;

import io.nathan.kuga.manager.LibraryManager;
import io.nathan.kuga.manager.LoadBalancing;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class KugaBungee extends Plugin {

    private Configuration config;
    private LoadBalancing loadBalancing;

    @Override
    public void onLoad() {

        try {
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        new LibraryManager().initialize();
        super.onLoad();
    }

    @Override
    public void onEnable() {
        Kuga.getPlugin().out("  _  __                        \n" +
                " | |/ /  _   _    __ _    __ _ \n" +
                " | ' /  | | | |  / _` |  / _` |\n" +
                " | . \\  | |_| | | (_| | | (_| |\n" +
                " |_|\\_\\  \\__,_|  \\__, |  \\__,_|\n" +
                "                 |___/         ");
        Kuga.getPlugin().out("Kuga : Start on the version v "+config.getString("kuga.version")+" .");
        Kuga.getPlugin().out("Kuga :           Github : https://github.com/EllSupreme/Kuga              ");
        if (config.getBoolean("kuga.autoStart")) {
            this.loadBalancing.start();
        }
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public Configuration getConfig() {
        return config;
    }
}
