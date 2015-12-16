package com.monopoly.squares;

import com.monopoly.board.Move;
import com.monopoly.dice.CoinUtil;
import com.monopoly.player.Player;

public class PropertySquare extends SquareType {
	
	public PropertySquare(SquareGroup group, int price, int rent) {
		super(group, price, rent);
	}
	
	/**
	 * Determines rent amount and withdraws from player's balance
	 * If the player does not have sufficient funds, they lose
	 * @param square
	 */
	protected void payRent(Player player, Player payee, int amount) {
		int balance = player.getBalance();
		
		if (amount > balance) {
			payee.deposit(balance);
			player.withdraw(balance);
			System.out.println("Paying "+amount+" to "+payee+", insufficient funds!");
		} else {
			payee.deposit(amount);
			player.withdraw(amount);
			System.out.println("Paying "+amount+" to "+payee+", balance is now "+player.getBalance());
		}
	}
	
	/**
	 * Buys the given square and gives it to the player
	 * @param square
	 */
	protected void buySquare(Player player, Square square, boolean takeChances) {
		int balance = player.getBalance();
		int price = square.getType().getPrice();
		
		if (price < balance && (!takeChances || CoinUtil.flipCoin())) {
			player.withdraw(price);
			Square.setSquareOwner(player, square);
			System.out.println("Buying "+square.name()+", balance is now "+balance);
		}
	}

	@Override
	public void handleMove(Move move) {
		Player player = move.getPlayer();
		Square square = move.getSquare();
		
		if (Square.getSquareOwner(square) != null) {
			payRent(player, Square.getSquareOwner(square), getRent());
		} else {
			buySquare(player, square, move.getTakeChances());
		}
	}
}
