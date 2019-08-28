package de.spexmc.mc.terroristtown.model;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Lara on 27.08.2019 for SpexTTT
 */
public class ShopItem extends ShopItemImpl {
  private static final long serialVersionUID = -4103996148597016452L;

  public ShopItem(ItemStack stack, int cost, TTTRole permissable) {
    super(stack.getItemMeta().getDisplayName(), (byte) cost, stack, permissable);
  }

  public boolean canBuy(TTTPlayer buyer) {
    return buyer.getPoints() >= getCost() && isAvailable(buyer);
  }

  public boolean isAvailable(TTTPlayer buyer) {
    return buyer.getRole().equals(getPermissable()) || getPermissable().equals(TTTRole.ALL);
  }

  public ItemStack setMaterial(Material material) {
    getStack().setType(material);
    return getStack();
  }
}
