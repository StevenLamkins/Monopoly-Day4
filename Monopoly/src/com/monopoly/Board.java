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
		
		
		
		
		switch(int )
		{
			case 0: squares.add(new GoSquare(0));
			break;
			
			case 1: squares.add(new Lot(1, "Mediteranean Avenue"));
			break;
			
			case 2: squares.add(new CC(2, "Community Chest"));
			break;
			
			case 3: squares.add(new Lot(3, "Baltic Avenue"));
			break;
			
			case 4: squares.add(new IncomeTaxSquare(4, "Income Tax"));
			break;
			
			case 1: squares.add(new Lot(1, "Mediteranean Avenue"));
			break;
			
			case 1: squares.add(new Lot(1, "Mediteranean Avenue"));
			break;
			
			case 1: squares.add(new Lot(1, "Mediteranean Avenue"));
			break;
			
			case 1: squares.add(new Lot(1, "Mediteranean Avenue"));
			break;
			
			case 1: squares.add(new Lot(1, "Mediteranean Avenue"));
			break;
			
			case 1: squares.add(new Lot(1, "Mediteranean Avenue"));
			break;
			
			case 1: squares.add(new Lot(1, "Mediteranean Avenue"));
			break;
			
			case 1: squares.add(new Lot(1, "Mediteranean Avenue"));
			break;
			
			case 1: squares.add(new Lot(1, "Mediteranean Avenue"));
			break;
			
			case 1: squares.add(new Lot(1, "Mediteranean Avenue"));
			break;
			
			case 1: squares.add(new Lot(1, "Mediteranean Avenue"));
			break;
			
			case 1: squares.add(new Lot(1, "Mediteranean Avenue"));
			break;
			
			case 1: squares.add(new Lot(1, "Mediteranean Avenue"));
			break;
			
			case 1: squares.add(new Lot(1, "Mediteranean Avenue"));
			break;
			
			case 1: squares.add(new Lot(1, "Mediteranean Avenue"));
			break;
			
			case 1: squares.add(new Lot(1, "Mediteranean Avenue"));
			break;
			
			case 1: squares.add(new Lot(1, "Mediteranean Avenue"));
			break;
			
		}
		
		
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
