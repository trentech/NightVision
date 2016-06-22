package com.gmail.trentech.permanenteffects.commands;

import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.command.spec.CommandSpec.Builder;
import org.spongepowered.api.text.Text;

import com.gmail.trentech.permanenteffects.utils.ConfigManager;

import ninja.leaping.configurate.ConfigurationNode;

public class CommandManager {

	private CommandSpec cmdAbsorbtion = CommandSpec.builder()
			.permission("nightvision.cmd.effects.absorbtion")
			.arguments(GenericArguments.optional(GenericArguments.string(Text.of("value"))), GenericArguments.optional(GenericArguments.string(Text.of("player"))))
			.executor(new CMD.Absorbtion())
			.build();

	private CommandSpec cmdBlind = CommandSpec.builder()
			.permission("nightvision.cmd.effects.blind")
			.arguments(GenericArguments.optional(GenericArguments.string(Text.of("value"))), GenericArguments.optional(GenericArguments.string(Text.of("player"))))
			.executor(new CMD.Blind())
			.build();

	private CommandSpec cmdFire = CommandSpec.builder()
			.permission("nightvision.cmd.effects.fire")
			.arguments(GenericArguments.optional(GenericArguments.string(Text.of("value"))), GenericArguments.optional(GenericArguments.string(Text.of("player"))))
			.executor(new CMD.Fire())
			.build();

	private CommandSpec cmdHaste = CommandSpec.builder()
			.permission("nightvision.cmd.effects.haste")
			.arguments(GenericArguments.optional(GenericArguments.string(Text.of("value"))), GenericArguments.optional(GenericArguments.string(Text.of("player"))))
			.executor(new CMD.Haste())
			.build();

	private CommandSpec cmdHealth = CommandSpec.builder()
			.permission("nightvision.cmd.effects.health")
			.arguments(GenericArguments.optional(GenericArguments.string(Text.of("value"))), GenericArguments.optional(GenericArguments.string(Text.of("player"))))
			.executor(new CMD.Health())
			.build();

	private CommandSpec cmdHunger = CommandSpec.builder()
			.permission("nightvision.cmd.effects.hunger")
			.arguments(GenericArguments.optional(GenericArguments.string(Text.of("value"))), GenericArguments.optional(GenericArguments.string(Text.of("player"))))
			.executor(new CMD.Hunger()).build();

	private CommandSpec cmdFatigue = CommandSpec.builder()
			.permission("nightvision.cmd.effects.fatigue")
			.arguments(GenericArguments.optional(GenericArguments.string(Text.of("value"))), GenericArguments.optional(GenericArguments.string(Text.of("player"))))
			.executor(new CMD.Fatigue())
			.build();

	private CommandSpec cmdInvisible = CommandSpec.builder()
			.permission("nightvision.cmd.effects.invisible")
			.arguments(GenericArguments.optional(GenericArguments.string(Text.of("value"))), GenericArguments.optional(GenericArguments.string(Text.of("player"))))
			.executor(new CMD.Invisible())
			.build();

	private CommandSpec cmdJump = CommandSpec.builder()
			.permission("nightvision.cmd.effects.jump")
			.arguments(GenericArguments.optional(GenericArguments.string(Text.of("value"))), GenericArguments.optional(GenericArguments.string(Text.of("player"))))
			.executor(new CMD.Jump())
			.build();

	private CommandSpec cmdNight = CommandSpec.builder()
			.permission("nightvision.cmd.effects.night")
			.arguments(GenericArguments.optional(GenericArguments.string(Text.of("value"))), GenericArguments.optional(GenericArguments.string(Text.of("player"))))
			.executor(new CMD.Night())
			.build();

	private CommandSpec cmdRegen = CommandSpec.builder()
			.permission("nightvision.cmd.effects.regen")
			.arguments(GenericArguments.optional(GenericArguments.string(Text.of("value"))), GenericArguments.optional(GenericArguments.string(Text.of("player"))))
			.executor(new CMD.Regen())
			.build();

	private CommandSpec cmdResist = CommandSpec.builder()
			.permission("nightvision.cmd.effects.resist")
			.arguments(GenericArguments.optional(GenericArguments.string(Text.of("value"))), GenericArguments.optional(GenericArguments.string(Text.of("player"))))
			.executor(new CMD.Resist())
			.build();

	private CommandSpec cmdSaturation = CommandSpec.builder()
			.permission("nightvision.cmd.effects.saturation")
			.arguments(GenericArguments.optional(GenericArguments.string(Text.of("value"))), GenericArguments.optional(GenericArguments.string(Text.of("player"))))
			.executor(new CMD.Saturation())
			.build();

