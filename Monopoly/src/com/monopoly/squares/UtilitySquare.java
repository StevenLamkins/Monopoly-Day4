package com.monopoly.squares;

import com.monopoly.board.Move;
import com.monopoly.player.Player;

public class UtilitySquare extends PropertySquare {

	public UtilitySquare(SquareGroup group, int price, int rent) {
		super(group, price, rent);
	}
	
	/**
	 * Withdraws utilities cost from player's balance
	 * @param square
	 * @param roll
	 */
	private void payUtilities(Square square, Player player, int roll) {
		Player payee = Square.getSquareOwner(square);
		int amount = roll * 4;
		payRent(player, payee, amount);
		System.out.println("Paid $"+amount+" in utilities to "+payee);
	}
	
	@Override
	public void handleMove(Move move) {
		Player player = move.getPlayer();
		Square square = move.getSquare();
		
		if (Square.getSquareOwner(square) != null) {
			payUtilities(move.getSquare(),move.getPlayer(),move.getRoll());
		} else {
			buySquare(player, square, move.getTakeChances());
		}
	}
}
