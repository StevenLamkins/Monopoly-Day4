package com.monopoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.monopoly.exceptions.WrongNumberOfPlayersException;

public class MonopolyGame {
	private List<Player> players;
	private Board board;
	private Map<Square, Player> ownerMap;
	private Die dieOne;
	private Die dieTwo;
	private boolean takeChances = true;
	
	public MonopolyGame() {
		this(2);
	}

	public MonopolyGame(int numPlayers) {
		if(numPlayers<2 || numPlayers>8) {
			throw new WrongNumberOfPlayersException("Incorrect number of players (2-8)");
		}
		
		players = new ArrayList<>();
		
		LinkedList<Piece> pieces = new LinkedList<>();
		pieces.addAll(Arrays.asList(Piece.values()));
		
		for (int i=0; i<numPlayers; i++) {
			players.add(new Player(pieces.pop(), 1500));
		}
		
		board = new Board();
		ownerMap = new HashMap<>();
		dieOne = new Die();
		dieTwo = new Die();
	}
	
	public MonopolyGame(int numPlayers, boolean takeChances) {
		this(numPlayers);
		
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
	
	public Square getPlayerSquare(Player p) {
		return board.getSquareAt(p.getPosition());
	}
	
	public Player getSquareOwner(Square s) {
		return ownerMap.get(s);
	}
	
	public static void main(String args[]) {
		MonopolyGame game = new MonopolyGame(2);
		game.start();
	}
	
	public void start() {
		while (getNumPlayers() > 1) {
			Iterator<Player> playerIter = players.iterator();
			
			while (playerIter.hasNext()) {
				if (getNumPlayers() == 1) break; 
				
				Player p = playerIter.next();
				takeTurn(p);
				
				if (p.getBalance() <= 0) {
					System.out.println(p+" has lost the game.");
					playerIter.remove();
				}
			}
		}
		
		Player winner = players.get(0);
		System.out.println("Game ended! "+winner.getPiece()+" won the game with a balance of "+winner.getBalance());
	}
	
	public boolean flipCoin() {
		return dieOne.roll() < 4;
	}
	
	private void payRent(Player p, Square square) {
		int bal = p.getBalance();
		int rent = square.getRent();
		
		if (rent > bal) {
			ownerMap.get(square).deposit(bal);
			p.withdraw(bal);
			System.out.println("Paying "+rent+" to "+ownerMap.get(square)+", insufficient funds!");
		} else {
			ownerMap.get(square).deposit(rent);
			p.withdraw(rent);
			System.out.println("Paying "+rent+" to "+ownerMap.get(square)+", balance is now "+bal);
		}
	}
	
	private void buySquare(Player p, Square square) {
		int bal = p.getBalance();
		int price = square.getPrice();
		
		if (price < bal && (!takeChances || flipCoin())) {
			p.withdraw(price);
			p.addProperty(square);
			ownerMap.put(square, p);
			System.out.println("Buying "+square.name()+", balance is now "+p.getBalance());
		}
	}
	
	public void giveSquareToPlayer(Player p, Square square) {
		p.addProperty(square);
		ownerMap.put(square, p);
	}
	
	public int takeTurn(Player p) {
		return takeTurn(p, 0, 0);
	}
	
	public int takeTurn(Player p, int forceRollOne, int forceRollTwo) {
		return takeTurn(p, forceRollOne, forceRollTwo, false);
	}

	public int takeTurn(Player p, int forceRollOne, int forceRollTwo, boolean suppressReroll) {		
		int roll = 0;
		int rollOne = 0;
		int rollTwo = 0;
		boolean wentToJail = false;
		
		if (forceRollOne > 0) {
			rollOne = forceRollOne;
			rollTwo = forceRollTwo;
		} else {
			rollOne = dieOne.roll();
			rollTwo = dieTwo.roll();
		}
		
		roll = rollOne + rollTwo;
		
		System.out.println("--------------------------------------------");
		System.out.println("It is now "+p+"'s turn.");
		System.out.println("Rolled a "+roll);
		
		int pos = p.getPosition();
		int newPos = (pos + roll) % board.getNumSquares();
		
		if (!p.inJail()) {
			p.setPosition(newPos);
			
			// Handle passing Go
			System.out.println("Old position: "+pos+", New position: "+newPos+" "+board.getSquareAt(newPos).name());
			if ((pos + roll) > board.getNumSquares()) {
				p.deposit(20);
				System.out.println(p+" passed Go! Receive $200, balance is now "+p.getBalance());
			}
			
			Square square = board.getSquareAt(newPos);
			
			switch (square.getType()) {
				case PROPERTY:				
					if (ownerMap.containsKey(square)) {
						payRent(p, square);
					} else {
						buySquare(p, square);
					}
					
					break;
				case TAX:
					p.withdraw(100);
					System.out.println(p+" paid $100 in taxes.");
					break;
				case UTILITIES:
					int cost = roll * 4;
					p.withdraw(cost);
					System.out.println("Paid $"+cost+" in utilities.");
					break;
				case GO_TO_JAIL:
					p.setInJail(true);
					wentToJail = true;
					p.setPosition(board.getSquarePosition(Square.Jail));
					System.out.println("Landed on Go To Jail.");
					break;
				default:
					break;
			}
		}
		
		// Rolled doubles
		if (rollOne == rollTwo) {
			p.incrementDoubleCount();
			
			if (p.getDoubleCount() == 3) {
				System.out.println("Rolled doubles 3 times, going to Jail!");
				p.setInJail(true);
				p.setPosition(board.getSquarePosition(Square.Jail));
				p.resetDoubleCount();
			} else {				
				if (p.inJail()) {
					System.out.println("Rolled doubles while in Jail, player is free!");
					p.setInJail(false);
					p.resetJailRollCount();
				} else if (!suppressReroll) {
					System.out.println("Rolled doubles, taking another turn.");
					return roll + takeTurn(p);
				}
			}
		} else {
			if (!wentToJail && p.inJail()) {
				p.incrementJailRollCount();
				
				if (p.getJailRollCount() == 3) {
					p.withdraw(50);
					p.setInJail(false);
					p.resetJailRollCount();
					System.out.println("3 turns with no doubles while in Jail, player is fined $50 and free! Balance is now "+p.getBalance());
				}
			}
		}
		
		return roll;
	}
}
