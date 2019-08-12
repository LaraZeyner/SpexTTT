package de.spexmc.mc.terroristtown.listener;

import de.spexmc.mc.terroristtown.model.TTTPlayer;
import de.spexmc.mc.terroristtown.storage.Const;
import de.spexmc.mc.terroristtown.storage.Data;
import de.spexmc.mc.terroristtown.util.objectmanager.JoinManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * Created by Lara on 11.08.2019 for SpexTTT
 */
public class ConnectionEvents implements Listener {
  @EventHandler
  public void onLogin(PlayerLoginEvent loginEvent) {
    final Player target = loginEvent.getPlayer();
    if (Data.getInstance().getTTTInfo().isStarted()) {
      new JoinManager(target).joinAsSpecator();
    } else {
      new JoinManager(target).joinAsPlayer();
    }
  }

  @EventHandler
  public void autoJoin(PlayerJoinEvent joinEvent) {
    final TTTPlayer tttPlayer = TTTPlayer.determine(joinEvent.getPlayer());
    joinEvent.getPlayer().setResourcePack(Const.TEXTUREPACK);
  }

}
