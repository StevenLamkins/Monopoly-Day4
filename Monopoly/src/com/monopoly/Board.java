package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private List<Square> squares;

	public Board() {
		
		buildSquares();
		linkSquares();
	}

	private void linkSquares() {
		int lastElement = squares.size() -1;
		squares.get(lastElement).setNextSquare(squares.get(0));
		
		for (int i = 0; i < lastElement; i++) {
			squares.get(i).setNextSquare(squares.get(i+1));
		}
	}

	private void buildSquares() {
		squares = new ArrayList<>();
		squares.add(new Square("Go"));
		for (int i = 1; i < 40; i++) {			
			squares.add(new Square("Square" + i));			
		}
	}

	public List<Square> getSquares() {
		return this.squares;
	}

	public Square getStartSquare() {		
		return squares.get(0);
	}

}
