package com.theparkmc.simonsays.listeners.player;

//Add Imports here

public class PlayerJoin extends SSListener {
  
  public PlayerJoin(SimonSays pl) {
    super(pl);
  }
  
  //GUI Kit Selection + 16 per server and 4 min
  
  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
    ArrayList<String> kitlore = new ArrayList<String>();
    Player player = event.getPlayer();
    
    event.setJoinMessage(ChatColor.AQUA + player.getName() + ChatColor.GREEN + "has joined " + ChatColor.DARK_GREEN + "Simon Says! " + ChatColor.RED + "( " + ChatColor.LIGHT_PURPLE + Bukkit.getOnlinePlayers()++; + "/16 " + ChatColor.RED + ")");
    
    Game.setCanStart(Bukkit.getOnlinePlayer().length >= 4);
    
    ItemStack kit = new ItemStack(Material.EMERALD);
    ItemMeta kitmeta = kit.getItemMeta();
    kitmeta.setDisplayName(ChatColor.GREEN + "Kit Selector " + ChatColor.GRAY + "(Right-Click)");
    kitlore.add(ChatColor.GRAY + "Right-click to select a kit!");
    kitmeta.setLore(kitlore);
    kit.setItemMeta(kitmeta);
    
    player.getInventory().setItem(4, kit);
    
  }
  
}
