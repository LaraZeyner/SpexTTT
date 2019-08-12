package de.spexmc.mc.terroristtown.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

/**
 * Created by Lara on 11.08.2019 for SpexTTT
 */
public class LocationChangeEvents implements Listener {
  @EventHandler
  public void onTeleport(PlayerTeleportEvent teleportEvent) {
    final Player target = teleportEvent.getPlayer();
    for (Player locationPlayer : Bukkit.getOnlinePlayers()) {
      if (locationPlayer.canSee(target)) {
        locationPlayer.showPlayer(target);
      }
    }
  }

}
