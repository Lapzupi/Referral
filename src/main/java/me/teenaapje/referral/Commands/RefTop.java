package me.teenaapje.referral.Commands;

import java.util.List;

import me.teenaapje.referral.Utils.TopPlayer;
import me.teenaapje.referral.Utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class RefTop extends CommandBase {
	// init class
	public RefTop() {
		 permission = "RefTop";
		 command = "top";
		 forPlayerOnly = false;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// get top players
		List<TopPlayer> topPlayers = core.db.GetTopPlayers(0,9);
		
		for (TopPlayer topPlayer : topPlayers) {
			Utils.SendMessage(sender, topPlayer.playerPos + " - " + topPlayer.playerName + " : " + topPlayer.totalRefers);
		}
		
		return true;
	}
}