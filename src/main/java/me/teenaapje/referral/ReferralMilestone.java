package me.teenaapje.referral;

import java.util.ArrayList;
import java.util.List;

public class ReferralMilestone {
	ReferralCore core = ReferralCore.core;
	
	private List<Reward> rewards;

	public ReferralMilestone() {
		rewards = new ArrayList<>();
		loadRewards();
	}
	
	public void loadRewards() {
		rewards.clear();
		
		for (String key : core.config.rewards.getKeys(false)) {
			Reward reward = new Reward (
				core.config.config.getInt("rewards."+key+".min"),
				core.config.config.getStringList("rewards."+key+".commands")
			);
			rewards.add(reward);
		}
	}
	
	public boolean hasReward(int lastReward, int referd) {
		for (Reward reward : rewards) {
			if (reward.min == referd && lastReward < referd) {
				return true;
			}

			if (reward.min == referd) {
				return false;
			}
		}		
		return false;
	}
	
	public List<String> getRewards(int referTotal) {
		for (Reward reward : rewards) {
			if (reward.min == referTotal) {
				return reward.commands;
			}
		}
		// this should not be able to return null if so the HasAReward function isnt working correct
		return null;
	}

	public List<Reward> getRewards() {
		return rewards;
	}

	public void setRewards(List<Reward> rewards) {
		this.rewards = rewards;
	}
}

