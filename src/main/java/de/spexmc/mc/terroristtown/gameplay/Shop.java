package de.spexmc.mc.terroristtown.gameplay;

import java.util.Arrays;
import java.util.Objects;

import de.spexmc.mc.terroristtown.model.ShopItem;
import de.spexmc.mc.terroristtown.model.TTTPlayer;
import de.spexmc.mc.terroristtown.model.Tester;
import de.spexmc.mc.terroristtown.storage.Const;
import de.spexmc.mc.terroristtown.storage.Data;
import de.spexmc.mc.terroristtown.storage.Messages;
import de.spexmc.mc.terroristtown.util.Messenger;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Lara on 27.08.2019 for SpexTTT
 */
public class Shop {
  private final Inventory inventory;
  private final TTTPlayer tttPlayer;

  public Shop(TTTPlayer tttPlayer) {
    this.tttPlayer = tttPlayer;
    this.inventory = determineInventory(tttPlayer);
  }

  private Inventory determineInventory(TTTPlayer tttPlayer) {
    final Inventory inventory = Bukkit.createInventory(null, 9, tttPlayer.getRole().name() + "-Shop");
    performAddItems(Const.ARROWS, Const.HEAL, Const.SPOOFER, Const.STICK, Const.TESTER);
    inventory.addItem(determineItem(Const.ARROWS), determineItem(Const.HEAL), determineItem(Const.SPOOFER),
        determineItem(Const.STICK), determineItem(Const.TESTER));
    return inventory;
  }

  private void performAddItems(ShopItem... items) {
    Arrays.stream(items).map(this::determineItem).filter(Objects::nonNull).forEach(inventory::addItem);
  }

  private ItemStack determineItem(ShopItem item) {
    return item.canBuy(tttPlayer) ? item.getStack() : item.isAvailable(tttPlayer) ? item.setMaterial(Material.BARRIER) : null;
  }


  public void open() {
    tttPlayer.getPlayer().openInventory(inventory);
  }

  public void callClickEvent(InventoryClickEvent e) {
    final ItemStack clickedItem = e.getCurrentItem();
    final HumanEntity whoClicked = e.getWhoClicked();
    final Tester tester = Data.getInstance().getTester();

    if (clickedItem.getItemMeta() != null) {
      addItem(Const.ARROWS, e);
      addItem(Const.HEAL, e);
      if (!whoClicked.getInventory().contains(Const.SPOOFER.getStack())) addItem(Const.SPOOFER, e);
      if (!whoClicked.getInventory().contains(Const.STICK.getStack())) addItem(Const.STICK, e);
      if (clickedItem.equals(Const.TESTER.getStack()) && tester.isEnabled()) evaluateTesterItem(tester);
    }
  }

  private void addItem(ShopItem shopItem, InventoryClickEvent clickEvent) {
    if (clickEvent.getCurrentItem().equals(shopItem.getStack())) {
      tttPlayer.removePoints(shopItem.getCost());
      clickEvent.getWhoClicked().getInventory().addItem(shopItem.getStack());
    }
  }

  private void evaluateTesterItem(Tester tester) {
    tttPlayer.removePoints(Const.TESTER.getCost());
    tester.setEnabled(false);
    Messenger.broadcast(Messages.TESTER_DISABLED);
    final Location location = tester.getButtonLocation();
    location.getWorld().playEffect(location, Effect.EXPLOSION, 5);
    location.getWorld().playSound(location, Sound.AMBIENCE_THUNDER, 5, 5);
  }
}

