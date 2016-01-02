package com.dragontechmc.DTBusiness.commands;

import java.util.ArrayList;
import java.util.List;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.source.CommandBlockSource;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.pagination.PaginationBuilder;
import org.spongepowered.api.service.pagination.PaginationService;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;

import com.dragontechmc.DTBusiness.DTBusiness;

public class HelpCommand implements CommandExecutor {
	
	DTBusiness plugin = null;
	
	public HelpCommand(DTBusiness plugin){
		this.plugin = plugin;
	}
	
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        
    	String command = args.<String>getOne("command").get();
    	
    	PaginationService paginationService = plugin.getGame().getServiceManager().provide(PaginationService.class).get();
    	PaginationBuilder builder = paginationService.builder();
    	
    	List<Text> contents = new ArrayList<>();
    	
    	if (command.equals("help") || command.equals("?")){
    		if(src instanceof Player) {
    			//if (src.hasPermission("DTBusiness.command.create"))
    				contents.add(Texts.of("/co create TBA"));
    			//if (src.hasPermission("DTBusiness.command.delete"))
    				contents.add(Texts.of("/co delete TBA"));
    			//if (src.hasPermission("DTBusiness.command.invite"))
    				contents.add(Texts.of("/co invite TBA"));
    			
    	    	builder.title(Texts.of("DTBusiness help"))
    	        .contents(contents)
    	        .header(Texts.of(""))
    	        .footer(Texts.of(""))
    	        .paddingString("=")
    	        .sendTo(src);
        	}
        	else if(src instanceof ConsoleSource) {
        		src.sendMessage(Texts.of("-- DTBusiness plugin help --"));
        		src.sendMessage(Texts.of("/co create TBA"));
        		src.sendMessage(Texts.of("/co delete TBA"));
        		src.sendMessage(Texts.of("/co invite TBA"));
        	}
        	else if(src instanceof CommandBlockSource) {
        	    
        	}
    	}
    	
        return CommandResult.success();
    }
}