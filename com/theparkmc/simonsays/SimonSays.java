package com.theparkmc.simonsays;

import java.io.File;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SimonSays extends JavaPlugin {
  
  public static int startCountdownId;
  
  private static boolean debugMessages = true;
	private static int minPlayers = 4;
	private static int maxPlayers = 16;
  
  public void onEnable() {
    GameState.setState(GameState.IN_LOBBY);
    
    registerKits();
    startCountdown();
    registerListeners();
    
    getLogger().info("SimonSays Has Been Enabled!");
  }
  
  public void registerListeners() {
    PluginManager pm = Bukkit.getServer().getPluginManager();
    pm.registerEvents(new PlayerJoin(this), this);
    pm.registerEvents(new PlayerDeath(this), this);
    pm.registerEvents(new PlayerQuit(this), this);
    pm.registerEvents(new AsyncPlayerPreLogin(this), this);
    pm.registerEvents(new PlayerBreak(this), this);
  }
  
  public void startCountdown() {
    startCountdown.timeUntilStart = 60;
    startCountdownId = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new startCountdown(this), 20L, 20);
  }
  
  public void stopCountdown() {
    Bukkit.getServer().getScheduler().cancelTask(startCountdownId);
  }
  
  public void restartCountdown() {
    stopCountdown();
    startCountdown();
  }
  
  public void onDisable() {
    getLogger().info("SimonSays Has Been Disabled!");
  }
  
}
