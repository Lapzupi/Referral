package me.teenaapje.referral;

import java.util.List;

public class Reward {
    public int min;
	public List<String> commands;
 
	public Reward (int min,	List<String> commands){
        this.min = min;
        this.commands = commands;
    }
}
