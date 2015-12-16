package com.monopoly;

import java.util.ArrayList;
import java.util.List;

import com.monopoly.squares.GoSquare;
import com.monopoly.squares.IncomeTaxSquare;
import com.monopoly.squares.LuxuryTaxSquare;
import com.monopoly.squares.Property;
import com.monopoly.squares.RailroadProperty;
import com.monopoly.squares.Square;
import com.monopoly.squares.UtilityProperty;

public class Board {
	
	private List<Square> squares;
	
	public Board() {
		squares = new ArrayList<>();
		createSquares();

		linkSquares();
	}

	private void linkSquares() {
		for(int i = 0; i < 39; i++){
			squares.get(i).setNextSquare(squares.get(i+1));
		}
		squares.get(39).setNextSquare(squares.get(0));
	}

	private void createSquares() {
		squares.add(new GoSquare(0, "Go Square"));
		for(int i = 1; i < 40; i++){
			switch(i){
				case 1: 
					squares.add(new Property(i, "Mediterranean Avenue", "Purple", 60, 2));
					break;
				case 4: 
					squares.add(new IncomeTaxSquare(i, "Income Tax"));	
					break;
				case 5:
					squares.add(new RailroadProperty(i, "Reading Railroad", "Railroad", 200, 25));
					break;
				case 12:
					squares.add(new UtilityProperty(i, "Electric Company", "Utilities", 150, 4));
					break;
				case 28:
					squares.add(new UtilityProperty(i, "Water Works", "Utilities", 150, 4));
					break;
				case 15:
					squares.add(new RailroadProperty(i, "Pennsylvania Railroad", "Railroad", 200, 25));
					break;
				case 25:
					squares.add(new RailroadProperty(i, "Short Line", "Railroad", 200, 25));
					break;
				case 35:
					squares.add(new RailroadProperty(i, "Reading Railroad", "Railroad", 200, 25));
					break;
				case 38:
					squares.add(new LuxuryTaxSquare(i, "Luxury Tax"));
					break;
				default:
					squares.add(new Square(i, "Square " + i));	
					break;
			}	
		}
	}

	public List<Square> getSquares() {
		return squares;
	}
}
