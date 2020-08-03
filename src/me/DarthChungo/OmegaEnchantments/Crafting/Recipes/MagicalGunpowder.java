package me.DarthChungo.OmegaEnchantments.Crafting.Recipes;

import me.DarthChungo.OmegaEnchantments.PluginMain;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

import static me.DarthChungo.OmegaEnchantments.Crafting.Items.MagicalGunpowder.MagicalGunpowderItem;

public class MagicalGunpowder {
    public static ShapedRecipe MagicalGunpowderRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(PluginMain.getInstance(), "magical_gunpowder"), MagicalGunpowderItem());
        recipe.shape("abc", "def", "ghi");

        //recipe.setIngredient('a', Material.AIR);
        recipe.setIngredient('b', Material.TNT);
        //recipe.setIngredient('c', Material.AIR);
        recipe.setIngredient('d', Material.GUNPOWDER);
        recipe.setIngredient('e', Material.ENDER_EYE);
        recipe.setIngredient('f', Material.GUNPOWDER);
        //recipe.setIngredient('g', Material.AIR);
        recipe.setIngredient('h', Material.TNT);
        //recipe.setIngredient('i', Material.AIR);

        return recipe;
    }
}
