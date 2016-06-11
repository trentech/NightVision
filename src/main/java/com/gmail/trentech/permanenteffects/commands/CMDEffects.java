package com.gmail.trentech.permanenteffects.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.service.pagination.PaginationList.Builder;
import org.spongepowered.api.service.pagination.PaginationService;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import com.gmail.trentech.permanenteffects.Main;
import com.gmail.trentech.permanenteffects.utils.ConfigManager;

public class CMDEffects implements CommandExecutor {

	protected static HashMap<String, Text> map = new HashMap<>();
	
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		Builder pages = Main.getGame().getServiceManager().provide(PaginationService.class).get().builder();
		
		pages.title(Text.builder().color(TextColors.DARK_GREEN).append(Text.of(TextColors.GREEN, "Command List")).build());
		
		List<Text> list = new ArrayList<>();
		
		for(Entry<String, Text> entry : map.entrySet()) {
			String[] arg = entry.getKey().split(":");
			
			if(src.hasPermission("permanenteffects.cmd.effects." + arg[0]) && new ConfigManager().getConfig().getNode(arg[1], "enable").getBoolean()) {
				list.add(entry.getValue());
			}
		}

		pages.contents(list);
		
		pages.sendTo(src);

		return CommandResult.success();
	}
}
