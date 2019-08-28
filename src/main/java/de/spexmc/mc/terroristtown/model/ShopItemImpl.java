package de.spexmc.mc.terroristtown.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.bukkit.inventory.ItemStack;

/**
 * Created by Lara on 27.08.2019 for SpexTTT
 */
public class ShopItemImpl implements Serializable {
  private static final long serialVersionUID = -4188645611430665729L;

  private final byte cost;
  private final ItemStack stack;
  private final String name;
  private final TTTRole permissable;

  public ShopItemImpl(String name, byte cost, ItemStack stack, TTTRole permissable) {
    this.name = name;
    this.cost = cost;
    this.stack = stack;
    this.permissable = permissable;
  }

  public byte getCost() {
    return cost;
  }

  public String getName() {
    return "§e" + name + " (" + cost + " Points)";
  }

  public TTTRole getPermissable() {
    return permissable;
  }

  public ItemStack getStack() {
    return stack;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ShopItemImpl)) return false;
    final ShopItemImpl shopItem = (ShopItemImpl) o;
    return cost == shopItem.cost &&
        stack.equals(shopItem.stack) &&
        name.equals(shopItem.name) &&
        permissable.equals(shopItem.permissable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cost, stack, name);
  }

  @Override
  public String toString() {
    return "ShopItemImpl{" +
        "cost=" + cost +
        ", stack=" + stack +
        ", name=" + name +
        ", permissable=" + permissable + '}';
  }
}
