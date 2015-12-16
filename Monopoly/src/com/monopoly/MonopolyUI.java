package com.monopoly;

import java.util.Scanner;

public class MonopolyUI {
	private MonopolyGame game;
	private Scanner scanner;
	
	public MonopolyUI() {
		scanner = new Scanner(System.in);
	}
	
	public void startLoop()
	{
		boolean loop = true;
		System.out.print("How many players? ");
		game = new MonopolyGame(scanner.nextInt());
		scanner.nextLine();
		while(loop)
		{
			System.out.println("Take turn? ");
			String input = scanner.nextLine();
			game.playRound();
			for(Player player : game.getPlayers())
			{
				System.out.println(player.getToken() + " has " + player.getMoney() + " money.");
			}
		}
	}
}
