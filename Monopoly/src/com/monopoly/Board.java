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
	   int next = 1;
	   for (Square sq : squares) {
		   if (next == 40){
			   sq.setNextSquare(squares.get(0));
		   } else {	   
			   sq.setNextSquare(squares.get(next++));
		   }
		}
	 }
	
	public void printBoard() {
		for (Square sq : squares) {
			System.out.println(sq.getName() + "->" + sq.next().getName());
		}
	}
}
