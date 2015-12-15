package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Board {

	public Board() {
		createSquares();
	}

	private List<Square> squares;
	
	
	public List<Square> getSquares() {
		return squares;
	}


	public void setSquares(List<Square> squares) {
		this.squares = squares;
	}
	
	public Square getStartSquare() {
		return squares.get(0);
	}


	private void createSquares() {
	   squares = new ArrayList<>();
	   squares.add(new Square("Go Square"));
	   for (int i = 1; i < 40; i++) {
			squares.add(new Square("Square" + i));
		}
	}
}
