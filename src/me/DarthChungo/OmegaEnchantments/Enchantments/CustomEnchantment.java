package me.DarthChungo.OmegaEnchantments.Enchantments;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public abstract class CustomEnchantment extends Enchantment {
    public CustomEnchantment(NamespacedKey key) {
        super(key);
    }

    public abstract EnchantmentTarget getItemTarget();
    public abstract boolean canEnchantItem(ItemStack itemStack);
    public abstract int getMaxLevel();
    public abstract String getName();
    public abstract NamespacedKey getKey();

    @Override
    public boolean conflictsWith(Enchantment enchantment) { return false; }
    @Override
    public int getStartLevel() { return 0; }
    @Override
    public boolean isTreasure() { return false; }
    @Override
    public boolean isCursed() { return false; }
}
