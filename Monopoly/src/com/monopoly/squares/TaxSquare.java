package com.monopoly.squares;

import com.monopoly.board.Move;
import com.monopoly.player.Player;

public class TaxSquare extends PropertySquare {

	public TaxSquare(SquareGroup group, int price, int rent) {
		super(group, price, rent);
	}
	
	/**
	 * Determines tax amount and withdraws from player's balance
	 * @param square
	 */
	private void payTax(Square square, Player player) {
		int taxAmount = 0;
		
		switch (square) {
			case IncomeTax:
				int percentAmt = (int) ((double)player.getBalance() * 0.1);
				
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
		
		player.withdraw(taxAmount);
		System.out.println(player+" paid $"+taxAmount+" in taxes.");
	}
	
	@Override
	public void handleMove(Move move) {
		payTax(move.getSquare(),move.getPlayer());
	}
}
