package com.theparkmc.simonsays.listeners.entity;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamage extends SSListener {
  
  public EntityDamage (SimonSays pl) {
    super(pl);
  }
  
  @EventHandler
  public void onHit(EntityDamageByEntityEvent event) {
    Player player = (Player) e.getEntity();
		Player damager = (Player) e.getDamager();
		
    if((!(e.getEntity() instanceof Player) && e.getDamager() instanceof Player)){
			e.setCancelled(true);
    }
  }
  
}
