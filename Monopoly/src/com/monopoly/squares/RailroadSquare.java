package com.monopoly.squares;

import com.monopoly.Player;

public class RailroadSquare extends PropertySquare {

	public RailroadSquare(int index) {
		super(index);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int collectRent(Player player) {
		owner.credit(rents[position]);
		return rents[position];
	}

}
