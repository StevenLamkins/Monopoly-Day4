package com.monopoly.squares;

import com.monopoly.board.Move;
import com.monopoly.player.Player;

public class RailroadSquare extends PropertySquare {

	public RailroadSquare(SquareGroup group, int price, int rent) {
		super(group, price, rent);
	}
	
	/**
	 * Railroad rent is equal to 25 * 2^(num owned - 1)
	 * @param p
	 * @return
	 */
	public int getRent(Player p) {
		return 25 * (int) Math.pow(2, Square.getNumRailroadsOwned(p)-1);
	}

	@Override
	public void handleMove(Move move) {
		Player player = move.getPlayer();
		Square square = move.getSquare();
		
		if (Square.getSquareOwner(square) != null) {
			Player payee = Square.getSquareOwner(square);
			payRent(player, payee, getRent(payee));
		} else {
			buySquare(player, square, move.getTakeChances());
		}
	}
}
