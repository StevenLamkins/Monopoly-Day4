package com.monopoly.ui;

import java.util.List;

import com.monopoly.MonopolyGame;
import com.monopoly.PlayerInfo;
import com.monopoly.Token;

public class MonopolyApp {

	public static void main(String[] args) {
		MonopolyGame game = new MonopolyGame();
		for (Token token : Token.values()) {
			game.addPlayer(token);
		}
		List<PlayerInfo> players = game.getPlayers();

		for (int i = 0; i < 10; i++) {
			game.playRound();
			for (PlayerInfo player : players) {
				System.out.println(player.getToken() + " rolled a " + player.getLastRoll());
				System.out.println(player.getToken() + " land on " + player.getSquare().getName());
				System.out.println(player.getToken() + " has $" + player.getAccountBalance());
			}
			System.out.println("-----------------------");
		}

	}

}
