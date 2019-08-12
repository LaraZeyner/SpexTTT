package de.spexmc.mc.terroristtown.gameplay;

import de.spexmc.mc.terroristtown.model.TTTPlayer;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * Created by Lara on 11.08.2019 for SpexTTT
 */
public final class DamageManager {

  public static void onArrow(EntityDamageByEntityEvent damageByEntityEvent) {
    if (damageByEntityEvent.getDamager() instanceof Arrow) {
      final Arrow arrow = (Arrow) damageByEntityEvent.getDamager();
      if (arrow.getShooter() instanceof Player) {
        final Player arrowShooter = (Player) arrow.getShooter();
        final TTTPlayer arrowShooterTTTPlayer = TTTPlayer.determine(arrowShooter);
        final Player target = (Player) damageByEntityEvent.getEntity();
        final TTTPlayer targetTTTPlayer = TTTPlayer.determine(target);

        if (arrowShooterTTTPlayer.getRole().equals(targetTTTPlayer.getRole())) {
          damageByEntityEvent.setCancelled(true);
        }
      }
    }
  }
}
