package com.gmail.trentech.nightvision;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.manipulator.mutable.PotionEffectData;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.serializer.TextSerializers;

public class CMDLight implements CommandExecutor {

	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		if(!(src instanceof Player)){
			src.sendMessage(Text.of(TextColors.DARK_RED, "Must be a player"));
			return CommandResult.empty();
		}
		Player player = (Player) src;

		if(!args.hasAny("value")) {
			src.sendMessage(Text.of(TextColors.YELLOW, "/light <on/off>"));
			return CommandResult.empty();
		}
		String value = args.<String>getOne("value").get();

		if(value.equalsIgnoreCase("on")) {
			PotionEffect effect = Main.getGame().getRegistry().createBuilder(PotionEffect.Builder.class).potionType(PotionEffectTypes.NIGHT_VISION).duration(1000000).amplifier(1).particles(false).build();

			PotionEffectData effects = player.getOrCreate(PotionEffectData.class).get();
            effects.addElement(effect);
            
            player.offer(effects);
            
            player.sendMessage(TextSerializers.FORMATTING_CODE.deserialize(new ConfigManager().getConfig().getNode("message_on").getString()));
		}else if (value.equalsIgnoreCase("off")) {
            PotionEffectData effects = player.getOrCreate(PotionEffectData.class).get();
            
            for(PotionEffect effect : effects.asList()) {
                if(effect.getType() == PotionEffectTypes.NIGHT_VISION) {
                    effects.remove(effect);
                }
            }
            
            player.offer(effects);
            
            player.sendMessage(TextSerializers.FORMATTING_CODE.deserialize(new ConfigManager().getConfig().getNode("message_off").getString()));
		}else {
			src.sendMessage(Text.of(TextColors.YELLOW, "/light <on/off>"));
			return CommandResult.empty();
		}
		return CommandResult.success();
	}
}
