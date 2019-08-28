package de.spexmc.mc.terroristtown.storage;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import de.spexmc.mc.terroristtown.model.ShopItem;
import de.spexmc.mc.terroristtown.model.TTTRole;
import de.spexmc.mc.terroristtown.util.mcutils.ItemBuilder;
import org.bukkit.Material;


/**
 * Created by Lara on 26.02.2019 for terroristtown
 */
public final class Const {
  public static final boolean HIDESPECS = false;

  public static final File SQL_CONFIG = new File("plugins" + File.separator + "config" + File.separator + "sql.properties");

  public static final List<Material> DROPABLE_MATERIALS = Arrays.asList(Material.ARROW, Material.BOW,
      Material.DIAMOND_SWORD, Material.IRON_SWORD, Material.STONE_SWORD, Material.WOOD_SWORD);

  public static final String PLAYERTABLE = "Playerstatus";
  public static final String PLUGIN_NAME = "TerroristTown";
  public static final String SHOPITEMNAME = "§6SHOP";
  public static final String TEXTUREPACK = "none";
  public static final String VERSION = "1.0";

  public static final ShopItem ARROWS = new ShopItem(new ItemBuilder(Material.TNT, 2).setName("TNT Arrows").getItem(), 2, TTTRole.TRAITOR);
  public static final ShopItem HEAL = new ShopItem(new ItemBuilder(Material.GOLDEN_APPLE).setName("Golden Apple").getItem(), 1, TTTRole.ALL);
  public static final ShopItem SPOOFER = new ShopItem(new ItemBuilder(Material.NETHER_STAR).setName("Spoofer").getItem(), 3, TTTRole.TRAITOR);
  public static final ShopItem STICK = new ShopItem(new ItemBuilder(Material.STICK).setName("Detective-Stick").getItem(), 2, TTTRole.DETECTIVE);
  public static final ShopItem TESTER = new ShopItem(new ItemBuilder(Material.TRIPWIRE_HOOK).setName("Tester shutdown").getItem(), 5, TTTRole.TRAITOR);
}