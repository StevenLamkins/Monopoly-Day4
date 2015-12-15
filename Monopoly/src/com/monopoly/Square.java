package com.monopoly;

public class Square {

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
	private int color;      // The square color
	private int name;       // The square name
	
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
	

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}	
	
	
	
}
