package com.monopoly.squares;

import com.monopoly.Player;

public class Square {
	protected int[] prices = {0, 60, 0, 60, 0, 200, 100, 0, 100, 120, 0, 140, 150, 140, 160, 200, 180, 0, 180, 200, 0, 220, 0, 220, 240, 200, 260, 260, 150, 280, 0, 300, 300, 0, 320, 200, 0, 350, 0, 400};
	protected int[] rents = {0, 2, 0, 4, -100, 50, 6, 0, 6, 8, 0, 10, -1, 10, 13, 50, 14, 0, 14, 16, 0, 18, 0, 18, 20, 50, 22, 22, -1, 22, 0, 26, 26, 0, 28, 50, 0, 35, 75, 50};
	protected String[] names = {"Go", "Mediterranean", "Community Chest", "Baltic", "Income Tax", "Reading Railroad", "Oriental", "Chance", "Vermont", "Connecticut", "Jail",
			"St. Charles Place", "Electric Company", "States", "Virginia", "Pennsylvania Railroad", "St. James Place", "Community Chest", "Tennessee", "New York",
			"Free Parking", "Kentucky", "Chance", "Indiana", "Illinois", "B&O Railroad", "Atlantic", "Ventnor", "Water Works", "Marvin Gardens", "Go to Jail", "Pacific",
			"North Carolina", "Community Chest", "Pennsylvania", "Short Line Railroad", "Chance", "Park Place", "Luxury Tax", "Boardwalk"};
	
	public final int NO_COLOR = 0;
	public final int BLACK = 1;
	public final int WHITE = 2;
	

	private String horizonLine = "---------";
	private String verticaLine = "|";
	private String plusSign = "+";
	private String space = "         ";
	
	//-------------------------------
	// Class attributes
	//-------------------------------
	protected int position;   // The position of the square (0...39)
	private String name;       // The square name
	
	public Square(int position) {
		this.position = position;
		name = names[position];
	}

	//-------------------------------
	// Public functions
	//-------------------------------
	public void show() {
	    System.out.println(plusSign + horizonLine + plusSign);	
	    System.out.println(verticaLine + space + verticaLine);	
	    System.out.println(verticaLine + space + verticaLine);	
	    System.out.println(plusSign + horizonLine + plusSign);	
	}
	
	public void doShow() {
	    System.out.println("+---------+---------+---------+---------+---------+");	
		System.out.println("|         |         |         |         |         |");
		System.out.println("|         |         |         |         |         |");
		System.out.println("+---------+---------+---------+---------+---------+");	
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int pos) {
		this.position = pos;
	}

	public String getName() {
		return name;
	}

	public int landOnBy(Player player) {
		return 0;
	}
	
	
	
}
