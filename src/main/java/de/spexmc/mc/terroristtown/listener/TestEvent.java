package de.spexmc.mc.terroristtown.listener;

import de.spexmc.mc.terroristtown.util.mcutils.PlayerScoreboard;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Lara on 26.02.2019 for terroristtown
 */
public class TestEvent implements Listener {

  @EventHandler
  public void onEvent(PlayerJoinEvent joinEvent) {
    new PlayerScoreboard(joinEvent.getPlayer()).show();
  }
}
