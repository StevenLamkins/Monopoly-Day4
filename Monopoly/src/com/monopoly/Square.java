package com.monopoly;

public abstract class Square {
	
	private String name;
	private Square nextSquare;

	public Square getNextSquare() {
		return nextSquare;
	}

	public void setNextSquare(Square nextSquare) {
		this.nextSquare = nextSquare;
	}

	public Square(String name) {
		this.name = name;
		
	}

	public Object getName() {
		return name;
	}
	
	public abstract void landOn(Player player);
	
	public abstract void passOver(Player player);
}
