package de.spexmc.mc.terroristtown.model;

import java.util.Objects;

/**
 * Created by Lara on 12.08.2019 for SpexTTT
 */
public class TTTMapImpl {
  private final String name;

  public TTTMapImpl(String name) {
    this.name = name;
  }

  //<editor-fold desc="getter and setter">
  public String getName() {
    return name;
  }
  //</editor-fold>


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof TTTMapImpl)) return false;
    final TTTMapImpl tttMap = (TTTMapImpl) o;
    return name.equals(tttMap.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "TTTMapImpl{" +
        "name='" + name + '\'' +
        '}';
  }
}
