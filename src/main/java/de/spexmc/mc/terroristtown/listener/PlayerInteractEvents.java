package de.spexmc.mc.terroristtown.listener;

import de.spexmc.mc.terroristtown.model.TTTPlayer;
import de.spexmc.mc.terroristtown.storage.Const;
import de.spexmc.mc.terroristtown.util.Messenger;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Lara on 11.08.2019 for SpexTTT
 *
 * @see org.bukkit.event.entity.EntityDamageByEntityEvent
 * @see org.bukkit.event.entity.EntityDamageEvent
 * @see org.bukkit.event.player.AsyncPlayerChatEvent
 * @see org.bukkit.event.player.PlayerArmorStandManipulateEvent;
 * @see org.bukkit.event.player.PlayerInteractAtEntityEvent;
 * @see org.bukkit.event.player.PlayerInteractEntityEvent;
 * @see org.bukkit.event.player.PlayerInteractEvent;
 * @see org.bukkit.inventory.meta.ItemMeta;
 */
public class PlayerInteractEvents implements Listener {
  @EventHandler
  public void shopItem(PlayerInteractEvent interactEvent) {
    final Player target = interactEvent.getPlayer();
    final ItemMeta shopItemMeta = target.getItemInHand().getItemMeta();
    if (shopItemMeta != null && shopItemMeta.getDisplayName().equals(Const.SHOPITEMNAME)) {
      target.performCommand("shop");
    }
  }

  @EventHandler
  public void protectFarmland(PlayerInteractEvent interactEvent) {
    if (interactEvent.getAction() == Action.PHYSICAL && interactEvent.getClickedBlock().getType() == Material.SOIL) {
      interactEvent.setCancelled(true);
    }

  }

  @EventHandler
  public void onChat(AsyncPlayerChatEvent chatEvent) {
    if (chatEvent.getMessage().startsWith("t ")) {
      final Player sender = chatEvent.getPlayer();
      final TTTPlayer tttPlayer = TTTPlayer.determine(sender);
      Messenger.sendTeamMessage(tttPlayer, chatEvent.getMessage().substring(2));
    }
  }

  @EventHandler
  public void onArmorStandBreak(EntityDamageByEntityEvent event) {
    final Entity damaged = event.getEntity();
    if (damaged instanceof ArmorStand) {
      if (event.getCause().equals(EntityDamageEvent.DamageCause.PROJECTILE)) {
        final Arrow arrow = (Arrow) event.getDamager();
        if (arrow.getShooter() instanceof Player) {
          event.setCancelled(true);
        }
      }
      if (event.getDamager() instanceof Player) {
        event.setCancelled(true);
      }
    }
  }

  @EventHandler
  public void onInteractEntity(PlayerInteractEntityEvent interactEntityEvent) {
    interactEntityEvent.setCancelled(true);
  }

  @EventHandler
  public void onInteractAtEntity(PlayerInteractAtEntityEvent interactAtEntityEvent) {
    interactAtEntityEvent.setCancelled(true);
  }

  @EventHandler
  public void onArmorStandManipulate(PlayerArmorStandManipulateEvent e) {
    e.setCancelled(true);
  }

}
