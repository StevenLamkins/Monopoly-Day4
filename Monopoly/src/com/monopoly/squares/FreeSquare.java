package com.monopoly.squares;

import com.monopoly.Player;

public class FreeSquare extends Square {

	public FreeSquare(int index) {
		super(index);
	}

	public int landOnBy(Player player) {
		return 0;
	}
}
