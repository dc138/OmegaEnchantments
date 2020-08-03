package me.DarthChungo.OmegaEnchantments.Crafting.Items;

import me.DarthChungo.OmegaEnchantments.Enchantments.EnchantmentManager;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MagicalGunpowder {
    public static ItemStack MagicalGunpowderItem() {
        ItemStack result = new ItemStack(Material.REDSTONE);

        ItemMeta result_meta = result.getItemMeta();
        assert result_meta != null;

        List<String> result_lore = new ArrayList<>();

        result_lore.add("");
        result_lore.add("§7For use with");
        result_lore.add("§5§lexplosive bows§r§7.");
        result_lore.add("");

        result_meta.addEnchant(EnchantmentManager.ALL_GLOW, 1, true);
        result_meta.setDisplayName("§d| §5§lMAGICAL GUNPOWDER §r§d|");

        result_meta.setLore(null);
        result_meta.setLore(result_lore);
        result.setItemMeta(result_meta);

        return result;
    }
}
