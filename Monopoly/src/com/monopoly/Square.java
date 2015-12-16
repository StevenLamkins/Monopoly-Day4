package com.monopoly;

public class Square {

	private String name;
	private Square nextSquare;
	private int price;

	public Square(String name) {
		this.name = name;
	}

	public void landOnBy(Player aPlayer) {
		aPlayer.credit(0);

	}
	
	public void passBy(Player aPlayer) {
		aPlayer.credit(0);
	}

	public void setNextSquare(Square nextSquare) {
		this.nextSquare = nextSquare;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
