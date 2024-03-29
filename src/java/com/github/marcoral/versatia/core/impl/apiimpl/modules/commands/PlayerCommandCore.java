package com.github.marcoral.versatia.core.impl.apiimpl.modules.commands;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.marcoral.versatia.core.api.modules.VersatiaModule;
import com.github.marcoral.versatia.core.api.modules.commands.VersatiaPlayerCommand;

public class PlayerCommandCore extends CommandCore<VersatiaPlayerCommand> {
	private int argsOffset;
	public PlayerCommandCore(VersatiaModule module, VersatiaPlayerCommand descriptor, int argsOffset) {
		super(module, descriptor);
		this.argsOffset = argsOffset;
	}
	
	@Override
	protected boolean handleConditionsCheck(CommandSender commandSender, String accessor, String[] args) {
        return CommandTools.handleConditionCheckExecutorIsPlayer(commandSender) && super.handleConditionsCheck(commandSender, accessor, args);
	}

	@Override
	public boolean passedExecutionConditionsCheck(CommandSender commandSender, String accessor, String[] args) {
		return descriptor.invoked(new PlayerCommandContextImpl(module, (Player) commandSender, args, argsOffset));
	}

	@Override
	public List<String> passedTabCompletionConditionsCheck(CommandSender commandSender, String accessor, String[] args, Location location) {
		return descriptor.tabComplete(new PlayerTabCompletionContextImpl((Player) commandSender, args, argsOffset, location));
	}
}