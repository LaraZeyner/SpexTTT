package de.spexmc.mc.terroristtown.listener;

import de.spexmc.mc.terroristtown.gameplay.DamageManager;
import de.spexmc.mc.terroristtown.gameplay.EndChecker;
import de.spexmc.mc.terroristtown.gameplay.Restarter;
import de.spexmc.mc.terroristtown.model.TTTPlayer;
import de.spexmc.mc.terroristtown.storage.Data;
import de.spexmc.mc.terroristtown.util.mcutils.SchedulerImpl;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * Created by Lara on 11.08.2019 for SpexTTT
 */
public class DamageEvents implements Listener {
  @EventHandler
  public void respawnOnPlayerDeath(final PlayerDeathEvent deathEvent) {
    if (deathEvent.getEntity() != null) {
      deathEvent.getDrops().clear();
      respawn(deathEvent);

    }

    if (EndChecker.isEnd()) {
      new Restarter().invoke();
    }
  }

  private void respawn(PlayerDeathEvent deathEvent) {
    final TTTPlayer tttPlayer = TTTPlayer.determine(deathEvent.getEntity());
    new SchedulerImpl(tttPlayer) {
      @Override
      public void invoke() {
        schedule(1, () -> {
          if (getCounter() == 0) {
            deathEvent.getEntity().spigot().respawn();
            cancel();
          }
          decrement();
        });
      }
    };
  }

  @EventHandler
  public void onArrowHit(EntityDamageByEntityEvent damageByEntityEvent) {
    if (damageByEntityEvent.getDamager() instanceof Arrow) {
      final Arrow arrow = (Arrow) damageByEntityEvent.getEntity();
      arrow.remove();
      DamageManager.onArrow(damageByEntityEvent);
    }
  }

  @EventHandler
  public void PlayerRespawn(final PlayerRespawnEvent respawnEvent) {
    final Player p = respawnEvent.getPlayer();
    final Location respawnLocation = Data.getInstance().getTTTInfo().getWorld().getSpawnLocation();
    respawnEvent.setRespawnLocation(respawnLocation);

    new SchedulerImpl(TTTPlayer.determine(p)) {
      @Override
      public void invoke() {
        schedule(5, () -> {
          if (getCounter() == 0) {
            respawnEvent.getPlayer().teleport(respawnLocation);
            cancel();
          }
          decrement();
        });
      }
    };
  }

  @EventHandler
  public void onDamage(EntityDamageEvent damageEvent) {
    if (damageEvent.getEntity() instanceof Player && !Data.getInstance().getTTTInfo().isStarted()) {
      damageEvent.setCancelled(true);
    }
  }
}
