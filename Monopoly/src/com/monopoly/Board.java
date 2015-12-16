package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Board {
	List<Square> squares;
	
	
	public Board()
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
		
		squares.add(new GoSquare(0));
		
		for (int i =1; i < 40; i++)
		{
			if(i == 38)
			{
				LuxurySquare luxSquare = new LuxurySquare(38);
				squares.add(luxSquare);
			}
			else if(i==4)
			{
				IncomeTaxSquare incomeTaxSquare = new IncomeTaxSquare(4);
				squares.add(incomeTaxSquare);
			}
			else
			{
				Square temp = new Square(i,"Square " + i);
				squares.add(temp);	
			}

		}
	}
	
	public List<Square> getSquares(){
		return squares;
	}

	public Square getStartSquare() {
		return squares.get(0);
	}
}
