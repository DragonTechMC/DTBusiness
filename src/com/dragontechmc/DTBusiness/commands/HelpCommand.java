package com.dragontechmc.DTBusiness.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.source.CommandBlockSource;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Texts;

public class HelpCommand implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        
    	String command = args.<String>getOne("command").get();
    	
    	if (command.equals("help") || command.equals("?")){
    		if(src instanceof Player) {
    			if (src.hasPermission("DTBusiness"))
    				src.sendMessage(Texts.of("-- DTBusiness plugin help --"));
        	}
        	else if(src instanceof ConsoleSource) {
        		src.sendMessage(Texts.of("-- DTBusiness plugin help --"));
        	}
        	else if(src instanceof CommandBlockSource) {
        	    
        	}
    	}
    	
        return CommandResult.success();
    }
}