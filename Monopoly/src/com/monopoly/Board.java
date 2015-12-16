package com.monopoly;

import java.util.ArrayList;
import java.util.List;

import com.monopoly.squares.FreeSquare;
import com.monopoly.squares.LotSquare;
import com.monopoly.squares.RailroadSquare;
import com.monopoly.squares.Square;
import com.monopoly.squares.TaxSquare;
import com.monopoly.squares.UtilitySquare;

public class Board {
	private int[] groups = {10, 0, 10, 0, 11, 9, 1, 10, 1, 1, 10, 2, 8, 2, 2, 9, 3, 10, 3, 3, 10, 4, 10, 4, 4, 9, 5, 5, 8, 5, 10, 6, 6, 10, 6, 9, 10, 7, 11, 7};
	private String[] groupEnum = {"Purple", "Light-Green", "Violet", "Orange", "Red", "Yellow", "Dark-Green", "Dark-Blue"};
	
	List<Square> squares = new ArrayList<>();
	
	public Board() 
	{		
		for (int i = 0; i < 40; i++) 
		{
			int group = groups[i];
			Square newSquare;
			switch (group) {
				case 8:
					newSquare = new UtilitySquare(i);
					break;
				case 9:
					newSquare = new RailroadSquare(i);
					break;
				case 10:
					newSquare = new FreeSquare(i);
					break;
				case 11:
					newSquare = new TaxSquare(i);
					break;
				default:
					newSquare = new LotSquare(i,groupEnum[group]);
					break;
			}
			squares.add(newSquare);
		}
	}

	public List<Square> getSquares() 
	{
		return squares;
	}

}
