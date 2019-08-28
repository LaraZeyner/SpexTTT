package de.spexmc.mc.terroristtown.listener;

import de.spexmc.mc.terroristtown.storage.Const;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

/**
 * Created by Lara on 11.08.2019 for SpexTTT
 *
 * @see org.bukkit.event.entity.FoodLevelChangeEvent
 * @see org.bukkit.event.player.PlayerGameModeChangeEvent
 */
public class PlayerStatusChangeEvents implements Listener {
  @EventHandler
  public void onGM(PlayerGameModeChangeEvent gameModeChangeEvent) {
    if (Const.HIDESPECS) {
      Bukkit.getOnlinePlayers().forEach(gameModeChangeEvent.getNewGameMode().equals(GameMode.SPECTATOR) ?
          (target -> target.hidePlayer(gameModeChangeEvent.getPlayer())) :
          (target -> target.showPlayer(gameModeChangeEvent.getPlayer())));
    }
  }

  @EventHandler
  public void onFoodLevelChange(FoodLevelChangeEvent foodLevelChangeEvent) {
    foodLevelChangeEvent.setCancelled(true);
  }
}
