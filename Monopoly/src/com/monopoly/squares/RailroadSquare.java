package com.monopoly.squares;

import com.monopoly.board.Move;
import com.monopoly.player.Player;
import com.monopoly.player.PlayerInfo;

public class RailroadSquare extends PropertySquare {

	public RailroadSquare(SquareGroup group, int price, int rent) {
		super(group, price, rent);
	}
	
	/**
	 * Railroad rent is equal to 25 * 2^(num owned - 1)
	 * @param p
	 * @return
	 */
	public int getRent(PlayerInfo p) {
		return 25 * (int) Math.pow(2, Square.getNumRailroadsOwned(p)-1);
	}

	@Override
	public void handleMove(Move move) {
		Square square = move.getSquare();
		Player player = move.getPlayer();
		Player payee = Square.getSquareOwner(square);
		
		
		if (payee != null && payee != player) {
			payRent(player, payee, getRent(payee));
		} else {
			buySquare(player, square, move.getTakeChances());
		}
	}
}
