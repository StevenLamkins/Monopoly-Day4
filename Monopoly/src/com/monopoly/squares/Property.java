package com.monopoly.squares;

import com.monopoly.Player;
import com.monopoly.PlayerData;

public class Property extends Square{
	private int value;
	private int rent;
	private Player owner;
	private String group;
	
	public Property(int position, String name, String group, int value, int rent) {
		super(position, name);
		this.owner = null;
		this.group = group;
		this.value = value;
		this.rent = rent;
	}
	
	public void landOn(Player player)
	{
		if(player == owner)
			return;
		if(owner == null)
		{
			player.purchase(this);
		}
		else {
			player.pay(owner, calculateRent(player));
		}
	}

	protected int calculateRent(PlayerData player) {
		return rent;
	}

	public boolean getOwnable() {
		return true;
	}
	
	public int getValue() {
		return value;
	}

	public int getRent() {
		return rent;
	}
	
	protected void setRent(int newRent) {
		this.rent = newRent;
	}

	public PlayerData getOwner() {
		return owner;
	}

	public void purchase(Player owner) {
		this.owner = owner;
		this.owner.getProperties().add(this);
	}
	
	public String getGroup() {
		return group;
	}

}
