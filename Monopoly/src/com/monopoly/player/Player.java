package com.monopoly.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.monopoly.board.Move;
import com.monopoly.dice.Die;
import com.monopoly.game.MonopolyGame;
import com.monopoly.squares.Square;
import com.monopoly.squares.SquareGroup;
import com.monopoly.squares.SquareType;

public class Player {
	private static int turnCount;
	private MonopolyGame game;
	private Piece piece;
	private int balance;
	private int position;
	private List<Square> properties;
	private int doubleCount;
	private boolean inJail;
	private int jailRollCount;
	
	public Player(MonopolyGame game, Piece piece, int balance) {
		this.game = game;
		this.piece = piece;
		this.balance = balance;
		this.position = 0;
		this.properties = new ArrayList<>();
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public int getBalance() {
		return balance;
	}
		
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public List<Square> getProperties() {
		return properties;
	}
	
	public void addProperty(Square s) {
		properties.add(s);
	}
	
	/**
	 * Withdraws the amount from the player's balance
	 * If the player has insufficient funds, their balance becomes 0
	 * @param amount
	 * @return
	 */
	public int withdraw(int amount) {		
		balance = (amount > balance) ? 0 : (balance-amount);
		
		return balance;
	}
	
	public int deposit(int amount) {
		balance += amount;
		
		return balance;
	}
	
	private int getDoubleCount() {
		return doubleCount;
	}
	
	private void incrementDoubleCount() {
		doubleCount++;
	}
	
	public void resetDoubleCount() {
		doubleCount = 0;
	}
	
	private boolean inJail() {
		return this.inJail;
	}
	
	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}
	
	private int getJailRollCount() {
		return jailRollCount;
	}
	
	private void incrementJailRollCount() {
		jailRollCount++;
	}
	
	private void resetJailRollCount() {
		jailRollCount = 0;
	}
	
	/**
	 * Checks if player has monopolies, buys houses if so
	 * @param oldPos
	 * @param newPos
	 * @param roll
	 */
	private void checkForPassGo(int oldPos, int newPos, int roll) {
		if ((oldPos + roll) > game.getNumSquares()) {
			deposit(200);
			System.out.println(this+" passed Go! Receive $200, balance is now "+getBalance());
			
			SquareType.incrementNumGoPasses();
		}
	}
	
	/**
	 * Checks if player has monopolies, buys houses if so
	 */
	private void checkForMonopolies() {
		List<SquareGroup> monopolies = Square.getMonopolies(getProperties());
		
		for (SquareGroup group : monopolies) {
			if (!group.equals(SquareGroup.RAILROAD) && !group.equals(SquareGroup.UTILITIES)) {
				Square square = Square.getSquareWithLeastHousesInGroup(group);
				int numHouses = square.getType().getNumHouses();
				int cost = square.getType().getHouseBuildingCost();
				
				if (numHouses < 5 && cost < getBalance()) {
					withdraw(cost);
					square.getType().addHouse();
					System.out.println("Placing a house on "+square.name());
				}
			}
		}
	}
	
	/**
	 * Prints details about the player's move
	 * @param oldPos
	 * @param newPos
	 */
	private void printMove(int oldPos, int newPos) {
		String oldSquare = game.getBoard().getSquareAt(oldPos).name();
		String newSquare = game.getBoard().getSquareAt(newPos).name();
		System.out.println("Moved from "+oldSquare+" ("+oldPos+") to "+newSquare+"("+newPos+")");
	}
	
	public int takeTurn(Die dieOne, Die dieTwo) {
		return takeTurn(dieOne, dieTwo, false, true);
	}
	
	/**
	 * Performs procedure for the player's turn using the given dice
	 * @param dieOne
	 * @param dieTwo
	 * @param suppressReroll
	 * @return
	 */
	public int takeTurn(Die dieOne, Die dieTwo, boolean suppressReroll, boolean takeChances) {
		System.out.println("--- Turn #"+(++turnCount)+"---------------------------------------");
		System.out.println("It is now "+this+"'s turn.");
		printStatus();
		checkForMonopolies();
		
		int rollOne = dieOne.roll();
		int rollTwo = dieTwo.roll();
		int roll = rollOne + rollTwo;
		boolean wentToJail = false;		
		
		System.out.println("Rolled a "+roll);
		
		int oldPos = position;
		int newPos = (position + roll) % game.getNumSquares();
		
		if (!inJail()) {
			printMove(oldPos, newPos);
			setPosition(newPos);
			checkForPassGo(oldPos, newPos, roll);
			
			Square square = game.getBoard().getSquareAt(newPos);
			square.handleMove(new Move(this, square, takeChances, oldPos, newPos, roll));
			
			if (square.equals(Square.GoToJail)) {
				wentToJail = true;
			}
		}
		
		// Rolled doubles
		if (rollOne == rollTwo) {
			incrementDoubleCount();
			System.out.println("Rolled doubles! "+getDoubleCount());
			
			if (getDoubleCount() == 3) {
				System.out.println("Rolled doubles 3 times, going to Jail!");
				setInJail(true);
				setPosition(game.getBoard().getSquarePosition(Square.Jail));
				resetDoubleCount();
			} else {				
				if (inJail()) {
					System.out.println("Rolled doubles while in Jail, player is free!");
					setInJail(false);
					resetJailRollCount();
				} else if (!suppressReroll) {
					System.out.println("Taking another turn because doubles were rolled.");
					return roll + takeTurn(dieOne, dieTwo, suppressReroll, takeChances);
				}
			}
		} else {
			if (!wentToJail && inJail()) {
				incrementJailRollCount();
				
				if (getJailRollCount() == 3) {
					withdraw(50);
					setInJail(false);
					resetJailRollCount();
					System.out.println("3 turns with no doubles while in Jail, player is fined $50 and free! Balance is now "+getBalance());
				}
			}
			
			resetDoubleCount();
		}
		
		return roll;
	}
	
	public void printStatus() {
		// PRINT BALANCE
		System.out.println("Balance:    "+getBalance());
		// PRINT MONOPOLIES
		List<SquareGroup> monopolies = Square.getMonopolies(getProperties());
		System.out.print("Monopolies: ");
		
		for (int i=0; i<monopolies.size(); i++) {
			System.out.print(monopolies.get(i).name());
			
			if (i < monopolies.size()-1) {
				System.out.print(", ");
			}
		}
		
		// PRINT OWNED PROPERTIES
		List<Square> properties = getProperties();
		System.out.print("\nProperties: ");
		
		for (int i=0; i<properties.size(); i++) {
			System.out.print(properties.get(i).name());
			
			if (i < properties.size()-1) {
				System.out.print(", ");
			} else {
				System.out.println();
			}
		}
	}
	
	@Override
	public String toString() {
		return "Player " + piece.name();
	}
}
