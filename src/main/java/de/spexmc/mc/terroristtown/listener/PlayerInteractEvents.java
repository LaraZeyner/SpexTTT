package de.spexmc.mc.terroristtown.listener;

import de.spexmc.mc.terroristtown.model.TTTPlayer;
import de.spexmc.mc.terroristtown.storage.Const;
import de.spexmc.mc.terroristtown.util.Messenger;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Lara on 11.08.2019 for SpexTTT
 */
public class PlayerInteractEvents {
  @EventHandler
  public void shopItem(PlayerInteractEvent interactEvent) {
    final Player target = interactEvent.getPlayer();
    final ItemMeta shopItemMeta = target.getItemInHand().getItemMeta();
    if (shopItemMeta != null && shopItemMeta.getDisplayName().equals(Const.SHOPITEMNAME)) {
      target.performCommand("shop");
    }
  }

  @EventHandler
  public void onChat(AsyncPlayerChatEvent chatEvent) {
    if (chatEvent.getMessage().startsWith("t ")) {
      final Player sender = chatEvent.getPlayer();
      final TTTPlayer tttPlayer = TTTPlayer.determine(sender);
      Messenger.sendTeamMessage(tttPlayer, chatEvent.getMessage().substring(2));
    }
  }

  @EventHandler
  public void onInteractEntity(PlayerInteractEntityEvent interactEntityEvent) {
    interactEntityEvent.setCancelled(true);
  }

  @EventHandler
  public void onInteractAtEntity(PlayerInteractAtEntityEvent interactAtEntityEvent) {
    interactAtEntityEvent.setCancelled(true);
  }

}
