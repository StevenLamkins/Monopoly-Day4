package com.monopoly;

public class Square {
	
	protected Square next;
	private String name;
	protected int squareNumber;
	
	public Square(String name, int squareNumber) {
		this.name = name;
		this.squareNumber = squareNumber;
	}
	
	public void setNext(Square nextSquare) {
		this.next = nextSquare;
	}

	public Square getNext() {
		//System.out.println("Getting next for: " + name);
		return next;
	}

	public void landedOnBy(Player player) {
		// No-op for base class	
	}

	public void passedBy(Player player) {
		// No-op for base class
	}

	public String getName() {
		return name;
	}

}
