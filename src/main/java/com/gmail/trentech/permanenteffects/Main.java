package com.gmail.trentech.permanenteffects;

import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

import com.gmail.trentech.permanenteffects.commands.CommandManager;
import com.gmail.trentech.permanenteffects.utils.Resource;

import me.flibio.updatifier.Updatifier;

@Updatifier(repoName = "PermanentEffects", repoOwner = "TrenTech", version = Resource.VERSION)
@Plugin(id = Resource.ID, name = Resource.NAME, authors = Resource.AUTHOR, url = Resource.URL, dependencies = {@Dependency(id = "Updatifier", optional = true)})
public class Main {

	private static Game game;
	private static Logger log;
	private static PluginContainer plugin;	

	@Listener
    public void onPreInitializationEvent(GamePreInitializationEvent event) {
		game = Sponge.getGame();
		plugin = getGame().getPluginManager().getPlugin(Resource.ID).get();
		log = getPlugin().getLogger();
	}

	@Listener
    public void onInitializationEvent(GameInitializationEvent event) {
		getGame().getCommandManager().register(this, new CommandManager().getCmd(), "effects", "e");
		
		getGame().getEventManager().registerListeners(this, new EventManager());	
	}

	public static Game getGame() {
		return game;
	}

	public static Logger getLog() {
		return log;
	}

	public static PluginContainer getPlugin() {
		return plugin;
	}
}