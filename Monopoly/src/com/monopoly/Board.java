package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Board {
	List<Square> squares;
	
	
	public Board(int numPlayers){
		squares = new ArrayList<>();
		for (int i =0; i < 40; i++)
		{
			Square temp = new Square();
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
