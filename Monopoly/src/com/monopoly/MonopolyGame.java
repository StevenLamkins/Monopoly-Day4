package com.monopoly;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.dicegame.Die1;


public class MonopolyGame {
	
	Board boardgame;
	Set<Token> piece; 
	List<Player> gameplayer;
	int numOfPlayers;
	Die1 die = new Die1();
	
	public MonopolyGame(int num){
		
		//start game
		boardgame = new Board();
		
		//creates players
		numOfPlayers = num;
		if (numOfPlayers < 2 || numOfPlayers > 8 ) throw new WrongNumberOfPlayers("Wrong Number of Players");
		else
			addPlayers();
	}
		
	public void addPlayers(){
		gameplayer = new ArrayList<Player>(numOfPlayers);
		
		for(int i =0;i<numOfPlayers;i++)
		{
			Player player = new Player();
			gameplayer.add(player);
		}
		
	}
	
	public void createAllTokens(){
		piece = new ArrayList<Token>();
		
	}
	
	public List<Player> getPlayers(){
		
		return gameplayer;
	}
	
	public List<Space> getSpaces() {
		return boardgame.getSpaces();
	}
	
	//public Set<Token> assignToken()


}
