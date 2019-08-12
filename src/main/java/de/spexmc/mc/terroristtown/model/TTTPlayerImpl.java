package de.spexmc.mc.terroristtown.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by Lara on 11.08.2019 for SpexTTT
 */
public class TTTPlayerImpl implements Serializable {
  private static final long serialVersionUID = -3427286167928254392L;

  private final UUID uuid;
  private TTTRole role;

  private transient boolean spectator;
  private transient TTTMap votedMap;

  TTTPlayerImpl(UUID uuid) {
    this.spectator = false;
    this.uuid = uuid;
  }

  //<editor-fold desc="getter and setter">
  public TTTRole getRole() {
    return role;
  }

  public void setRole(TTTRole role) {
    this.role = role;
  }

  public boolean isSpectator() {
    return spectator;
  }

  public void setSpectator(boolean spectator) {
    this.spectator = spectator;
  }

  UUID getUuid() {
    return uuid;
  }

  public TTTMap getVotedMap() {
    return votedMap;
  }

  public void setVotedMap(TTTMap votedMap) {
    this.votedMap = votedMap;
  }
  //</editor-fold>


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof TTTPlayerImpl)) return false;
    final TTTPlayerImpl tttPlayer = (TTTPlayerImpl) o;
    return spectator == tttPlayer.spectator &&
        uuid.equals(tttPlayer.uuid) &&
        role == tttPlayer.role &&
        Objects.equals(votedMap, tttPlayer.votedMap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, role, spectator, votedMap);
  }

  @Override
  public String toString() {
    return "TTTPlayerImpl{" +
        "uuid=" + uuid +
        ", role=" + role +
        ", spectator=" + spectator +
        ", votedMap=" + votedMap +
        '}';
  }
}
