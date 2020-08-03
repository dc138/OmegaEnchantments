package me.DarthChungo.OmegaEnchantments.Enchantments.Bow;

import me.DarthChungo.OmegaEnchantments.Enchantments.CustomEnchantment;
import me.DarthChungo.OmegaEnchantments.PluginMain;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class Explosive extends CustomEnchantment {
    public Explosive() {
        super(new NamespacedKey(PluginMain.getInstance(), "explosive"));
    }

    @Override
    public EnchantmentTarget getItemTarget() { return EnchantmentTarget.BOW; }
    @Override
    public boolean canEnchantItem(ItemStack itemStack) { return true; }
    @Override
    public int getMaxLevel() { return 2; }
    @Override
    public String getName() { return "Explosive"; }
    @Override
    public NamespacedKey getKey() { return new NamespacedKey(PluginMain.getInstance(), "explosive"); }
}
