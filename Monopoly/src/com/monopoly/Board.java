package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	int BOARD_SQUARE_COUNT=40;
	List<Square> squares = new ArrayList<>();
	
	public Board(){
		for (int i = 0; i < BOARD_SQUARE_COUNT; i++) {
			Square newSquare = new Square(Integer.toString(i)) ;
			squares.add(newSquare);
		}
	}//end Board constructor

	public List<Square> getSquares() {
		return squares;
	}
	
	
}//end Board
