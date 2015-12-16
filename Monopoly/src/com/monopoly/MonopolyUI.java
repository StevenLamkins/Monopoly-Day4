package com.monopoly;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MonopolyUI {
	private MonopolyGame game;
	private Scanner scanner;
	
	public MonopolyUI() {
		scanner = new Scanner(System.in);
	}
	
	public void startLoop()
	{
		System.out.print("How many players? ");
		game = new MonopolyGame(scanner.nextInt());
		scanner.nextLine();
		while(true)
		{
			System.out.print("Take turn? y or n: ");
			String input = scanner.next();
			if (input.startsWith("n") || input.startsWith("N")) 
			{
				break;
			}
			else if (input.startsWith("y") || input.startsWith("Y")) 
			{
				game.playRound();
				for(Player player : game.getPlayers())
				{
					System.out.println(player + " is at " + player.getSquare() + " and has $" + player.getMoney());
				}
			}
		}
		System.out.println("Bye!");
	}
}
