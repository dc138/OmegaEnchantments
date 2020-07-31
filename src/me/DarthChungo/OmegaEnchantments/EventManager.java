package me.DarthChungo.OmegaEnchantments;

import me.DarthChungo.OmegaEnchantments.Enchantments.EnchantmentManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class EventManager implements Listener {
    public EventManager() {
        Main.getInstance().getServer().getPluginManager().registerEvents(this, Main.getInstance());
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
        ))  {
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
    public void onPrepareAnvil(PrepareAnvilEvent event) {
        event.setResult(new ItemStack(Material.DIAMOND));

    }
}
