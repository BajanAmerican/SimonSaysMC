package com.theparkmc.simonsays.handlers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Game {
  
  private static boolean canStart = false;
  private static boolean hasStarted = false;
  
  private static String[] teams = new String[] { "Players", "Spectators" };
  
  public static boolean canStart() {
    return canStart;
  }
  
  public static boolean hasStarted() {
    return hasStarted;
  }
  
  public static void setCanStart(boolean b) {
    canStart = b;
  }
  
  public static void start() {
    hasStarted = true;
    new Team(teams);
    
    LocationUtilities.teleportToGame(player);
    
    if (Game.hasStarted()) {
      //Add Kits Here
      
    }
    
    
    }
  }
  
  
}
