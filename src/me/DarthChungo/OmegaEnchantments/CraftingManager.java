package me.DarthChungo.OmegaEnchantments;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class CraftingManager {
    public static ShapedRecipe ExplosiveBowOne() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(Main.getInstance(), "explosive_bow_one"), new ItemStack(Material.BOW));
        recipe.shape("$@$", "&?&", "$@$");

        recipe.setIngredient('$', Material.TNT);
        recipe.setIngredient('@', Material.DIAMOND_BLOCK);
        recipe.setIngredient('&', Material.GOLD_BLOCK);
        recipe.setIngredient('?', Material.BOW);

        return recipe;
    }

    public static void RegisterRecipies() {
        Main.getInstance().getServer().addRecipe(ExplosiveBowOne());
    }
}
