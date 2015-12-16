package com.monopoly;

public class Square {
	
	protected Square next;
	private String name;
	
	public Square(String name) {
		this.name = name;
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

}
