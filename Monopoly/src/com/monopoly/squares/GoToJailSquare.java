package com.monopoly.squares;

import com.monopoly.board.Move;
import com.monopoly.player.Player;

public class GoToJailSquare extends PropertySquare {

	public GoToJailSquare(SquareGroup group, int price, int rent) {
		super(group, price, rent);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Sends player to Jail
	 */
	private void goToJail(Player player) {
		player.setInJail(true);
		player.setPosition(Square.Jail.getBoardPosition());
		player.resetDoubleCount();
		System.out.println("Landed on Go To Jail, going to Jail!");
	}

	@Override
	public void handleMove(Move move) {
		goToJail(move.getPlayer());
	}
}
