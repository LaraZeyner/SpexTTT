package de.spexmc.mc.terroristtown.listener;

import de.spexmc.mc.terroristtown.gameplay.Shop;
import de.spexmc.mc.terroristtown.model.TTTPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Created by Lara on 27.08.2019 for SpexTTT
 */
public class InventoryEvents implements Listener {

  @EventHandler
  public void onInventoryClick(InventoryClickEvent clickEvent) {
    final TTTPlayer tttPlayer = TTTPlayer.determine((Player) clickEvent.getWhoClicked());
    new Shop(tttPlayer).callClickEvent(clickEvent);
  }
}
