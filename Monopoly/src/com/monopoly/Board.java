package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	final int NUMBER_OF_SQUARES = 40;
	private List<Square> squares = new ArrayList<>();
	
	
	public Board () {
		for (int i = 0; i < NUMBER_OF_SQUARES; i++) {
			squares.add(new Square());
		}
	}
	
	public List<Square> getSquares() {
		return squares;
	}


}
