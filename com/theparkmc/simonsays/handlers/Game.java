package com.theparkmc.simonsays.handlers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Game {
  
      private String fileName;
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

  if(GameState.getState(GameState.IN_LOBBY)){
    WorldCreator worldCreator = new WorldCreator("world");
    worldCreator.createWorld();
    World world = Bukkit.getWorld("world");
   
  }
  
  if(GameState.getState((GameState.IN_GAME)){
  	Location teleportloc = new Location(world, 64, 64, 64);	
  	
  	for(Player players : Bukkit.getServer().getOnlinePlayers()) {
	players.teleport(teleportloc); 
	players.setPlayerTime(6000, false); 
	players.playSound(teleportloc, Sound.LEVEL_UP, 1, 10); 
	
	
	ArrayList<String> chestlore = new ArrayList<String>();
	ItemStack chest = new ItemStack(Material.CHEST);
	ItemMeta chestmeta = chest.getItemMeta();
	chestmeta.setDisplayName(ChatColor.GREEN + "Simon's Backpack");
	chestlore.add(ChatColor.GRAY + "Right-click to open simon's backpack");
	chestmeta.setLore(chestlore);
	chest.setItemMeta(chestmeta);
	player.getInventory().setItem(8, chest);
	}
  }
  
  public World getWorld() {
		return Bukkit.getWorld("world");
	}
	
    
    
    }
  }
  
  
}
