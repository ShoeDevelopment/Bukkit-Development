package com.shoedevelopment.tutorial;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin; //Only the main file needs to extend the JavaPlugin.

import net.md_5.bungee.api.ChatColor;

public class PlayerTutorial extends JavaPlugin {

	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();

		logger.info(pdfFile.getName() + " has been enabled! (V. " + pdfFile.getVersion() + " )");
	}

	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();

		logger.info(pdfFile.getName() + " has been disabled! (V. " + pdfFile.getVersion() + " )");
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// CommandSender -> Who sent the command.
		// Command -> The actual command.
		// label -> /msg Shoe Hello label: msg
		// string[] args -> first (0 technically) array position: "Shoe", second
		// array position: "Hello"
		
		// Purpose: Player does /hello, server says "Hello!"
		Player player = (Player) sender;
		if (label.equalsIgnoreCase("Hello")) {

			if (!(isPlayerCheck(sender))) 
				return false;
			// This safecasts it. We DEFINITELY
												// know it's a player, so we
												// force it to become type
												// "player"
			player.sendMessage(ChatColor.AQUA + "Hello there " + player.getName() + "!");
			return true;
		}
		
		else if (label.equalsIgnoreCase("healmenow")) {
			int playersCurrentEXP = player.getLevel();

			
			if (playersCurrentEXP > 0) 
			{
				player.damage(1);
				player.sendMessage(ChatColor.AQUA + "No heals for you!");
				return true;
			}
			
			else if (playersCurrentEXP > 5) {
				player.damage(2);
				player.sendMessage(ChatColor.AQUA + "You should know better!");
			}
			
			else if (playersCurrentEXP > 20) {
				player.damage(5);
				player.sendMessage(ChatColor.AQUA + "Getting vindictive now.");
			}
			
			else if (playersCurrentEXP == 30) {
				player.damage(10);
				player.sendMessage("Pls refrain from getting free heals.");
			}
			
			return true;
		}
		
		
		return false;
	}
	
	public boolean isPlayerCheck(CommandSender sender) {
		if (!(sender instanceof Player)) 
		{
			sender.sendMessage("You must be a player to use this command.");
			return false;
		}
		
		return true;
		
	}

}
