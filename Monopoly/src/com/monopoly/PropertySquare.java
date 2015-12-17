package com.monopoly;

public abstract class  PropertySquare extends Square {

	private Player owner;
	private Player currentRoller;
	private int price;


	public PropertySquare(String name, int price) {
		super(name);
		this.price = price;
		owner = null;
	}

	@Override
	public void landOn(Player player) {

		setCurrentRoller(player);
		
		if (isForSale() && player.getAccountBalance() >= price) {
			player.debit(price);
			owner = player;
		}
		else if (!isForSale())
		{
			player.debit(chargeRent());
			owner.credit(chargeRent());
		}
	}

	private boolean isForSale() {
		return owner == null;
	}

	private void setCurrentRoller(Player player) {
		currentRoller = player;
		
	}

	public Player getCurrentRoller() {
		return currentRoller;
	}

	@Override
	public void passOver(Player player) {
		// TODO Auto-generated method stub

	}

	public Object getOwner() {
		// TODO Auto-generated method stub
		return owner;
	}

	public int getPrice() {
		return price;
	}
	public abstract int chargeRent();
	
	public abstract Group getGroup();

}
