package com.monopoly;

public class Square {
	
	private Square next;
	
	public void setNext(Square nextSquare) {
		this.next = nextSquare;
	}

	public Square getNext() {
		return next;
	}

	public void landedOnBy(Player player) {
		// No-op for parent class		
	}

}
