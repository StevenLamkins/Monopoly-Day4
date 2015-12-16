package com.monopoly.squares;

import com.monopoly.board.Move;

public class JailSquare extends PropertySquare {

	public JailSquare(SquareGroup group, int price, int rent) {
		super(group, price, rent);
	}

	@Override
	public void handleMove(Move move) {
		
	}
}
