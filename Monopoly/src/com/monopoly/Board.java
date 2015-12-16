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
		for (int i =0; i < 40; i++)
		{
			checkCase(i);
		}

	}

	private void checkCase(int i) {
		
		switch( i )
		{
			case 0: squares.add(new GoSquare(0));
			break;
			
			case 1: squares.add(new Lot(1, "Mediteranean Avenue"));
			break;
			
			case 2: squares.add(new CommunityChest(2));
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
			
			case 17:squares.add(new CommunityChest(17));
			break;
			
			case 18:squares.add(new Lot(18,"Tennessee Avenue"));
			break;
			
			case 19:squares.add(new Lot(19,"New York Avenue"));
			break;
			
			case 20:squares.add(new FreeParking(20));
			break;
			
			case 21:squares.add(new Lot(21,"Kentucky Avenue"));
			break;
			
			case 22:squares.add(new Chance(22));
			break;
			
			case 23:squares.add(new Lot(23,"Indiana Avenue"));
			break;
			
			case 24:squares.add(new Lot(24,"Illinois Avenue"));
			break;
			
			case 25:squares.add(new RailRoad(25,"B&O RailRoad"));
			break;
			
			case 26:squares.add(new Lot(26,"Atlantic Avenue"));
			break;
			
			case 27:squares.add(new Lot(27,"Vetnor Avenue"));
			break;
			
			case 28:squares.add(new Utilities(28,"Water Works"));
			break;
			
			case 29:squares.add(new Lot(29,"Marvin Gardens"));
			break;
			
			case 30:squares.add(new GoToJail(30));
			break;
			
			case 31:squares.add(new Lot(31,"Pacific Avenue"));
			break;
			
			case 32:squares.add(new Lot(32,"North Carolina Avenue"));
			break;
			
			case 33:squares.add(new CommunityChest(33));
			break;
			
			case 34:squares.add(new Lot(34,"Pennsylvania Avenue"));
			break;
			
			case 35:squares.add(new RailRoad(35,"Shortline Railroad"));
			break;
			
			case 36:squares.add(new Chance(36));
			break;
			
			case 37:squares.add(new Lot(37,"Park Place"));
			break;
			
			case 38:squares.add(new LuxurySquare(38));
			break;
			
			case 39:squares.add(new Lot(39,"Boardwalk"));
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
