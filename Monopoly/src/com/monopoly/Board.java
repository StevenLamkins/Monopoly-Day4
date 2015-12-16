package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<Square> squares;

	public Board() {
		buildBoard();
		linkSquares();
	}

	private void linkSquares() {
		for (int i = 0; i < squares.size() -1; i++) {
			Square nextSquare = squares.get(i+1);
			squares.get(i).setNextSquare(nextSquare);
		}
		
		squares.get(squares.size()-1).setNextSquare(squares.get(0));
	}

	private void buildBoard() {
		squares = new ArrayList<>();
		for (int i = 0; i < 40; i++) {
			squares.add(new Square());
		}
	}

	public List<Square> getSquares() {
		return squares;
	}
}
