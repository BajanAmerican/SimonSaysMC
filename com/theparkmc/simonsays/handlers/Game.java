package com.theparkmc.simonsays.handlers;

import com.theparkmc.simonsays.utils.GameState;
import com.theparkmc.simonsays.handlers.Map;

public class Game {  
  
  private String fileName;
  
  
  if(GameState.getState(GameState.IN_LOBBY)){
    Map.loadMap();
   
  }
  
  public World getWorld() {
		return Bukkit.getWorld(fileName);
	}
	
	
}
