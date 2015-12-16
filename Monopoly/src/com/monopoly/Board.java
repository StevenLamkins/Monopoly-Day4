package com.monopoly;

import java.util.ArrayList;
import java.util.List;

import com.monopoly.squares.GoSquare;
import com.monopoly.squares.IncomeTaxSquare;
import com.monopoly.squares.LuxuryTaxSquare;
import com.monopoly.squares.Property;
import com.monopoly.squares.Square;

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
					squares.add(new Property(i, "Mediterranean Avenue", 60, 2));
					break;
				case 4: 
					squares.add(new IncomeTaxSquare(i, "Income Tax"));	
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
