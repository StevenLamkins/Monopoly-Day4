package com.monopoly.run;

import java.util.Scanner;

import com.monopoly.MonopolyGame;

public class MonopolyApp {
	
	private static int numberOfPlayers;

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter the number of players: ");
		numberOfPlayers = keyboard.nextInt();
		
		MonopolyGame game = new MonopolyGame(numberOfPlayers);
	}

}
