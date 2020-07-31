package me.DarthChungo.OmegaEnchantments;

import me.DarthChungo.OmegaEnchantments.Enchantments.EnchantmentManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class EventManager implements Listener {
    public static void RegisterEvents() {
        Main.getInstance().getServer().getPluginManager().registerEvents(new EventManager(), Main.getInstance());
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        ItemStack item = new ItemStack(Material.BOW);

        EnchantmentManager.AddEnchantment(item, EnchantmentManager.BOW_EXPLOSIVE, 1);

        event.getPlayer().getInventory().addItem(item);
        event.getPlayer().updateInventory();
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onInventoryClick(InventoryClickEvent event) {
        if(event.getInventory().getType() == InventoryType.GRINDSTONE
                && event.getSlotType() != InventoryType.SlotType.QUICKBAR
                && (event.getAction() == InventoryAction.PLACE_ALL
                || event.getAction() == InventoryAction.PLACE_ONE
                || event.getAction() == InventoryAction.PLACE_SOME
                || event.getAction() == InventoryAction.HOTBAR_SWAP
                || event.getAction() == InventoryAction.SWAP_WITH_CURSOR
        )) {
            if(event.getSlot() == 0 || event.getSlot() == 1) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        ItemStack item = event.getInventory().getItem(2);
                        if(item == null) { return; }

                        ItemMeta itemMeta = item.getItemMeta();
                        assert itemMeta != null;
                        itemMeta.setLore(null);

                        Objects.requireNonNull(event.getInventory().getItem(2)).setItemMeta(itemMeta);
                    }
                }.runTask(Main.getInstance());
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onCraftItemPrepare(PrepareItemCraftEvent event) {
        Main.getInstance().getServer().broadcastMessage("test");
    }
}
