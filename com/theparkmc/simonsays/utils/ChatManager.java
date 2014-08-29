package com.theparkmc.simonsays.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import com.theparkmc.simonsays.Main;

public class ChatManager {

  public String welcomeMessage(String playerName) {
		return ChatColor.GOLD + "" + ChatColor.BOLD + "Welcome " + playerName + "!";
	}
	
	public String playerJoinMessage(String playerName, int playerCount) {
		return ChatColor.GREEN + " + " + ChatColor.GRAY + playerName + 
				" joined the game. (" + playerCount + "/" + Main.getMaxPlayers() +  ")";
	}
	
	//Shows users as they logout
	public String playerQuitMessage(String playerName, int playerCount) {
		return ChatColor.RED + " - " + ChatColor.GRAY + playerName + 
				" left the game. (" + (playerCount - 1) + "/" + Main.getMaxPlayers() +  ")";
	}
	
	public void colorCountDown (int timeCount) {
		for(Player player : Bukkit.getOnlinePlayers()) {
			String timeCountString = Integer.toString(timeCount);		
			//Show countdown at 60, 45, 30, 20, and 15 seconds.
			if (timeCount == 30 || timeCount == 15) {
				player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Countdown: " + timeCountString + " seconds left!");
			} else if (timeCount <= 10 && timeCount >= 3) { //Show bold green countdown for ever second between 10 and 3 seconds.
				player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Countdown: " + timeCountString + " seconds left!");
				//play a sound
			    player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 7);
			} else if (timeCount == 2) { //Show bold yellow countdown for 2 seconds left.
				player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Countdown: " + timeCountString + " seconds left!");
				//play a sound
			    player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 7);
			} else if (timeCount == 1) { //Show bold red countDown for 1 second left.
				player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Countdown: " + timeCountString + " second left!");
				//play a sound
			    player.playSound(player.getLocation(), Sound.NOTE_PIANO, 1, 7);
			} else {
				//Want to see all the numbers? Uncomment the line below
				//debugMessage(timeCountString);
			}
		}
	}


}
