package com.theparkmc.simonsays.listeners.player;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath extends SSListener {
  
  public PlayerDeath(SimonSays pl) {
    super(pl);
  }
  
  @EventHandler
  public void onPlayerDeath(PlayerDeathEvent event) {
    Player player = event.getEntity();
    //Add Team stuff here
  }
  
}
