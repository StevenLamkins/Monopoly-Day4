package com.monopoly.ui;

import java.util.List;

import com.monopoly.MonopolyGame;
import com.monopoly.PlayerInfo;

public class MonopolyApp {

	public static void main(String[] args) {
		MonopolyGame game = new MonopolyGame(2);
		List<PlayerInfo> players = game.getPlayers();
		
		for (int i=0; i < 20; i++) {
			game.playRound();
			for (PlayerInfo player : players) {
				System.out.println(player.getToken() + " rolled a " + player.getLastRoll());
				System.out.println(player.getToken() + " landed on " + player.getPosition().getName());
				System.out.println(player.getToken() + " has " + player.getBalance());
			}
		}
		

	}

}
