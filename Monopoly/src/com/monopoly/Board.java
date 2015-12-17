package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Board {

	public Board() {
		createSquares();
		linkSquares();
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
		squares.add(new GoSquare());
		for (int i = 1; i <= 39; i++) {
			switch (i) {
			case 4:
				squares.add(new IncomeTaxSquare());
				break;
			case 38:
				squares.add(new LuxTaxSquare());
				break;
			case 5:
			case 15:
			case 25:
			case 35:
				squares.add(new RailRoad(200));
				break;
			case 12:
			case 28:
				squares.add(new Utility(150));
				break;
			case 2:
			case 7:
			case 10:
			case 17:
			case 20:
			case 22:
			case 30:
			case 33:
			case 36:
				squares.add(new Square("Square" + i));
				break;
			default:
				squares.add(new Lot("Square" + i, (i+1)*10, i));
				break;
			}
		}
		linkSquares();
	}

	private void linkSquares() {
		int next = 1;
		for (Square sq : squares) {
			if (next == 40) {
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
