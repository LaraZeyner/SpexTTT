package de.spexmc.mc.terroristtown.storage;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import de.spexmc.mc.terroristtown.gameplay.Restarter;
import de.spexmc.mc.terroristtown.model.TTTMap;
import de.spexmc.mc.terroristtown.model.TTTPlayer;
import de.spexmc.mc.terroristtown.model.TTTRole;

/**
 * Created by Lara on 11.08.2019 for SpexTTT
 */
public class TTTInfoImpl implements Serializable {
  private static final long serialVersionUID = -7480075920833623123L;

  private boolean started;
  private final Map<TTTPlayer, TTTRole> players;
  private TTTMap map;

  TTTInfoImpl() {
    this.players = new HashMap<>();
    this.started = false;
  }

  public void start() {
    this.started = true;
    new Restarter().invoke();
  }

  public void restart() {
    this.started = false;
    new Restarter().invoke();
  }

  //<editor-fold desc="getter and setter">
  TTTMap getMap() {
    return map;
  }

  public void setMap(TTTMap map) {
    this.map = map;
  }

  public Map<TTTPlayer, TTTRole> getPlayers() {
    return players;
  }

  public boolean isStarted() {
    return started;
  }
  //</editor-fold>


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof TTTInfoImpl)) return false;
    final TTTInfoImpl tttInfo = (TTTInfoImpl) o;
    return started == tttInfo.started &&
        players.equals(tttInfo.players) &&
        Objects.equals(map, tttInfo.map);
  }

  @Override
  public int hashCode() {
    return Objects.hash(started, players, map);
  }

  @Override
  public String toString() {
    return "TTTInfoImpl{" +
        "started=" + started +
        ", players=" + players +
        ", mapName='" + map + '\'' +
        '}';
  }
}
