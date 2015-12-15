package com.monopoly;
import java.util.ArrayList;
import java.util.List;

import com.dicegame.Die1;


public class MonopolyGame {
	
	List<Space> board;
	List<Player> gameplayer;
	Die1 die = new Die1();
	
	public MonopolyGame() {
		board = new ArrayList<Space>(40);
		
		for(int i =0;i<40;i++)
		{
			Space squares = new Space();
			board.add(squares);
		}
		
		addPlayers();
	}
	
	public List<Space> getSpace() {
		
		return board;
	}
	
	public void addPlayers(){
		gameplayer = new ArrayList<Player>(4);
		
		for(int i =0;i<4;i++)
		{
			Player player = new Player();
			gameplayer.add(player);
		}
		
	}
	
	public List<Player> getPlayers(){
		
		return gameplayer;
	}


}
