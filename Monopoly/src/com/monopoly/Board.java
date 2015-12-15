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


	private void createSquares() {
		squares = new ArrayList<>();
	   for (int i = 0; i < 40; i++) {
			squares.add(new Square(""));
		}
	}
}
