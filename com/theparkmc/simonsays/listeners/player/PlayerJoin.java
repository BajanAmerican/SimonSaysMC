package com.theparkmc.simonsays.listeners.player;

//Add Imports here

public class PlayerJoin extends SSListener {
  
  public PlayerJoin(SimonSays pl) {
    super(pl);
  }
  
  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    
    //Add More Code When given more information
  }
  
}
