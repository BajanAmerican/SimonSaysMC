package com.theparkmc.simonsays.utils;

import static org.bukkit.ChatColor.*;

import org.bukkit.Bukkit;
import org.bukkit.entity.player;

public class ChatUtilities {
  
  public static void Broadcast(String msg) {
    for (Player player : Bukkit.getOnlinePlayers()) {
      player.sendMessage(starter() + msg);
    }
  }
  
  private static String starter() {
    return GRAY + "[" + RED + "Simon-Says" + GRAY + "] ";
  }
  
  public static void sendMessage(Player player, String msg) {
    player.sendMessage(starter() + msg);
  }
  
}
