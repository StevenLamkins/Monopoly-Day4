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
		
		
		
		for (int i =1; i < 40; i++)
		{
			checkCase(i);
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

	private void checkCase(int i) {
		
		switch( i )
		{
			case 0: squares.add(new GoSquare(0));
			break;
			
			case 1: squares.add(new Lot(1, "Mediteranean Avenue"));
			break;
			
			case 2: squares.add(new CC(2, "Community Chest"));
			break;
			
			case 3: squares.add(new Lot(3, "Baltic Avenue"));
			break;
			
			case 4: squares.add(new IncomeTaxSquare(4));
			break;
			
			case 5: squares.add(new RailRoad(5, "Reading Railroad"));
			break;
			
			case 6: squares.add(new Lot(6,"Oriental Avenue") );
			break;
			
			case 7: squares.add(new Chance(7));
			break;
			
			case 8:squares.add(new Lot(8,"Vermont Avenue"));
			break;
			
			case 9:squares.add(new Lot(9,"Connecticut Avenue"));
			break;
			
			case 10:squares.add(new Jail(10));
			break;
			
			case 11:squares.add(new Lot(11,"Saint Charles Place"));
			break;
			
			case 12:squares.add(new Utilities(12,"Electric Company"));
			break;
			
			case 13:squares.add(new Lot(13,"States Avenue"));
			break;
			
			case 14:squares.add(new Lot(14,"Virgnia Avenue"));
			break;
				
			case 15:squares.add(new RailRoad(15,"Pennsylvania Railroad"));
			break;
			
			case 16:squares.add(new Lot(16,"St. James Place"));
			break;
			
			case 17:squares.add(new CC(17,"CommunityChest"));
			break;
			
			
			
			
				
}
	}
	
	public List<Square> getSquares(){
		return squares;
	}

	public Square getStartSquare() {
		return squares.get(0);
	}
}
