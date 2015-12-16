package com.monopoly.ui;

import java.util.List;

import com.monopoly.MonopolyGame;
import com.monopoly.Player;

public class MonopolyApp {

	public static void main(String[] args) 
	{
		MonopolyGame game = new MonopolyGame(2);
		
		List<Player> players = game.getPlayers();
		
		for (int i = 0; i < 10; i++) 
		{
			game.playRound();
			for (Player player : players) 
			{
				System.out.println(player.getName() + " rolled a " + player.getCurrentRoll());
				System.out.println(player.getName() + " landed on " + player.getCurrentPosition().getName());
				System.out.println(player.getName() + " has $" + player.getMoney());
			}
			System.out.println("--------------------------------");
		}
	}

}
