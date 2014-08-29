package com.theparkmc.simonsays.handlers;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TeamManager {
	
	private static ArrayList<String> playerTeam = new ArrayList<String>();
	private static ArrayList<String> specTeam = new ArrayList<String>();
	
	public static void addToTeam(Player player, String team) {
		if (playerTeam.contains(player.getName()) == false || specTeam.contains(player.getName())) {
			if (team == "player") {
				playerTeam.add(player.getName());
				player.sendMessage(ChatColor.GREEN + "Added to " + ChatColor.YELLOW + "Player" + ChatColor.GREEN + " team!");
			} else {
				player.sendMessage(ChatColor.GREEN + "Added to " + ChatColor.YELLOW + "Spectator" + ChatColor.GREEN + " team!");
			}
		}
	}
	
	public static String getPlayerTeam(Player player) {
		if (playerTeam.contains(player.getName()) == true) {
			return "player";
		} else if (specTeam.contains(player.getName()) == true) {
			return "spectator";
		} else {
			return null;
		}
	}
	
	public static boolean isOnTeam(Player player) {
		if(playerTeam.contains(player.getName()) == true) {
			return true;
		} else if(specTeam.contains(player.getName()) == true) {
			return true;
		} else {
			return false;
		}
	}
	

	public static int getPlayerTeamCount() {
		return playerTeam.size();
	}

	public static int getSpecTeamCount() {
		return specTeam.size();
	}

	public static void clearTeams() {
		playerTeam.clear();
		specTeam.clear();
	}
	
}
