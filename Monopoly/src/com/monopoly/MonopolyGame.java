package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {

	private Board board;

	private List<Player> players = new ArrayList<>();

	public enum Token {
		Dog, Wheelbarrow, TopHat, Thimble, BattleShip, Racecar, Boot, Iron
	}

	public MonopolyGame() {
		this(2);
	}

	public MonopolyGame(int numberOfPlayers) {
		board = new Board();
		setupPlayers(numberOfPlayers);
	}

	private void setupPlayers(int numberOfPlayers) {
		if (numberOfPlayers < 2)
			throw new IllegalArgumentException();
		if (numberOfPlayers > 8)
			throw new IllegalArgumentException();
		for (int i = 0; i < numberOfPlayers; i++) {
			Player player = new Player(board.getSquares().get(0),
					Token.values()[i]);
			players.add(player);
		}
	}

	public List<Square> getSquares() {

		return board.getSquares();
	}

	public List<Player> getPlayers() {

		return players;
	}

	public Square getGoSquare() {

		return board.getSquares().get(0);
	}

}
