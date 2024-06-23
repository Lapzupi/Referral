package me.teenaapje.referral.Commands;

import me.teenaapje.referral.database.Database;
import me.teenaapje.referral.ReferralInvites;
import me.teenaapje.referral.utils.ConfigManager;
import me.teenaapje.referral.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;


public class RefReload extends CommandBase {
	// init class
	public RefReload() {
		 permission = "RefReload";
		 command = "Reload";
		 forPlayerOnly = false;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// reload config
		core.reloadConfig();
		core.milestone.LoadRewards();
		
		// reload things
		core.db.CloseConnection();
		core.db = new Database();
		core.rInvites = new ReferralInvites();
		core.config = new ConfigManager();
				
		Utils.SendMessage(sender, "&6[Referral] &fReloaded");
		
		return true;
	}
}