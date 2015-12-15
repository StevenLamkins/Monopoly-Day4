package com.monopoly;


public class Player {

	private Square currentSquare;
	
	private MonopolyGame.Token token;
	
	public Player(Square startSquare, MonopolyGame.Token token) {

		this.currentSquare = startSquare;
		this.token = token;
	}
	
	public void setToken(MonopolyGame.Token token) {
		this.token = token;
	}

	public MonopolyGame.Token getToken() {
		return token;
	}

	public Square getCurrentSquare() {

		return currentSquare;
	}

	public void setCurrentSquare(Square currentSquare) {
		this.currentSquare = currentSquare;
	}

}
