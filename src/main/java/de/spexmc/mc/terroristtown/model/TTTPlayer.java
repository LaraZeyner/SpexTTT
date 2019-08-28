package de.spexmc.mc.terroristtown.model;

import java.util.Map;
import java.util.function.Predicate;

import de.spexmc.mc.terroristtown.gameplay.Joiner;
import de.spexmc.mc.terroristtown.gameplay.Quiter;
import de.spexmc.mc.terroristtown.storage.Data;
import de.spexmc.mc.terroristtown.util.mcutils.UUIDUtils;
import org.bukkit.entity.Player;

/**
 * Created by Lara on 11.08.2019 for SpexTTT
 */
public class TTTPlayer extends TTTPlayerImpl {
  private static final long serialVersionUID = 6188169232759794407L;

  public static TTTPlayer determine(Player player) {
    final Map<TTTPlayer, TTTRole> tttPlayers = Data.getInstance().getTTTInfo().getPlayers();
    final Predicate<TTTPlayer> predicate = tttPlayer -> tttPlayer.getPlayer().equals(player);
    final TTTPlayer tttPlayer = tttPlayers.keySet().stream().filter(predicate).findAny()
        .orElse(new TTTPlayer(player));
    tttPlayers.put(tttPlayer, null);
    return tttPlayer;
  }

  public TTTPlayer(Player player) {
    super(player.getUniqueId());
  }

  public void addPoints(byte amount) {
    setPoints((byte) (getPoints() + amount));
  }

  public boolean removePoints(byte amount) {
    if (getPoints() >= amount) {
      addPoints((byte) -amount);
      return true;
    }
    return false;
  }

  public void join() {
    final Joiner joiner = new Joiner(this);
    joiner.invoke();
  }

  public void quit() {
    final Quiter quiter = new Quiter(this);
    quiter.invoke();
  }

  public Player getPlayer() {
    return UUIDUtils.getPlayer(getUuid());
  }

  public boolean isSpectator() {
    return getRole().equals(TTTRole.SPECTATOR);
  }
}
