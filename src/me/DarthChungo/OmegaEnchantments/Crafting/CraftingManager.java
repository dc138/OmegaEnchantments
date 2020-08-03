package me.DarthChungo.OmegaEnchantments.Crafting;

import me.DarthChungo.OmegaEnchantments.Main;
import org.bukkit.inventory.ShapedRecipe;

import javax.annotation.Nullable;
import java.util.Objects;

import static me.DarthChungo.OmegaEnchantments.Crafting.Recipes.ExplosiveBow.ExplosiveBowOneRecipe;
import static me.DarthChungo.OmegaEnchantments.Crafting.Recipes.ExplosiveBow.ExplosiveBowTwoRecipe;
import static me.DarthChungo.OmegaEnchantments.Crafting.Recipes.MagicalGunpowder.MagicalGunpowderRecipe;

public class CraftingManager {
    public static boolean RecipesMatch(@Nullable ShapedRecipe r1, ShapedRecipe r2) {
        try {
            return Objects.requireNonNull(r1).getIngredientMap().equals(r2.getIngredientMap());
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static void RegisterRecipies() {
        Main.getInstance().getServer().addRecipe(ExplosiveBowOneRecipe());
        Main.getInstance().getServer().addRecipe(ExplosiveBowTwoRecipe());
        Main.getInstance().getServer().addRecipe(MagicalGunpowderRecipe());
    }
}
