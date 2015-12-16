package com.monopoly.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.monopoly.board.Board;
import com.monopoly.dice.Die;
import com.monopoly.exceptions.WrongNumberOfPlayersException;
import com.monopoly.player.Piece;
import com.monopoly.player.Player;
import com.monopoly.squares.Square;

public class MonopolyGame {
	private List<Player> players;
	private Board board;
	private Die dieOne;
	private Die dieTwo;
	
	public MonopolyGame() {
		this(2);
	}
	
	/**
	 * Sets up the game, creates the board, players, and dice
	 * @param numPlayers
	 * @param takeChances
	 */
	public MonopolyGame(int numPlayers) {
		if(numPlayers<2 || numPlayers>8) {
			throw new WrongNumberOfPlayersException("Incorrect number of players (2-8)");
		}
		
		players = new ArrayList<>();
		
		LinkedList<Piece> pieces = new LinkedList<>();
		pieces.addAll(Arrays.asList(Piece.values()));
		
		// Create players, start with $1500
		for (int i=0; i<numPlayers; i++) {
			players.add(new Player(this, pieces.pop(), 1500));
		}
		
		board = new Board();
		dieOne = new Die();
		dieTwo = new Die();
		
		Square.setup();
	}
	
	public int getNumSquares() {
		return board.getNumSquares();
	}
	
	public int getNumPlayers() {
		return players.size();
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public Die getDieOne() {
		return dieOne;
	}
	
	public Die getDieTwo() {
		return dieTwo;
	}
	
	/**
	 * Determines the square in which the given player is currently on
	 * @param p
	 * @return square the given player is on
	 */
	public Square getPlayerSquare(Player p) {
		return board.getSquareAt(p.getPosition());
	}
	
	/**
	 * Performs the game loop
	 */
	public void start() {
		while (getNumPlayers() > 1) {
			Iterator<Player> playerIter = players.iterator();
			
			while (playerIter.hasNext()) {
				if (getNumPlayers() == 1) break; 
				
				Player p = playerIter.next();
				p.takeTurn(dieOne, dieTwo);
				
				if (p.getBalance() <= 0) {
					System.out.println(p+" has lost the game.");
					playerIter.remove();
				}
			}
		}
		
		Player winner = players.get(0);
		System.out.println("Game ended! "+winner.getPiece()+" won the game with a balance of "+winner.getBalance());
	}	
}
