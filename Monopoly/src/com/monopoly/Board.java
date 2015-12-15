package com.monopoly;

public class Board {
	private Square[] squares;
	
	public Board() {
		squares = Square.values();
	}
	
	public int getNumSquares() {
		return squares.length;
	}
	
	public Square getSquareAt(int position) {
		return squares[position];
	}
}
