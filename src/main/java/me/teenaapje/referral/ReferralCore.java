package me.teenaapje.referral;

import java.util.List;

import me.teenaapje.referral.Commands.CommandManager;
import me.teenaapje.referral.Database.Database;
import me.teenaapje.referral.PlaceHolders.PlaceHolders;
import me.teenaapje.referral.Utils.ConfigManager;
import me.teenaapje.referral.Utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;



public class ReferralCore extends JavaPlugin{
	public static ReferralCore core;
	
	public ConfigManager config;
	public ReferralInvites rInvites;
	public ReferralMilestone milestone;
	public Database db;
	
	public void onEnable() {
		saveDefaultConfig();
		// set the plugin
		ReferralCore.core = this;
		
		// get the config
		config 		= new ConfigManager();
		rInvites 	= new ReferralInvites(); 
		milestone 	= new ReferralMilestone();
		db 			= new Database();
		
		// set placeholders if papi is there
		if (ConfigManager.placeholderAPIEnabled) {
			new PlaceHolders().register();
		}
		
		new CommandManager();
		
		new ReferralEvents();
		
		Utils.Console("[Referrel] Initialized - Enjoy");
	}
	
	public void onDisable() {
		db.CloseConnection();
	}
	
	
	@SuppressWarnings("deprecation")
	public Player GetPlayer(String name) {
		Player player = this.getServer().getPlayer(name);
		if (player != null) {
			return player;
		}
		
		return getServer().getOfflinePlayer(name).getPlayer();
	}
	
	public void UseCommands(List<?> commands, Player player) {
		for (int i = 0; i < commands.size(); i++) {
			String command = (String) commands.get(i);

			getServer().getScheduler().runTask(this, new Runnable() {
				@Override
				public void run() {
					getServer().dispatchCommand(getServer().getConsoleSender(), command.replace("<player>", player.getName()));
				}
		    });
		}
	}
	
}
