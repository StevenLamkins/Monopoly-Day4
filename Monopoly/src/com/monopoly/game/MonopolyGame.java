package com.monopoly.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.monopoly.board.Board;
import com.monopoly.board.Square;
import com.monopoly.dice.Die;
import com.monopoly.exceptions.WrongNumberOfPlayersException;
import com.monopoly.player.Piece;
import com.monopoly.player.Player;

public class MonopolyGame {
	private List<Player> players;
	private Board board;
	private Map<Square, Player> ownerMap;
	private Die dieOne;
	private Die dieTwo;
	private boolean takeChances;
	
	public MonopolyGame() {
		this(2);
	}

	public MonopolyGame(int numPlayers) {
		this(numPlayers, true);
	}
	
	public MonopolyGame(int numPlayers, boolean takeChances) {
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
		ownerMap = new HashMap<>();
		dieOne = new Die();
		dieTwo = new Die();		
		this.takeChances = takeChances;
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
	
	public Map<Square, Player> getOwnerMap() {
		return ownerMap;
	}
	
	public Die getDieOne() {
		return dieOne;
	}
	
	public Die getDieTwo() {
		return dieTwo;
	}
	
	public Square getPlayerSquare(Player p) {
		return board.getSquareAt(p.getPosition());
	}
	
	public Player getSquareOwner(Square s) {
		return ownerMap.get(s);
	}
	
	public boolean takeChances() {
		return takeChances;
	}
	
	// For taking chances
	public boolean flipCoin() {
		return dieOne.roll() < 4;
	}
	
	public void giveSquareToPlayer(Player p, Square square) {
		p.addProperty(square);
		ownerMap.put(square, p);
	}
	
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
