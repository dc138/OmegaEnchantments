package me.DarthChungo.OmegaEnchantments.Events;

import me.DarthChungo.OmegaEnchantments.Crafting.CraftingManager;
import me.DarthChungo.OmegaEnchantments.Enchantments.EnchantmentManager;
import me.DarthChungo.OmegaEnchantments.PluginMain;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

import static me.DarthChungo.OmegaEnchantments.Crafting.Recipes.ExplosiveBow.ExplosiveBowOneRecipe;
import static me.DarthChungo.OmegaEnchantments.Crafting.Recipes.ExplosiveBow.ExplosiveBowTwoRecipe;
import static me.DarthChungo.OmegaEnchantments.Crafting.Recipes.MagicalGunpowder.MagicalGunpowderRecipe;

public class Inventory implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onInventoryClick(InventoryClickEvent event) {
        if(event.getInventory().getType() == InventoryType.GRINDSTONE) {
            if(event.getSlot() == 0 || event.getSlot() == 1) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if(!(Objects.equals(event.getInventory().getItem(0), new ItemStack(Material.AIR))
                                || Objects.equals(event.getInventory().getItem(1), new ItemStack(Material.AIR)))) {
                            ItemStack item = event.getInventory().getItem(2);
                            if(item == null) { return; }

                            ItemMeta itemMeta = item.getItemMeta();
                            assert itemMeta != null;
                            itemMeta.setLore(null);

                            Objects.requireNonNull(event.getInventory().getItem(2)).setItemMeta(itemMeta);
                        }
                    }
                }.runTask(PluginMain.getInstance());
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onCraftItem(CraftItemEvent event) {
        Player player = (Player)event.getView().getPlayer();
        CraftingInventory inv = event.getInventory();

        if(CraftingManager.RecipesMatch((ShapedRecipe)event.getRecipe(), ExplosiveBowOneRecipe())) {
            ItemStack bow = Objects.requireNonNull(inv.getItem(5)).clone();

            if(EnchantmentManager.GetEnchantment(bow, EnchantmentManager.BOW_EXPLOSIVE) != 0) {
                inv.setResult(new ItemStack(Material.AIR));
                event.setCancelled(true);

                player.sendMessage("§7This bow has §5§lincompatible §r§7enchantments.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                player.closeInventory();

                return;
            }

            EnchantmentManager.AddEnchantment(bow, EnchantmentManager.BOW_EXPLOSIVE, 1);
            inv.setResult(bow);

            player.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1, 1);
            player.sendMessage("§7You crafted an §5§lEXPLOSIVE BOW I§r§7.");
            player.sendMessage( "§7This bow will require §5§lMAGICAL GUNPOWDER §r§7to fire explosive arrows.");

        } else if(CraftingManager.RecipesMatch((ShapedRecipe)event.getRecipe(), ExplosiveBowTwoRecipe())) {
            ItemStack bow = Objects.requireNonNull(inv.getItem(5)).clone();

            if(EnchantmentManager.GetEnchantment(bow, EnchantmentManager.BOW_EXPLOSIVE) != 1) {
                inv.setResult(new ItemStack(Material.AIR));
                event.setCancelled(true);

                player.sendMessage("§7You must use an §5§lEXPLOSIVE BOW I§r§7.");
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                player.closeInventory();

                return;
            }

            EnchantmentManager.AddEnchantment(bow, EnchantmentManager.BOW_EXPLOSIVE, 2);
            inv.setResult(bow);

            player.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1, 1);
            player.sendMessage( "§7You crafted an §5§lEXPLOSIVE BOW II§r§7.");
            player.sendMessage( "§7This bow will require §5§lMAGICAL GUNPOWDER §r§7to fire explosive arrows.");

        } else if(CraftingManager.RecipesMatch((ShapedRecipe)event.getRecipe(), MagicalGunpowderRecipe())) {
            player.playSound(player.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1, 1);
            player.sendMessage( "§7You crafted some §5§lMAGICAL GUNPOWDER§r§7.");
            player.sendMessage( "§7This item is used to shoot §5§lEXPLOSIVE ARROWS§r§7.");
        }
    }
}
