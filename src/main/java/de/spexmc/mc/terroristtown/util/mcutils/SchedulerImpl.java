package de.spexmc.mc.terroristtown.util.mcutils;

import de.spexmc.mc.terroristtown.TerroristTown;
import de.spexmc.mc.terroristtown.model.TTTPlayer;
import org.bukkit.Bukkit;

/**
 * Created by Lara on 30.07.2019 for terroristtown
 */
public abstract class SchedulerImpl {
  private final TTTPlayer tttPlayer;
  private int counter, id;

  public SchedulerImpl(TTTPlayer tttPlayer) {
    this.counter = 0;
    this.id = 0;
    this.tttPlayer = tttPlayer;
  }

  public abstract void invoke();

  public void increment(int amount) {
    counter += amount;
  }

  public void increment() {
    increment(1);
  }

  public void decrement(int amount) {
    increment(-amount);
  }

  public void decrement() {
    increment(-1);
  }

  public int getCounter() {
    return counter;
  }

  public void setCounter(int counter) {
    this.counter = counter;
  }

  public TTTPlayer getTTTPlayer() {
    return tttPlayer;
  }

  public void schedule(int startCounter, Runnable runnable) {
    this.counter = startCounter;
    this.id = Bukkit.getScheduler().scheduleSyncRepeatingTask(TerroristTown.getInstance(), runnable, 20L, 20L);
  }

  public void cancel() {
    Bukkit.getScheduler().cancelTask(id);
  }
}
