package de.spexmc.mc.terroristtown.util.objectmanager;

import de.spexmc.mc.terroristtown.model.TTTPlayer;
import de.spexmc.mc.terroristtown.model.TTTRole;
import de.spexmc.mc.terroristtown.storage.Data;
import org.bukkit.entity.Player;

/**
 * Created by Lara on 11.08.2019 for SpexTTT
 */
public class JoinManager {
  private final TTTPlayer joiner;

  public JoinManager(Player joiner) {
    this.joiner = TTTPlayer.determine(joiner);
  }

  public void joinAsSpecator() {
    //TODO (Abgie) 11.08.2019:
    joiner.setRole(TTTRole.SPECTATOR);
    Data.getInstance().getTTTInfo().getPlayers().put(joiner, TTTRole.SPECTATOR);
  }

  public void joinAsPlayer() {
    //TODO (Abgie) 11.08.2019:
    Data.getInstance().getTTTInfo().getPlayers().put(joiner, null);
  }

}
