package de.spexmc.mc.terroristtown.util.mcutils;

import java.util.ArrayList;
import java.util.List;

import de.spexmc.mc.terroristtown.util.Messenger;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

/**
 * Created by Lara on 27.08.2019 for SpexTTT
 * <p>
 * Easily create itemstacks, without messing your hands.
 */
public class ItemBuilder implements Cloneable {
  private final ItemStack stack;

  /**
   * Create a new ItemBuilder from scratch.
   *
   * @param material The material to create the ItemBuilder with.
   */
  public ItemBuilder(Material material) {
    this(material, 1);
  }

  /**
   * Create a new ItemBuilder from scratch.
   *
   * @param material The material to create the ItemBuilder with.
   */
  public ItemBuilder(Material material, int amount) {
    stack = new ItemStack(material, amount);
  }

  /**
   * Create a new ItemBuilder from scratch.
   *
   * @param m The material of the item.
   * @param amount The amount of the item.
   * @param durability The durability of the item.
   */
  public ItemBuilder(Material m, int amount, byte durability) {
    stack = new ItemStack(m, amount, durability);
  }

  private ItemBuilder(ItemStack is) {
    this.stack = is;
  }

  /**
   * Clone the ItemBuilder into a new one.
   *
   * @return The cloned instance.
   */
  @Override
  public ItemBuilder clone() {
    try {
      return (ItemBuilder) super.clone();
    } catch (CloneNotSupportedException ex) {
      Messenger.administratorMessage(ex.getMessage());
    }
    return new ItemBuilder(stack);
  }

  /**
   * Set the displayname of the item.
   *
   * @param name The name to change it to.
   */
  public ItemBuilder setName(String name) {
    final ItemMeta im = stack.getItemMeta();
    im.setDisplayName(name);
    stack.setItemMeta(im);
    return this;
  }

  /**
   * Set the skull owner for the item. Works on skulls only.
   *
   * @param owner The name of the skull's owner.
   */
  public ItemBuilder setSkullOwner(String owner) {
    final SkullMeta meta = (SkullMeta) stack.getItemMeta();
    meta.setOwner(owner);
    stack.setItemMeta(meta);
    return this;
  }

  /**
   * Add a lore line.
   *
   * @param line The lore line to add.
   */
  public ItemBuilder addLoreLine(String line) {
    final ItemMeta meta = stack.getItemMeta();
    final List<String> lore = new ArrayList<>(meta.getLore());
    lore.add(line);
    meta.setLore(lore);
    stack.setItemMeta(meta);
    return this;
  }

  /**
   * Sets the dye color of a wool item. Works only on wool.
   *
   * @param color The DyeColor to set the wool item to.
   * @see ItemBuilder@setDyeColor(DyeColor)
   * @deprecated As of version 1.2 changed to setDyeColor.
   */
  @Deprecated
  public ItemBuilder setWoolColor(DyeColor color) {
    if (stack.getType().equals(Material.WOOL)) {
      stack.setDurability(color.getDyeData());
    }
    return this;
  }

  /**
   * Retrieves the itemstack from the ItemBuilder.
   *
   * @return The itemstack created/modified by the ItemBuilder instance.
   */
  public ItemStack getItem() {
    return stack;
  }
}
