package me.DarthChungo.OmegaEnchantments.Events;

import me.DarthChungo.OmegaEnchantments.Main;

public class EventManager {
    public static void RegisterEvents() {
        Main.getInstance().getServer().getPluginManager().registerEvents(new Inventory(), Main.getInstance());
        Main.getInstance().getServer().getPluginManager().registerEvents(new Projectiles(), Main.getInstance());
    }
}
