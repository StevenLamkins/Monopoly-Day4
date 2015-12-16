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
		squares = new ArrayList<>();
		squares.add(new GoSquare("Go"));
		for (int i = 1; i < 40; i++) {
			
			
			switch (i) {
			case 0:
				squares.add(new GoSquare("Go"));
				break;
			case 3:
				squares.add(new LotSquare("Baltic Avenue", 2,  60, Group.DarkBlue));
				break;
			case 4:
				squares.add(new IncomeTax("Square" + i));
				break;	
			case 38:
				squares.add(new LuxeryTaxSquare("Luxury Tax " + (i)));
				break;				

			default:
				squares.add(new BlankSquare("Square" + i));
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
