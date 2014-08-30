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
	
	Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
	Objective obj = board.registerNewObjective("test", "dummy");
	Team time = board.regusterNewTeam("time");
	Team time1 = board.regusterNewTeam("time1");
	Team players = board.regusterNewTeam("players");
	Team players1 = board.regusterNewTeam("players1");
	Team round = board.regusterNewTeam("round");
	Team round1 = board.regusterNewTeam("round1");
	Team item = board.regusterNewTeam("item");
	Team item1 = board.regusterNewTeam("item1");
	obj.setDisplaySlot(DisplaySlot.SIDEBAR);
	obj.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Simon-Says:");
	
	Score time = obj.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Time Left:"));
	time.setScore("7");
	
	Score time1 = obj.getScore(Bukkit.getOfflinePlayer(/*Add How Much time is left in the round*/);
	time1.setScore("6");
	
	Score players = obj.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Players Left:"));
	players.setScore("5");
	
	Score players1 = obj.getScore(Bukkit.getOfflinePlayer(/*Add How many players are left*/));
	players1.setScore("4");
	
	Score round = obj.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Round:"));
	round.setScore("3");
	
	Score round1 = obj.getScore(Bukkit.getOfflinePlayer(/*Add What round it currently is at*/));
	round1.setScore("2");
	
	Score item = obj.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Item(s):"));
	item.setScore("1");
	
	Score item1 = obj.getScore(Bukit.getOfflinePlayer(/*Add What item they have to get this round*/));
	item1.setScore("0");
	
	player.setScoreboard(board);
	}
  }
  
  public World getWorld() {
		return Bukkit.getWorld("world");
	}
	
    
    
    }
  }
  
  
}
