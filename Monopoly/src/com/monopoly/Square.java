package com.monopoly;

public class Square {
	
	private int[] positions = {0, 1, 3, 6, 8, 9, 11, 13, 14, 16, 18, 19, 21, 23, 24, 26, 27, 29, 31, 32, 34, 37, 39, 12, 28, 5, 15, 25, 35, 2, 4, 7, 10, 17,
			20, 22, 30, 33, 36, 38};
	private int[] prices = {0, 60, 60, 100, 100, 120, 140, 140, 160, 180, 180, 200, 220, 220, 240, 260, 260, 280, 300, 300, 320, 350, 400, 150, 150, 200, 200,
			200, 200, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	private int[] rents = {0, 2,4,6,6,8,10,10,13,14,14,16,18,18,20,22,22,22,26,26,28,35,50,-1,-1,-2,-2,-2,-2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	private int[] groups = {10, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
	private String[] groupEnum = {"Purple", "Light-Green", "Violet", "Orange", "Red", "Yellow", "Dark-Green", "Dark-Blue",
			"Utilities", "Railroad", "Non-Property"};
	private String[] names = {"Go", "Mediterranean", "Baltic", "Oriental", "Vermont", "Connecticut", "St. Charles Place", "States",
			"Virginia", "St. James Place", "Tennessee", "New York", "Kentucky", "Indiana", "Illinois", "Atlantic", "Ventnor",
			"Marvin Gardens", "Pacific", "North Carolina", "Pennsylvania", "Park Place", "Boardwalk", "Electric Company",
			"Water Works", "Reading Railroad", "Pennsylvania Railroad", "B&O Railroad", "Short Line Railroad", "Community Chest",
			"Income Tax", "Chance", "Jail", "Community Chest", "Free Parking", "Chance", "Go to Jail", "Community Chest",
			"Chance", "Luxury Tax"};
	
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
	private int position;   // The position of the square (0...39)
	private String color;      // The square color
	private String name;       // The square name
	private int rent;
	private int price;
	private int lookup = 0;
	
	public Square(int index) {
		position = index;
		int i;
		for (i = 0; i < positions.length; i++) {
			if (positions[i] == index) break;
		}
		lookup = i;
		name = names[lookup];
		color = groupEnum[groups[lookup]];
		rent = rents[lookup];
		price = prices[lookup];
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
	

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}	
	
	
	
}
