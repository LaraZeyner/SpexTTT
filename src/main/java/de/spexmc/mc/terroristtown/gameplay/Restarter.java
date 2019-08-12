package de.spexmc.mc.terroristtown.gameplay;

import java.util.Map;

import de.spexmc.mc.terroristtown.model.TTTPlayer;
import de.spexmc.mc.terroristtown.model.TTTRole;
import de.spexmc.mc.terroristtown.storage.Data;
import org.bukkit.Bukkit;

/**
 * Created by Lara on 11.08.2019 for SpexTTT
 */
public class Restarter {
  /**
   * Wenn das Spiel vorbei ist.
   */
  public void invoke() {
    //TODO (Abgie) 12.08.2019: Mapvote
    final Map<TTTPlayer, TTTRole> tttPlayers = Data.getInstance().getTTTInfo().getPlayers();
    tttPlayers.clear();

    Bukkit.getOnlinePlayers().forEach(player -> tttPlayers.put(TTTPlayer.determine(player), null));
    //TODO (Abgie) 11.08.2019:
  }
}
