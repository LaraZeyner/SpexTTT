package de.spexmc.mc.terroristtown;

import java.util.logging.Level;
import java.util.logging.Logger;

import de.spexmc.mc.terroristtown.io.sql.SQLManager;
import de.spexmc.mc.terroristtown.storage.Data;
import de.spexmc.mc.terroristtown.storage.Messages;
import de.spexmc.mc.terroristtown.util.Registerer;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Lara on 26.02.2019 for terroristtown
 * Replace all terroristtown and TerroristTown of Classnames, Variablenames, Packagenames, etc with your projectname
 */
public class TerroristTown extends JavaPlugin {
  private static TerroristTown instance;
  private final Logger logger = Logger.getLogger(getClass().getName());

  public static TerroristTown getInstance() {
    return instance;
  }

  @Override
  public void onEnable() {
    logger.log(Level.INFO, Messages.ENABLING);
    instance = this;
    final Data data = Data.getInstance();
    data.getSql().updateOnStart();

    Registerer.performRegistration();
    logger.log(Level.INFO, Messages.SUCCESSFULLY_ENABLED);
  }

  @Override
  public void onDisable() {
    logger.log(Level.INFO, Messages.DISABLING);
    if (!Data.isForceDisable()) {
      final SQLManager sql = Data.getInstance().getSql();
      sql.disconnect();
    }
    logger.log(Level.INFO, Messages.SUCCESSFULLY_DISABLED);
  }

}