package com.monopoly;

public  class Square {

	Square nextSpace;
	private String name;
	private int position;
	
	public Square(int position, String name) {
		this.name = name;
		this.position = position;
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
		System.out.println("Marvin is so cool");
		return name;
	}
	
	public void action(Player player) {
		//Does nothing
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

}
