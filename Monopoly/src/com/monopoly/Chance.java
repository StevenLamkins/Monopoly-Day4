package com.monopoly;

public class Chance extends Square {
	public Chance(String id, String squareType){
		super(id, squareType);
	}
	
	@Override
	public boolean handlePlayerLanding(Player player, boolean buyIfProperty){
		boolean stillInGame = true;
		Board.deck.draw().drawThisCard(player);
		return stillInGame;
	}
}
