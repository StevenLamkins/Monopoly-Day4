package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

public class WhenSettingUpGame {
	
	private MonopolyGame game;
	List<Player> players;
	
	public void setup(){
		int numOfPlayers = 5;
		game = new MonopolyGame(numOfPlayers);
		players = game.getPlayers();
	}
	
	@Test
	public void shouldHave40Squares() {
		//setup
		setup();
		//exercise
		List<Square> squares = game.getSquares();
		//verify
		assertEquals(40, squares.size());
	}
	
	@Test
	public void shouldHaveCorrectNumberOfPlayers() {
		//setup
		setup();
		//exercise
		int numOfPlayers = 5;
		//verify
		assertEquals(numOfPlayers, players.size());
	}
	
	@Test
	public void shouldErrorWithTooManyPlayers() {
		int numOfPlayers = 9;
		boolean fail = false;
		try{
			game = new MonopolyGame(numOfPlayers);
		}
		catch(IllegalArgumentException e){
			if(e.getMessage() == "Too many players"){
				fail = true;
			}
			
		};
		assertEquals(fail, true);
	}
	
	@Test
	public void shouldErrorWithTooFewPlayers() {
		int numOfPlayers = 1;
		boolean fail = false;
		try{
			game = new MonopolyGame(numOfPlayers);
		}
		catch(IllegalArgumentException e){
			if(e.getMessage() == "Too few players"){
				fail = true;
			}
			
		};
		assertEquals(fail, true);
	}
	@Ignore
	@Test
	public void shouldStartPlayersOnGo() {
		fail("Not yet implemented");
	}
	@Ignore
	@Test
	public void shouldHaveUniqueTokensForPlayers() {
		fail("Not yet implemented");
	}
	
	
}

