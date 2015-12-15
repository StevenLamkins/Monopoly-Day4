package com.monopoly;

public class Square {

	Square nextSpace;
	private String name;
	
	public Square(String name) {
		this.name = name;
	}
	
	public Square travel(int spaces) {
		Square currentSquare = this;
		
		for(int i = 0; i < spaces; i++){
			currentSquare = currentSquare.getNextSpace();
		}
		return currentSquare;
	}

	private Square getNextSpace() {
		return nextSpace;
	}

	public void changeNextSquare(Square nextSquare) {
		nextSpace = nextSquare;
	}
	
	@Override
	public String toString() {
		return name;
	}
	

}
