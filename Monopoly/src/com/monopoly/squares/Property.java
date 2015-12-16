package com.monopoly.squares;

import com.monopoly.Player;

public class Property extends Square{
	private int value;
	private int rent;
	private Player owner;
	
	public Property(int position, String name, int value, int rent) {
		super(position, name);
		this.owner = null;
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
			player.pay(owner, rent);
		}
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

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

}
