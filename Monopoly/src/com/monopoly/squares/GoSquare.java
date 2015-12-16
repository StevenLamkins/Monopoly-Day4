package com.monopoly.squares;

import com.monopoly.board.Move;
import com.monopoly.player.Player;

public class GoSquare extends SquareType {
	
	public GoSquare(SquareGroup group, int price, int rent) {
		super(group, price, rent);
	}
	
	@Override
	public void handleMove(Move move) {
		Player player = move.getPlayer();
		player.deposit(200);
		System.out.println(player+" landed on Go! Receive $200, balance is now "+player.getBalance());
		
		SquareType.incrementNumGoPasses();
	}
}
