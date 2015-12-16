package com.monopoly;

public class PropertySquare extends Square {
	
	private Player owner;

	public PropertySquare(String name, int squareNumber) {
		super(name, squareNumber);
	}
	
	public Player getOwner() {
		return owner;
	}

	public int getPrice() {
		return squareNumber * 10;
	}
	
	@Override
	public void landedOnBy(Player player) {
		if (owner != null) return;
		if (player.getBalance() >= getPrice()) {
			owner = player;
			player.decrementBalance(getPrice());
		}
	}
	
}
