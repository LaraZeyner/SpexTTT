package de.spexmc.mc.terroristtown.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

/**
 * Created by Lara on 11.08.2019 for SpexTTT
 */
public class BlockEvents implements Listener {
  @EventHandler
  public void onEntityExplode(EntityExplodeEvent explodeEvent) {
    final Entity eventEntity = explodeEvent.getEntity();
    if (eventEntity instanceof Creeper) {
      final Creeper creeper = (Creeper) eventEntity;
      if (creeper.getTarget() instanceof Player || eventEntity.getCustomName().equals(ChatColor.GREEN + "Creeper")) {
        explodeEvent.setCancelled(true);
      }
    }
  }

  @EventHandler
  public void onBlockBreak(BlockBreakEvent e) {
    e.setCancelled(true);
  }

  @EventHandler
  public void onBlockBreak(BlockPlaceEvent e) {
    e.setCancelled(true);
  }
}
