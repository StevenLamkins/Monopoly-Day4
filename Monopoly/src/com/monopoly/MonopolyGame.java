package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {
	private List<Player> players;
	private List<Square> squares;

	
	public MonopolyGame (int numberPlayers)
	{
		players = new ArrayList<Player>();
		squares = new ArrayList<Square>();
		
		Square sq = new Square();
		sq.setName("Go");
		for (int i =0; i<40; i++)
		{
			squares.add(sq);
		}
		

		for (int i = 0; i < numberPlayers; i++)
		{
			Player p = new Player();
			p.setToken("king"+(i+1));
			p.setLocation(squares.get(0));
			players.add(p);
		}
		
	}
	

	public List<Square> getSquares() {
		
		return squares ;
	}

	public List<Player> getPlayers() {
		

		return players;
	}

}
