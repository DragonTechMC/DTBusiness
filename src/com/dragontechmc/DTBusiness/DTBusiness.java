package com.dragontechmc.DTBusiness;

import org.spongepowered.api.Game;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.game.state.GameStoppingServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.format.TextColors;

import com.dragontechmc.DTBusiness.commands.*;
import com.google.inject.Inject;

import java.lang.annotation.Annotation;

import org.slf4j.Logger;

@Plugin(id = "DTBsns", name = "DTBusiness", version = "1.0")
public class DTBusiness{
	
	@Inject
    private Game game;
	
	private Logger logger;
	private Plugin plugin;

	@Inject
	private void setLogger(Logger logger) {
	    this.logger = logger;
	}
	
	public Logger getLogger() {
	    return logger;
	}
    
	@Listener
    public void onServerStart(GameStartedServerEvent event) {
		getLogger().info("DTBusiness has started!");
		
		buildCommand();
    }
	
	@Listener
    public void onServerStop(GameStoppingServerEvent event) {
		getLogger().info("DTBusiness has stopped!");
    }
	
	public void buildCommand(){
		CommandSpec myCommandSpec = CommandSpec.builder()
			    .description(Texts.builder("DTBusiness help command").color(TextColors.GOLD).build())
			    .permission("DTBusiness.command.help")
			    .arguments(
			    		GenericArguments.onlyOne(GenericArguments.string(Texts.of("command")))
			    )
			    .executor(new HelpCommand(this))
			    .build();
		
		game.getCommandManager().register(plugin, myCommandSpec, "company", "co");
	}
	
	public Game getGame() {
        return game;
    }
}