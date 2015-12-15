package com.monopoly;

public class Square {
	
	private String name;
	private Square nextSquare;

		
	public void setNextSquare(Square nextSquare) {
		this.nextSquare = nextSquare;
	}

	public Square(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Square next() {
		
		return nextSquare;
	}

}
