package com.theparkmc.simonsays.listeners.player;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;

import com.theparkmc.simonsays.listeners.SSListeners;

public class AsyncPlayerPreLogin extends SSListener {
  
  public AsyncPlayerPreLogin(SimonSays pl) {
    super(pl);
  }
  
  @EventHandler
  public void playerPreLogin(AsyncPlayerPreLoginEvent event) {
    if (Game.hasStarted()) {
      event.disallow(Result.KICK_OTHER, ChatColor.RED + "Game Has Already Started!");
    }
    
  }
  
}
