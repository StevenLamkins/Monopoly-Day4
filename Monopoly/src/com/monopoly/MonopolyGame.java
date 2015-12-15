package com.monopoly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MonopolyGame {
	private Board board;
	private List<Player> players;
	private Map<Square, Player> ownerMap;
	private Die dieOne;
	private Die dieTwo;
	
	public MonopolyGame() {
		this(2);
	}

	public MonopolyGame(int numPlayers) {
		if(numPlayers<2 || numPlayers>8) {
			throw new IllegalArgumentException("Incorrect number of players (2-8)");
		}

		board = new Board();
		players = new ArrayList<>();
		ownerMap = new HashMap<>();
		
		for (int i=0; i<numPlayers; i++) {
			players.add(new Player(i, 1500));
		}
		
		dieOne = new Die();
		dieTwo = new Die();
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
	
	public Square getPlayerSquare(Player p) {
		return board.getSquareAt(p.getPosition());
	}
	
	public static void main(String args[]) {
		MonopolyGame game = new MonopolyGame(2);
		game.start();
		
		for (Player p : game.getPlayers()) {
			System.out.println(p.getBalance());
		}
	}
	
	public void start() {
		while (getNumPlayers() > 1) {
			Iterator<Player> playerIter = players.iterator();
			
			while (playerIter.hasNext()) {
				if (getNumPlayers() == 1) break; 
				
				Player p = playerIter.next();
				takeTurn(p);
				
				if (p.getBalance() <= 0) {
					playerIter.remove();
				}
			}
		}
		
		System.out.println("Game ended! Player "+players.get(0).getToken()+" won the game.");
	}
	
	public int takeTurn(Player p) {
		return takeTurn(p, 0);
	}

	public int takeTurn(Player p, int forceRoll) {
		int roll = 0;
		int rollOne = 0;
		int rollTwo = 0;
		int token = p.getToken();
		
		if (forceRoll > 0) {
			roll = forceRoll;
		} else {
			rollOne = dieOne.roll();
			rollTwo = dieTwo.roll();
			
			roll = rollOne + rollTwo;
		}
		
		System.out.println("Player "+token+" rolled a "+roll);
		
		int pos = p.getPosition();
		int newPos = (pos + roll) % board.getNumSquares();
		p.setPosition(newPos);
		
		// Handle passing Go
		System.out.println("Old position: "+pos+", New position: "+newPos);
		if ((pos + roll) > board.getNumSquares()) {
			//p.deposit(200);
			System.out.println("Player "+p.getToken()+" passed Go!");
		}
		
		Square square = board.getSquareAt(newPos);
		
		switch (square.getType()) {
			case PROPERTY:
				int bal = p.getBalance();
				
				if (ownerMap.containsKey(square)) {
					int rent = square.getRent();
					
					if (rent > bal) {
						ownerMap.get(square).deposit(bal);
						p.withdraw(bal);
					} else {
						ownerMap.get(square).deposit(rent);
						p.withdraw(rent);
					}
				} else {
					int price = square.getPrice();
					
					if (price < bal) {
						p.withdraw(price);
						ownerMap.put(square, p);
					}
				}
				
				break;
			case TAX:
				if (p.getBalance() > 100) {
					p.withdraw(100);
				} else {
					p.withdraw(p.getBalance());
				}
				
				break;
			case UTILITIES:
				int cost = roll * 4;
				
				if (p.getBalance() > cost) {
					p.withdraw(cost);
				} else {
					p.withdraw(p.getBalance());
				}
				
				break;
			case GO_TO_JAIL:
				p.setPosition(board.getSquarePosition(Square.Jail));
				break;
			default:
				break;
		}
		
		if (forceRoll == 0 && rollOne == rollTwo) {
			// handle double
			p.incrementDoubleCount();
			
			if (p.getDoubleCount() == 3) {
				p.setPosition(board.getSquarePosition(Square.Jail));
				p.resetDoubleCount();
			} else {
				return takeTurn(p);
			}
		}
		
		return roll;
	}
}
