package com.monopoly.board;

import java.util.ArrayList;
import java.util.List;

import com.monopoly.squares.Square;

public class Board {
	private List<Square> squares;
	
	public Board() {
		this.squares = new ArrayList<Square>();
		Square[] squares = Square.values();
		
		for (int i=0; i<squares.length; i++) {
			squares[i].setBoardPosition(i);
			this.squares.add(squares[i]);
		}
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
