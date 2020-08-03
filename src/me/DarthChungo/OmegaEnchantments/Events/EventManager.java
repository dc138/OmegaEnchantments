package me.DarthChungo.OmegaEnchantments.Events;

import me.DarthChungo.OmegaEnchantments.PluginMain;

public class EventManager {
    public static void RegisterEvents() {
        PluginMain.getInstance().getServer().getPluginManager().registerEvents(new Inventory(), PluginMain.getInstance());
        PluginMain.getInstance().getServer().getPluginManager().registerEvents(new Projectiles(), PluginMain.getInstance());
    }
}
