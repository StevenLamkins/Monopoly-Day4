package com.monopoly;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	@Test
	public void shouldStartPlayersOnGo() {
		//setup
		setup();
		//exercise
		List<Square> gameSquares = game.getSquares();
		List<Player> playersOnGo = gameSquares.get(0).getPlayersOnSpace();
		//verify
		assertEquals(game.getPlayers().size(), playersOnGo.size());
	}
	@Test
	public void shouldHaveUniqueTokensForPlayers() {
		//setup
		setup();
		List<String> playerList = new ArrayList<String>();
		//exercise
		
		for(int i=0; i < players.size(); i++){
			playerList.add(players.get(i).getToken());
		}
		
		Set<String> hashsetTokens = new HashSet<String>(playerList);
		
		//verify
		assertEquals(players.size(), hashsetTokens.size());
		
		
	}
	
	
}

