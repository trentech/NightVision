package com.gmail.trentech.permanenteffects;

import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

import com.gmail.trentech.helpme.help.Argument;
import com.gmail.trentech.helpme.help.Help;
import com.gmail.trentech.helpme.help.Usage;
import com.gmail.trentech.permanenteffects.commands.CommandManager;
import com.gmail.trentech.permanenteffects.utils.Resource;

import me.flibio.updatifier.Updatifier;

@Updatifier(repoName = Resource.NAME, repoOwner = Resource.AUTHOR, version = Resource.VERSION)
@Plugin(id = Resource.ID, name = Resource.NAME, version = Resource.VERSION, description = Resource.DESCRIPTION, authors = Resource.AUTHOR, url = Resource.URL, dependencies = { @Dependency(id = "Updatifier", optional = true), @Dependency(id = "helpme", version = "0.2.1", optional = true) })
public class Main {

	private static Logger log;
	private static PluginContainer plugin;

	@Listener
	public void onPreInitializationEvent(GamePreInitializationEvent event) {
		plugin = Sponge.getPluginManager().getPlugin(Resource.ID).get();
		log = getPlugin().getLogger();
	}

	@Listener
	public void onInitializationEvent(GameInitializationEvent event) {
		Sponge.getCommandManager().register(this, new CommandManager().getCmd(), "effects", "e");

		Sponge.getEventManager().registerListeners(this, new EventManager());
		
		if(Sponge.getPluginManager().isLoaded("helpme")) {
			Usage usage = new Usage(Argument.of("<effect>", "Specifies the name of the effect"))
					.addArgument(Argument.of("<on|off>", "Turn or off effect"))
					.addArgument(Argument.of("[player]", "Specify player to apply effect to"));
			
			Help help = new Help("effects", "effects", "Permanently enable or disable effects")
					.setPermission("permanenteffects.cmd.effects")
					.setUsage(usage)
					.addExample("/effects blind on");
			
			Help.register(help);
		}

	}

	public static Logger getLog() {
		return log;
	}

	public static PluginContainer getPlugin() {
		return plugin;
	}
}