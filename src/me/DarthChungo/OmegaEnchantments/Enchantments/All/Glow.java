package me.DarthChungo.OmegaEnchantments.Enchantments.All;

import me.DarthChungo.OmegaEnchantments.Enchantments.CustomEnchantment;
import me.DarthChungo.OmegaEnchantments.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class Glow extends CustomEnchantment {
    public Glow() {
        super(new NamespacedKey(Main.getInstance(), "glow"));
    }

    @Override
    public EnchantmentTarget getItemTarget() { return EnchantmentTarget.ALL; }
    @Override
    public boolean canEnchantItem(ItemStack itemStack) { return true; }
    @Override
    public int getMaxLevel() { return 1; }
    @Override
    public String getName() { return "Glow"; }
    @Override
    public NamespacedKey getKey() { return new NamespacedKey(Main.getInstance(), "glow"); }
}
