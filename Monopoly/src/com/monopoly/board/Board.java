package com.monopoly.board;

import java.util.Arrays;
import java.util.List;

public class Board {
	private List<Square> squares;
	
	public Board() {
		squares = Arrays.asList(Square.values());
	}
	
	public int getNumSquares() {
		return squares.size();
	}
	
	public Square getSquareAt(int position) {
		return squares.get(position);
	}
	
	public int getSquarePosition(Square s) {
		return squares.indexOf(s);
	}
}
