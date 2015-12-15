package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {

	private Board board;
	
	private List<Player> players = new ArrayList<>();
	
	final int MAX_NUMBER_OF_PLAYERS = 8;

	public enum Token
	{
		Dog, Wheelbarrow, TopHat, Thimble, BattleShip, Racecar, Boot, Iron
	}
	public MonopolyGame() {
		board = new Board();
		for (int i = 0; i < MAX_NUMBER_OF_PLAYERS; i++) {
			Player player = new Player(board.getSquares().get(0),Token.values()[i]);
			players.add(player);
		}
	}

	
	public List<Square> getSquares() {
		
		return board.getSquares();
	}

	public List<Player> getPlayers() {
		
		return players;
	}
	
	public Square getGoSquare () {
		
		return	board.getSquares().get(0);
	}

}
