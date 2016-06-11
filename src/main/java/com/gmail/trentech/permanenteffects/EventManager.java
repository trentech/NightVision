package com.gmail.trentech.permanenteffects;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

import org.spongepowered.api.data.manipulator.mutable.PotionEffectData;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.DestructEntityEvent;
import org.spongepowered.api.event.entity.living.humanoid.player.RespawnPlayerEvent;

public class EventManager {

	public static HashMap<UUID, PotionEffectData> hash = new HashMap<>();

    @Listener
    public void onDestructEntityEvent(DestructEntityEvent.Death event) {
    	if(!(event.getTargetEntity() instanceof Player)) {
    		return;
    	}
    	Player player = (Player) event.getTargetEntity();
    	UUID uuid = player.getUniqueId();
    	
    	Optional<PotionEffectData> optionalEffects = player.get(PotionEffectData.class);
    	
    	if(optionalEffects.isPresent()) {
    		hash.put(uuid, optionalEffects.get());
    	}
    }
    
	@Listener
	public void onRespawnPlayerEvent(RespawnPlayerEvent event) {
		Player player = event.getTargetEntity();
		UUID uuid = player.getUniqueId();
		
		if(hash.containsKey(uuid)) {
			Main.getGame().getScheduler().createTaskBuilder().delayTicks(10).execute(e -> {
				player.offer(hash.get(uuid));
				hash.remove(uuid);
			}).submit(Main.getPlugin());
		}
	}
}