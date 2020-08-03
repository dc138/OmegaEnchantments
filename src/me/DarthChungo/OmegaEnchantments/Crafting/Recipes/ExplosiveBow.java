package me.DarthChungo.OmegaEnchantments.Crafting.Recipes;

import me.DarthChungo.OmegaEnchantments.PluginMain;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

import static me.DarthChungo.OmegaEnchantments.Crafting.Items.MagicalItem.MagicalItemItem;

public class ExplosiveBow {
    public static ShapedRecipe ExplosiveBowOneRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(PluginMain.getInstance(), "explosive_bow_one"), MagicalItemItem());
        recipe.shape("abc", "def", "ghi");

        recipe.setIngredient('a', Material.GUNPOWDER);
        recipe.setIngredient('b', Material.GOLD_BLOCK);
        recipe.setIngredient('c', Material.GUNPOWDER);
        recipe.setIngredient('d', Material.ENDER_PEARL);
        recipe.setIngredient('e', Material.BOW);
        recipe.setIngredient('f', Material.ENDER_PEARL);
        recipe.setIngredient('g', Material.GUNPOWDER);
        recipe.setIngredient('h', Material.GOLD_BLOCK);
        recipe.setIngredient('i', Material.GUNPOWDER);

        return recipe;
    }

    public static ShapedRecipe ExplosiveBowTwoRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(PluginMain.getInstance(), "explosive_bow_two"), MagicalItemItem());
        recipe.shape("abc", "def", "ghi");

        recipe.setIngredient('a', Material.TNT);
        recipe.setIngredient('b', Material.DIAMOND_BLOCK);
        recipe.setIngredient('c', Material.TNT);
        recipe.setIngredient('d', Material.BLAZE_ROD);
        recipe.setIngredient('e', Material.BOW);
        recipe.setIngredient('f', Material.BLAZE_ROD);
        recipe.setIngredient('g', Material.TNT);
        recipe.setIngredient('h', Material.DIAMOND_BLOCK);
        recipe.setIngredient('i', Material.TNT);

        return recipe;
    }
}