	private CommandSpec cmdSlow = CommandSpec.builder()
			.permission("nightvision.cmd.effects.slow")
			.arguments(GenericArguments.optional(GenericArguments.string(Text.of("value"))), GenericArguments.optional(GenericArguments.string(Text.of("player"))))
			.executor(new CMD.Slow())
			.build();

	private CommandSpec cmdSpeed = CommandSpec.builder()
			.permission("nightvision.cmd.effects.speed")
			.arguments(GenericArguments.optional(GenericArguments.string(Text.of("value"))), GenericArguments.optional(GenericArguments.string(Text.of("player"))))
			.executor(new CMD.Speed()).build();

	private CommandSpec cmdStrength = CommandSpec.builder()
			.permission("nightvision.cmd.effects.strength")
			.arguments(GenericArguments.optional(GenericArguments.string(Text.of("value"))), GenericArguments.optional(GenericArguments.string(Text.of("player"))))
			.executor(new CMD.Strength())
			.build();

	private CommandSpec cmdWater = CommandSpec.builder()
			.permission("nightvision.cmd.effects.water")
			.arguments(GenericArguments.optional(GenericArguments.string(Text.of("value"))), GenericArguments.optional(GenericArguments.string(Text.of("player"))))
			.executor(new CMD.Water())
			.build();

	private CommandSpec cmdWeak = CommandSpec.builder()
			.permission("nightvision.cmd.effects.weak")
			.arguments(GenericArguments.optional(GenericArguments.string(Text.of("value"))), GenericArguments.optional(GenericArguments.string(Text.of("player"))))
			.executor(new CMD.Weak())
			.build();

	private CommandSpec cmdWither = CommandSpec.builder()
			.permission("nightvision.cmd.effects.wither")
			.arguments(GenericArguments.optional(GenericArguments.string(Text.of("value"))), GenericArguments.optional(GenericArguments.string(Text.of("player"))))
			.executor(new CMD.Wither())
			.build();

	public CommandSpec getCmd() {
		Builder cmd = CommandSpec.builder().permission("nightvision.cmd.effects").executor(new CMDEffects());

		ConfigurationNode config = new ConfigManager().getConfig();

		if (config.getNode("absorbtion", "enable").getBoolean()) {
			cmd.child(cmdAbsorbtion, "absorbtion", "a");
		}
		if (config.getNode("blindness", "enable").getBoolean()) {
			cmd.child(cmdBlind, "blind", "b");
		}
		if (config.getNode("fire_resistance", "enable").getBoolean()) {
			cmd.child(cmdFire, "fire", "f");
		}
		if (config.getNode("haste", "enable").getBoolean()) {
			cmd.child(cmdHaste, "haste", "h");
		}
		if (config.getNode("health_boost", "enable").getBoolean()) {
			cmd.child(cmdHealth, "health", "hb");
		}
		if (config.getNode("hunger", "enable").getBoolean()) {
			cmd.child(cmdHunger, "hunger", "hg");
		}
		if (config.getNode("mining_fatigue", "enable").getBoolean()) {
			cmd.child(cmdFatigue, "fatigue", "f");
		}
		if (config.getNode("invisibility", "enable").getBoolean()) {
			cmd.child(cmdInvisible, "invisible", "i");
		}
		if (config.getNode("jump_boost", "enable").getBoolean()) {
			cmd.child(cmdJump, "jump", "j");
		}
		if (config.getNode("night_vision", "enable").getBoolean()) {
			cmd.child(cmdNight, "night", "n");
		}
		if (config.getNode("regeneration", "enable").getBoolean()) {
			cmd.child(cmdRegen, "regen", "r");
		}
		if (config.getNode("resistance", "enable").getBoolean()) {
			cmd.child(cmdResist, "resistance", "rs");
		}
		if (config.getNode("saturation", "enable").getBoolean()) {
			cmd.child(cmdSaturation, "saturation", "sat");
		}
		if (config.getNode("slowness", "enable").getBoolean()) {
			cmd.child(cmdSlow, "slow", "sl");
		}
		if (config.getNode("speed", "enable").getBoolean()) {
			cmd.child(cmdSpeed, "speed", "s");
		}
		if (config.getNode("strength", "enable").getBoolean()) {
			cmd.child(cmdStrength, "strength", "st");
		}
		if (config.getNode("water_breathing", "enable").getBoolean()) {
			cmd.child(cmdWater, "water", "wb");
		}
		if (config.getNode("weakness", "enable").getBoolean()) {
			cmd.child(cmdWeak, "weak", "wk");
		}
		if (config.getNode("wither", "enable").getBoolean()) {
			cmd.child(cmdWither, "wither", "w");
		}

		return cmd.build();
	}
}
