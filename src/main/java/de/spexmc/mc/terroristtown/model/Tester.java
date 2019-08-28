package de.spexmc.mc.terroristtown.model;


import org.bukkit.Location;

/**
 * Created by Lara on 27.08.2019 for SpexTTT
 */
public class Tester {
  private boolean enabled;
  private Location buttonLocation;

  public Tester(Location buttonLocation) {
    this.buttonLocation = buttonLocation;
    this.enabled = false;
  }

  public Location getButtonLocation() {
    return buttonLocation;
  }

  public void setButtonLocation(Location buttonLocation) {
    this.buttonLocation = buttonLocation;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }
}
