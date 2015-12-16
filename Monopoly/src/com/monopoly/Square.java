package com.monopoly;

public class Square {
	private int position;
	private Square nextSquare;
	private String name;
	
	public Square(int position, String name) {
		this.position = position;
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public Square getNextSquare() {
		return nextSquare;
	}

	public void setNextSquare(Square nextSquare) {
		this.nextSquare = nextSquare;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString()
	{
		return getName();
	}
	
}
