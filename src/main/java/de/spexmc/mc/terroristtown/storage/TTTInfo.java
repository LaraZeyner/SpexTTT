package de.spexmc.mc.terroristtown.storage;

import org.bukkit.Bukkit;
import org.bukkit.World;

/**
 * Created by Lara on 11.08.2019 for SpexTTT
 */
public class TTTInfo extends TTTInfoImpl {
  private static final long serialVersionUID = -3983517569709562168L;

  public World getWorld() {
    return Bukkit.getWorld(getMap().getName());
  }

}
