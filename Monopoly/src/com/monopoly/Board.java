package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Board {
	List<Square> squares;
	
	
	public Board(int numPlayers)
	{
		squares = new ArrayList<>();
		
		buildSquares();
		
		linkSquares();
		
		Square firstSquare = squares.get(0);
		squares.get(squares.size()-1).changeNextSquare(firstSquare);
		
	}

	private void linkSquares() {
		for (int x = 0; x < 39; x++)
		{
			Square nextSquare = squares.get(x+1);
			squares.get(x).changeNextSquare(nextSquare);
		}
	}

	private void buildSquares() {
		for (int i =0; i < 40; i++)
		{
			Square temp = new Square("Square " + i);
			squares.add(temp);	
		}
	}
	
	public List<Square> getSquares(){
		return squares;
	}

	public Square getStartSquare() {
		return squares.get(0);
	}
}
