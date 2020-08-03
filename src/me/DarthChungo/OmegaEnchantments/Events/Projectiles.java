package me.DarthChungo.OmegaEnchantments.Events;

import me.DarthChungo.OmegaEnchantments.Enchantments.EnchantmentManager;
import me.DarthChungo.OmegaEnchantments.Main;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.metadata.FixedMetadataValue;

import static me.DarthChungo.OmegaEnchantments.Crafting.Items.MagicalGunpowder.MagicalGunpowderItem;

public class Projectiles implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onEntityShootBow(EntityShootBowEvent event) {
        if (!(event.getEntity() instanceof Player)) { return; }
        if (!(event.getProjectile() instanceof Arrow)) { return; }
        PlayerInventory inv = ((Player) event.getEntity()).getInventory();
        Arrow proj = (Arrow) event.getProjectile();

        if(EnchantmentManager.GetEnchantment(event.getBow(), EnchantmentManager.BOW_EXPLOSIVE) == 1) {
            for(ItemStack item : inv.getContents()) {
                if(item == null) continue;

                if(item.isSimilar(MagicalGunpowderItem())) {
                    proj.setMetadata("bow_explosive_level", new FixedMetadataValue(Main.getInstance(), 1));
                    proj.setColor(Color.SILVER);

                    item.setAmount(item.getAmount() - 1);
                    return;
                }
            }

        } else if(EnchantmentManager.GetEnchantment(event.getBow(), EnchantmentManager.BOW_EXPLOSIVE) == 2) {
            for(ItemStack item : inv.getContents()) {
                if(item == null) continue;

                if(item.isSimilar(MagicalGunpowderItem())) {
                    proj.setMetadata("bow_explosive_level", new FixedMetadataValue(Main.getInstance(), 2));
                    proj.setColor(Color.TEAL);

                    item.setAmount(item.getAmount() - 1);
                    return;
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onProjectileHit(ProjectileHitEvent event) {
        if(!(event.getEntity() instanceof Arrow)) { return; }
        if(event.getEntity().getMetadata("bow_explosive_level").size() == 0) { return; }

        Location loc = null;
        Arrow arrow = (Arrow) event.getEntity();

        if(event.getHitBlock() != null) {
            loc = event.getHitBlock().getLocation();

        } else if(event.getHitEntity() != null) {
            loc = event.getHitEntity().getLocation();
        } else {
            return;
        }

        if(arrow.getMetadata("bow_explosive_level").get(0).asInt() == 1) {
            arrow.getWorld().createExplosion(loc, 6, false, false/*, (Entity) arrow.getShooter()*/);

        } else if(arrow.getMetadata("bow_explosive_level").get(0).asInt() == 2) {
            arrow.getWorld().createExplosion(loc, 4, true, true/*, (Entity) arrow.getShooter()*/);
        }

        arrow.remove();
    }
}
