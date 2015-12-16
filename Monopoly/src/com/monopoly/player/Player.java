package com.monopoly.player;

import java.util.ArrayList;
import java.util.List;

import com.monopoly.board.Square;
import com.monopoly.board.SquareGroup;
import com.monopoly.dice.Die;
import com.monopoly.game.MonopolyGame;

public class Player {
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
	
	public int withdraw(int amount) {
		if (amount > balance) {
			balance = 0;
		} else {
			balance -= amount;
		}
		
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
	
	private void resetDoubleCount() {
		doubleCount = 0;
	}
	
	private boolean inJail() {
		return this.inJail;
	}
	
	private void setInJail(boolean inJail) {
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
	
	private void payRent(Square square) {
		int rent = square.getRent();
		Player payee = game.getSquareOwner(square);
		
		if (rent > balance) {
			payee.deposit(balance);
			withdraw(balance);
			System.out.println("Paying "+rent+" to "+payee+", insufficient funds!");
		} else {
			payee.deposit(rent);
			withdraw(rent);
			System.out.println("Paying "+rent+" to "+payee+", balance is now "+balance);
		}
	}
	
	private void payTax(Square square) {
		int taxAmount = 0;
		
		switch (square) {
			case IncomeTax:
				int percentAmt = (int) ((double)getBalance() * 0.1);
				
				if (percentAmt < 200) {
					taxAmount = percentAmt;
				} else {
					taxAmount = 200;
				}	
				break;
			case LuxuryTax:
				taxAmount = 75;
				break;
			default:
				break;
		}
		
		withdraw(taxAmount);
		System.out.println(this+" paid $"+taxAmount+" in taxes.");
	}
	
	private void buySquare(Square square) {
		int price = square.getPrice();
		
		if (price < balance && (!game.takeChances() || game.flipCoin())) {
			withdraw(price);
			game.giveSquareToPlayer(this, square);
			System.out.println("Buying "+square.name()+", balance is now "+balance);
		}
	}
	
	public int takeTurn(Die dieOne, Die dieTwo) {
		return takeTurn(dieOne, dieTwo, false);
	}

	public int takeTurn(Die dieOne, Die dieTwo, boolean suppressReroll) {
		List<SquareGroup> monopolies = Square.getMonopolies(getProperties());
		
		for (SquareGroup group : monopolies) {
			System.out.println(this+" has a monopoly for "+group.name());
		}
		
		int rollOne = dieOne.roll();
		int rollTwo = dieTwo.roll();
		int roll = rollOne + rollTwo;
		boolean wentToJail = false;		
		
		System.out.println("--------------------------------------------");
		System.out.println("It is now "+this+"'s turn.");
		System.out.println("Rolled a "+roll);
		
		int oldPos = position;
		int newPos = (position + roll) % game.getNumSquares();
		
		if (!inJail()) {
			// Handle passing Go
			System.out.println("Old position: "+oldPos+", New position: "+newPos+" "+game.getBoard().getSquareAt(newPos).name());
			setPosition(newPos);
			
			if ((oldPos + roll) > game.getNumSquares()) {
				deposit(20); //TODO - increase to $200 once houses can be bought
				System.out.println(this+" passed Go! Receive $200, balance is now "+getBalance());
			}
			
			Square square = game.getBoard().getSquareAt(newPos);
			
			switch (square.getType()) {
				case PROPERTY:				
					if (game.getSquareOwner(square) != null) {
						payRent(square);
					} else {
						buySquare(square);
					}
					
					break;
				case TAX:
					payTax(square);
					break;
				case UTILITIES:
					int cost = roll * 4;
					withdraw(cost);
					System.out.println("Paid $"+cost+" in utilities.");
					break;
				case GO_TO_JAIL:
					setInJail(true);
					wentToJail = true;
					setPosition(game.getBoard().getSquarePosition(Square.Jail));
					System.out.println("Landed on Go To Jail.");
					break;
				default:
					break;
			}
		}
		
		// Rolled doubles
		if (rollOne == rollTwo) {
			incrementDoubleCount();
			
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
					System.out.println("Rolled doubles, taking another turn.");
					return roll + takeTurn(dieOne, dieTwo, suppressReroll);
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
		}
		
		return roll;
	}
	
	@Override
	public String toString() {
		return "Player " + piece.name();
	}
}
