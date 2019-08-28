package de.spexmc.mc.terroristtown.listener;

import de.spexmc.mc.terroristtown.storage.Const;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

/**
 * Created by Lara on 11.08.2019 for SpexTTT
 * @see org.bukkit.event.player.PlayerDropItemEvent
 * @see org.bukkit.event.player.PlayerPickupItemEvent
 */
public class ItemEvents implements Listener {
  @EventHandler
  public void onPickupItem(PlayerPickupItemEvent e) {
    e.setCancelled(true);
  }

  @EventHandler
  public void onDrop(PlayerDropItemEvent e) {
    final Material type = e.getItemDrop().getItemStack().getType();
    if (!Const.DROPABLE_MATERIALS.contains(type)) {
      e.setCancelled(true);
    }
  }
}
