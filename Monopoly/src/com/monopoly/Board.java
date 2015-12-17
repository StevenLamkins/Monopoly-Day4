package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private List<Square> squares;

	public Board() {
		
		buildSquares();
		linkSquares();
	}

	private void linkSquares() {
		int lastElement = squares.size() -1;
		squares.get(lastElement).setNextSquare(squares.get(0));
		
		for (int i = 0; i < lastElement; i++) {
			squares.get(i).setNextSquare(squares.get(i+1));
		}
	}
 
	private void buildSquares() {
		squares = new ArrayList<Square>();
		squares.add(new GoSquare("Go"));
		for (int i = 1; i < 40; i++) {
			
			
			switch (i) {
			case 0:
				squares.add(new GoSquare("Go"));
				break;
			case 1: case 3:	case 6: case 8: case 9: case 11: case 13: case 14:
			case 16: case 18: case 19: case 21: case 23: case 24: case 26: case 27:
			case 29: case 31: case 32: case 34: case 37: case 39:
				squares.add(new LotSquare("Lot Square " + i, i,  (i+1)*10, Group.Cyan));
				break;
			case 4:
				squares.add(new IncomeTax("Square " + i));
				break;
			case 5: case 15: case 25: case 359:
				squares.add(new RailRoadSquare("RailRoad Square " + i, 25,  200, Group.Railroad));
				break;
			case 28: case 12:
				squares.add(new UtilitySquare("Utility Square " + i, i, (i+1)*10, Group.Utility));
				break;
			case 38:
				squares.add(new LuxeryTaxSquare("Luxury Tax " + (i)));
				break;				

			default:
				squares.add(new BlankSquare("Square " + i));
				break;
			}
		
			System.out.println(squares.get(i).getName());
		}
		
	}

	public List<Square> getSquares() {
		return this.squares;
	}

	public Square getStartSquare() {		
		return squares.get(0);
	}

}
