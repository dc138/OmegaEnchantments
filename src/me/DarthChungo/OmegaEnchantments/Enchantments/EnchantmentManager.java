package me.DarthChungo.OmegaEnchantments.Enchantments;

import me.DarthChungo.OmegaEnchantments.Enchantments.Bow.Explosive;
import me.DarthChungo.OmegaEnchantments.util.RomanNumeral;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("deprecation")
public class EnchantmentManager {
    public static final CustomEnchantment BOW_EXPLOSIVE = new Explosive();

    public static void AddEnchantment(ItemStack item, Enchantment enchantment, int level) {
        if(level > enchantment.getMaxLevel()) { return; }

        ItemMeta itemMeta = Objects.requireNonNull(item.getItemMeta());
        List<String> itemLore;

        if(itemMeta.getLore() == null) {
            itemLore = new ArrayList<>();
        } else {
            itemLore = new ArrayList<>(Objects.requireNonNull(itemMeta.getLore()));
        }

        itemMeta.addEnchant(enchantment, level, true);
        itemLore.add(ChatColor.RESET + "" + ChatColor.LIGHT_PURPLE + enchantment.getName() + " " + RomanNumeral.toRoman(level));

        itemMeta.setLore(itemLore);
        item.setItemMeta(itemMeta);
    }

    public static void RegisterEnchantments() {
        try {
            Field acceptingNew = Enchantment.class.getDeclaredField("acceptingNew");
            acceptingNew.setAccessible(true);
            acceptingNew.set(null, true);
            acceptingNew.setAccessible(false);

            Enchantment.registerEnchantment(BOW_EXPLOSIVE);

            Enchantment.stopAcceptingRegistrations();
        } catch (Exception ignored) {}
    }
}
