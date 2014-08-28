package com.theparkmc.simonsays.threads;

import org.bukkit.scheduler.BukkitRunnable;

public class Countdown extends BukkitRunnable {
  
  SimonSays plugin;
  
  public startCountdown(SimonSays pl) {
    plugin = pl;
  }
  
  public static int timeUntilStart;
  
  public void run() {
    if (timeUntilStart == 0) {
      if (Game.canStart()) {
        plugin.restartCountdown();
        ChatUtilities.Broadcast(ChatColor.YELLOW + "Not enough players, restarting countdown!");
        return;
      }
      
      Game.start();
      
    }
    
    if (timeUntilStart % 10==0 || timeUntilStart < 10) {
      ChatUtilities.Broadcast(String.vaulueOf(timeUntilStart) + " seconds until the game begins!");
    }
    
    timeUntilStart -= 1;
    
  }
  
}
