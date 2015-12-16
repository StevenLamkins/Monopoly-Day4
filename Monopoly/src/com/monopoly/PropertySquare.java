package com.monopoly;

public abstract class PropertySquare extends Square {

	public int rent;
	public int price;
	public Player owner = null;

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public PropertySquare(String name, int rent, int price) {
		super(name);
		this.rent = rent;
		this.price = price;
		
	}

	public PropertySquare(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isOwn () {
		if (owner == null)
			return false;
		else 
			return true;
	}
	
}
