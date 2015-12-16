package com.monopoly.squares;

import com.monopoly.Player;

public class UtilitySquare extends PropertySquare {

	public UtilitySquare(int index) {
		super(index);
		// TODO Auto-generated constructor stub
	}

	public Player getOwner() {
		return owner;
	}

	@Override
	public int collectRent(Player player) {
		int rent = 4 * player.getLastRoll();
		owner.credit(rent);
		return rent;
	}

}
