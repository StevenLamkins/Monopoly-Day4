package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class WhenMovingPlayers {
	private MonopolyGame game;
	private List<Player> players;
	private int numberOfMoves;
	private Square newLocation = new Square();

	@Test
	public void shouldLeaveGoSquare() {
		//setup
		game = new MonopolyGame(4);
		players =  game.getPlayers();
		
		for (Player p : players)
		{
			numberOfMoves= p.rollDice();
			newLocation.setName("Square "+numberOfMoves);
			p.setLocation(newLocation);
		}
		
		for (Player p : players)
		{


			assertNotEquals("Go", p.isOnGo());
		}
		
	}

	@Test
	public void shouldMovePlayerCorrectNumberOfSquares() {
		//setup
		game = new MonopolyGame(4);
		players =  game.getPlayers();
		

		for (Player p : players)
		{
			numberOfMoves= p.rollDice();
			newLocation.setName("Square "+numberOfMoves);
			p.setLocation(newLocation);
			
			assertEquals("Square "+numberOfMoves,p.getLocation().getName());
		}
		
	
	}

	@Test
	public void shouldCircleTheBoard() {
		//setup
		game = new MonopolyGame(2);
		players =  game.getPlayers();

		while (true)
		{
			for (Player p : players)
			{
				numberOfMoves= p.rollDice();
				newLocation.setName("Square "+numberOfMoves);
				p.setLocation(newLocation);
				if (p.getWhereAbout() > 40)
				{
					assertTrue(p.getWhereAbout() > 40);
					break;
				}
				
			}
			break;
		}



	}

}
