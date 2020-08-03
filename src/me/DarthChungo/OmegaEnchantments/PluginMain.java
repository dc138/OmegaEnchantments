package me.DarthChungo.OmegaEnchantments;

import me.DarthChungo.OmegaEnchantments.Crafting.CraftingManager;
import me.DarthChungo.OmegaEnchantments.Enchantments.EnchantmentManager;
import me.DarthChungo.OmegaEnchantments.Events.EventManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginMain extends JavaPlugin implements Listener {
    public static PluginMain getInstance() { return (PluginMain) Bukkit.getPluginManager().getPlugin("OmegaEnchantments"); }
    public static int log(String message) { return getInstance().getServer().broadcastMessage(message);  }

    @Override
    public void onEnable() {
        EnchantmentManager.RegisterEnchantments();
        CraftingManager.RegisterRecipies();
        EventManager.RegisterEvents();

        this.getLogger().info("OmegaEnchantments by DarthChungo enabled.");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("OmegaEnchantments by DarthChungo disabled.");
    }
}
