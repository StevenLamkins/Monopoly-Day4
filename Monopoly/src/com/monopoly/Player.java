package com.monopoly;


public class Player {

	private Square currentSquare;
	private MonopolyGame.Token token;
	
	public Player(Square startSquare, MonopolyGame.Token token) {

		this.currentSquare = startSquare;
		this.token = token;
	}

	public Square getCurrentSquare() {

		return currentSquare;
	}

}
