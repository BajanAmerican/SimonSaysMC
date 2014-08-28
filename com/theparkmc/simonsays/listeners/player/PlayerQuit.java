package com.theparkmc.simonsays.listeners.player;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit extends SSListener {
  public SimonSays pl;
  
  public PlayerQuit (SimonSays pl) {
    super(pl);
  }
  
  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent event) {
    if (GameState.isSate(GameState.IN_LOBBY)) {
      Game.setCanStart(Bukkit.getOnlinePlayers().length -1 >= 4);
      
      Player player = event.getPlayer();
      
      if (Game.hasStarted()) {
        event.setLeaveMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + " has left " + ChatColor.DARK_GREEN + "Simon Says!");
      }
    }
  }
}
