package com.monopoly.app;

import com.monopoly.MonopolyGame;
import com.monopoly.Player;

public class MonopolyApp {

	public static void main(String[] args) {
		MonopolyGame game = new MonopolyGame();
		System.out.println("Game Started with " + game.getNumPlayers() + " players.");
		game.playRound();
		for (Player player : game.getPlayers()) {
			System.out.println(player.getToken() + " landed on " + player.getLocation().getName() + " and now has balance of " + player.getBalance() +  ".");
		}
		
	}

}
