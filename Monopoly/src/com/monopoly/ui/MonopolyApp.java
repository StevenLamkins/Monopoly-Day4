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
		 System.out.println(player.getToken() + " rolled a " +
		 player.getLastRoll());
		 System.out.println(player.getToken() + " land on " +
		 player.getSquare().getName());
		 System.out.println(player.getToken() + " has $" +
		 player.getAccountBalance());
		 }
		 System.out.println("-----------------------");
		 }
		 
		 
//To simulate a full game must change go square to collect $20
//		int countBalanceNotNegative = game.getPlayers().size();
//		int round = 0;
//		while (countBalanceNotNegative > 1) {
//			countBalanceNotNegative = 0;
//			for (PlayerInfo playerInfo : players) {
//				if (playerInfo.getAccountBalance() > 0)
//					countBalanceNotNegative++;
//			}
//			game.playRound();
//			for (PlayerInfo player : players) {
//				// System.out.println(player.getToken() + " rolled a " +
//				// player.getLastRoll());
//				// System.out.println(player.getToken() + " land on " +
//				// player.getSquare().getName());
//				System.out.println(player.getToken() + " has $"
//						+ player.getAccountBalance());
//			}
//			round++;
//			System.out.println("--------Round " + round + "---------------");
//		}
//		String winner = "nobody";
//		for (PlayerInfo player : players) {
//			System.out.println(player.getToken() + " has $"
//					+ player.getAccountBalance());
//			if(player.getAccountBalance() > 0)
//			{
//				winner=player.getToken().name();
//			}			
//		}
//		System.out.println("The Winner is " + winner + "!!");


	}

}
