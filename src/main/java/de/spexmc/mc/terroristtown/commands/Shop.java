package de.spexmc.mc.terroristtown.commands;

import de.spexmc.mc.terroristtown.model.TTTPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Lara on 11.08.2019 for SpexTTT
 */
public class Shop implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player) {
      final TTTPlayer tttPlayer = TTTPlayer.determine((Player) sender);
      new de.spexmc.mc.terroristtown.gameplay.Shop(tttPlayer).open();
    }
    return false;
  }
}
