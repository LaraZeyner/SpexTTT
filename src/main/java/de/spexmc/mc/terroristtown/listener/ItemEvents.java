package de.spexmc.mc.terroristtown.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

/**
 * Created by Lara on 11.08.2019 for SpexTTT
 */
public class ItemEvents implements Listener {
  @EventHandler
  public void onPickupItem(PlayerPickupItemEvent e) {
    e.setCancelled(true);
  }

  @EventHandler
  public void onArmorStandManipulate(PlayerArmorStandManipulateEvent e) {
    e.setCancelled(true);
  }
}
