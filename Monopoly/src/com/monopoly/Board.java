package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private List<Square> squares;
	
	public Board() {
		squares = new ArrayList<>();
		squares.add(new Square(0, "Go Square"));
		for(int i = 1; i < 40; i++){
			squares.add(new Square(i, "Square " + i));		
		}

		for(int i = 0; i < 39; i++){
			squares.get(i).setNextSquare(squares.get(i+1));
		}
		squares.get(39).setNextSquare(squares.get(0));
	}

	public List<Square> getSquares() {
		return squares;
	}
}
