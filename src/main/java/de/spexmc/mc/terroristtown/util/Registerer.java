package de.spexmc.mc.terroristtown.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import de.spexmc.mc.terroristtown.TerroristTown;
import de.spexmc.mc.terroristtown.commands.TestCommand;
import de.spexmc.mc.terroristtown.listener.TestEvent;
import de.spexmc.mc.terroristtown.storage.Const;
import de.spexmc.mc.terroristtown.storage.Data;
import de.spexmc.mc.terroristtown.storage.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.reflections.Reflections;

/**
 * Created by Lara on 26.02.2019 for terroristtown
 */
public final class Registerer {

  public static void performRegistration() {
    registerCommands();
    registerEvents();

    if (checkErrors()) {
      Messenger.administratorMessage(Messages.CONFIG_ERROR);
      Data.setForceDisable(true);
      TerroristTown.getInstance().onDisable();
    }
  }

  private static boolean checkErrors() {
    final Connection connection = Data.getInstance().getSql().getConnection();
    try {
      return connection == null || connection.isClosed();
    } catch (SQLException ignored) {
      return true;
    }
  }

  private static void registerCommands() {
    final Reflections reflections =
        new Reflections("de.spexmc.mc." + Const.PLUGIN_NAME.toLowerCase() + ".commands");
    for (Class<? extends CommandExecutor> commandClass : reflections.getSubTypesOf(CommandExecutor.class)) {
      final String name = commandClass.getSimpleName().toLowerCase();
      try {
        TerroristTown.getInstance().getCommand(name).setExecutor(commandClass.getConstructor().newInstance());
      } catch (ReflectiveOperationException ignored) {
        Messenger.administratorMessage("Command " + name + " could not loaded.");
      }
    }
  }

  private static void registerEvents() {
    final Reflections reflections =
        new Reflections("de.spexmc.mc." + Const.PLUGIN_NAME.toLowerCase() + ".listener");
    for (Class<? extends Listener> listenerClass : reflections.getSubTypesOf(Listener.class)) {
      try {
        Bukkit.getPluginManager().registerEvents(listenerClass.getConstructor().newInstance(), TerroristTown.getInstance());
      } catch (ReflectiveOperationException ignored) {
        Messenger.administratorMessage("Event " + listenerClass.getName() + " could not loaded.");
      }
    }
  }
}
