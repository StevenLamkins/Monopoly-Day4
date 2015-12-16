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
		for (int i = 0; i < squares.size() - 1; i++) {
			Square nextSquare = squares.get(i+1);
			squares.get(i).setNextSquare(nextSquare);
		}
		
		squares.get(squares.size()-1).setNextSquare(getStartSquare());
	}

	private void buildSquares() {
		squares = new ArrayList<>();
		
		for (int i = 0; i < 40; i++) {
			switch (i) {
			case 0:
				squares.add(new GoSquare());
				break;
			case 2:
			case 17:
			case 33:
				squares.add(new CommunitySquare ("Community Square"));
				break;
			case 4:
				squares.add(new IncomeTaxSquare());
				break;
			case 6:
			case 15:
			case 25:
			case 35:
				squares.add(new RailRoadSquare("Rail Road"));
				break;
			case 7: 
			case 22:
			case 36:
				squares.add(new ChanceSquare("Chance"));
				break;
			case 10:
			case 30:
				squares.add(new JailSquare("Jail"));
				break;
			case 12:
			case 28:
				squares.add(new UtilitySquare("Utility"));
				break;
			case 20: 
				squares.add(new FreeParkingSquare("Free Parking"));
				break;
			case 38: 
				squares.add(new LuxuryTaxSquare());
				break;
			default:
				squares.add(new LotSquare ("Property", i*10, i));
				break;
			}
		}
	}

	public List<Square> getSquares() {
		return squares;
	}

	public Square getStartSquare() {
		return squares.get(0);
	}
}
