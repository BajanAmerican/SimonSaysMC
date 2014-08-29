package com.theparkmc.simonsays.handlers;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class KitGUI extends JavaPlugin implements Listener{
	
	public static Inventory kitgui = Bukkit.createInventory(null, 27, ChatColor.AQUA + "Kit Selector");
	public static ArrayList<String> starterkit = new ArrayList<String>();
	public static ArrayList<String> minerkit = new ArrayList<String>();
	public static ArrayList<String> teleportkit = new ArrayList<String>();
	public static ArrayList<String> speedkit = new ArrayList<String>();
	public static ArrayList<String> skipkit = new ArrayList<String>();
	
	@EventHandler
	public void PlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Material mat = player.getItemInHand().getType();
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			
			if(mat == Material.EMERALD) {
				openGUI(player);
			}
		}
	}
	
	public void openGUI(Player player) {
		ArrayList<String> starterlore = new ArrayList<String>();
		ArrayList<String> minerlore = new ArrayList<String>();
		ArrayList<String> teleportlore = new ArrayList<String>();
		ArrayList<String> potionlore = new ArrayList<String>();
		ArrayList<String> skiplore = new ArrayList<String>();
		ArrayList<String> storelore = new ArrayList<String>();
		
		ItemStack starter = new ItemStack(Material.WOOD_AXE);
		ItemMeta startermeta = starter.getItemMeta();
		startermeta.setDisplayName(ChatColor.GREEN + "Starter Kit");
		starterlore.add(ChatColor.GRAY + "Spawn with wood tools");
		startermeta.setLore(starterlore);
		starter.setItemMeta(startermeta);
		kitgui.setItem(2, starter);
		
		ItemStack miner = new ItemStack(Material.IRON_PICKAXE);
		ItemMeta minermeta = miner.getItemMeta();
		minermeta.setDisplayName(ChatColor.GREEN + "Miner Kit");
		minerlore.add(ChatColor.GRAY + "Spawn with an iron pickaxe");
		minerlore.add(ChatColor.RED + "Master+ Kit");
		minermeta.setLore(minerlore);
		miner.setItemMeta(minermeta);
		kitgui.setItem(3, miner);
		
		ItemStack teleport = new ItemStack(Material.ENDER_PEARL);
		ItemMeta teleportmeta = teleport.getItemMeta();
		teleportmeta.setDisplayName(ChatColor.GREEN + "Teleporter Kit");
		teleportlore.add(ChatColor.GRAY + "Ability to teleport to starting");
		teleportlore.add(ChatColor.GRAY + "pad once");
		teleportlore.add(ChatColor.GRAY + "Usage: " + ChatColor.YELLOW + "/pad");
		teleportlore.add(ChatColor.RED + "Legend+ Kit");
		teleportmeta.setLore(teleportlore);
		teleport.setItemMeta(teleportmeta);
		kitgui.setItem(4, teleport);
		
		
		ItemStack potion = new ItemStack(Material.POTION);
		ItemMeta potionmeta = potion.getItemMeta(); 
		potionmeta.setDisplayName(ChatColor.GREEN + "Speed Kit");
		potionlore.add(ChatColor.GRAY + "Given speed 1 for the entire game");
		potionlore.add(ChatColor.RED + "God+ Kit");
		potionmeta.setLore(potionlore);
		potion.setItemMeta(potionmeta);
		kitgui.setItem(5, potion);
		
		ItemStack skip = new ItemStack(Material.BOOK);
		ItemMeta skipmeta = skip.getItemMeta();
		skipmeta.setDisplayName(ChatColor.GREEN + "Skip Kit");
		skiplore.add(ChatColor.GRAY + "Ability to skip a round!");
		skiplore.add(ChatColor.RED + " God+ Kit");
		skipmeta.setLore(skiplore);
		skip.setItemMeta(skipmeta);
		kitgui.setItem(6, skip);
		
		ItemStack store = new ItemStack(Material.PAPER);
		ItemMeta storemeta = store.getItemMeta();
		storemeta.setDisplayName(ChatColor.ITALICS + "Store");
		storelore.add(ChatColor.GRAY + "Visit our store!");
		storeleta.setLore(storelore);
		store.setItemMeta(storemeta);
		kitgui.setItem(13, store);
		
		player.openInventory(kitgui);
	}
	
	@EventHandler
	public void onInventoryClickSpeed(InventoryClickEvent event) {
		if(!event.getInventory().getName().equalsIgnoreCase(ChatColor.AQUA + "Kit Selector")) 
			return;
		
			
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		player.closeInventory();
		
		
		if(event.getCurrentItem()==null || event.getCurrentItem().getType()==Material.AIR || !event.getCurrentItem().hasItemMeta()) {
			event.setCancelled(true);
			player.closeInventory();
			return;
		}
		
		switch(event.getCurrentItem().getType()) {
		
		case WOOD_AXE:
			event.setCancelled(true);
			player.closeInventory();
			starterkit.add(player.getName());
			player.sendMessage(ChatColor.GREEN + "You have chosen the " + ChatColor.YELLOW + "Starter " + ChatColor.GREEN + "kit!");
			break;
		case IRON_PICKAXE:
			if (player.hasPermission("simonsays.master")) {
			event.setCancelled(true);
			player.closeInventory();
			minerkit.add(player.getName());
			player.sendMessage(ChatColor.GREEN + "You have chosen the " + ChatColor.YELLOW + "Miner " + ChatColor.GREEN + "kit!");
			} else {
				event.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatColor.YELLOW + "You must be a Master or higher to use this kit! Purchase it @ " + ChatColor.AQUA + "theparkmc.com/shop " + ChatColor.YELLOW + "!");
			}
			
			break;
		case ENDER_PEARL:
			if (player.hasPermission("simonsays.legend")) {
			event.setCancelled(true);
			player.closeInventory();
			teleportkit.add(player.getName());
			player.sendMessage(ChatColor.GREEN + "You have chosen the " + ChatColor.YELLOW + "Teleport " + ChatColor.GREEN + "kit!");
			} else {
				event.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatColor.YELLOW + "You must be a Legend or higher to use this kit! Purchase it @ " + ChatColor.AQUA + "theparkmc.com/shop " + ChatColor.YELLOW + "!");
			}
			
			break;
		case POTION:
			if (player.hasPermission("simonsays.god")) {
			event.setCancelled(true);
			player.closeInventory();
			speedkit.add(player.getName());
			player.sendMessage(ChatColor.GREEN + "You have chosen the " + ChatColor.YELLOW + "Speed " + ChatColor.GREEN + "kit!");
			} else {
				event.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatColor.YELLOW + "You must be a God or higher to use this kit! Purchase it @ " + ChatColor.AQUA + "theparkmc.com/shop " + ChatColor.YELLOW + "!");
			}
			
			break;
		case BOOK:
			if (player.hasPermission("simonsays.god")) {
			event.setCancelled(true);
			player.closeInventory();
			skipkit.add(player.getName());
			player.sendMessage(ChatColor.GREEN + "You have chosen the " + ChatColor.YELLOW + "Skip " + ChatColor.GREEN + "kit!");
			} else {
				event.setCancelled(true);
				player.closeInventory();
				player.sendMessage(ChatColor.YELLOW + "You must be a God or higher to use this kit! Purchase it @ " + ChatColor.AQUA + "theparkmc.com/shop " + ChatColor.YELLOW + "!");
			}
			
			break;

		default:
			event.setCancelled(true);
			player.closeInventory();
			break;
		}
	}
	
	
	
	

}
