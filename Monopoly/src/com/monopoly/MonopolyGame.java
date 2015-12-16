package com.monopoly;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MonopolyGame {

	Board board = new Board();
	static List<Player> players = new ArrayList<Player>();
	Die die = new Die();
	Boolean gameRunning=true;
	
	public Boolean getGameRunning() {
		return gameRunning;
	}

	public MonopolyGame (int playerCount){
		if (playerCount<2){
			throw new IllegalArgumentException("Too few players");
		}//end if
		else if (playerCount>8){
			throw new IllegalArgumentException("Too many players");
		}//end if
		players = new ArrayList<Player>();
		for (int i = 0; i < playerCount; i++) {
			players.add(createPlayer(i));
		}
		
	}//end M
	
	public Player createPlayer(int playerNumber){
		String pieceName="";
		switch (playerNumber) {
		case 0:
			pieceName="Boat";
			break;
		case 1:
			pieceName="Dog";
			break;
		case 2:
			pieceName="Hat";
			break;
		case 3:
			pieceName="Shoe";
			break;
		case 4:
			pieceName="Car";
			break;
		case 5:
			pieceName="Iron";
			break;
		case 6:
			pieceName="Thimbal";
			break;
		case 7:
			pieceName="WheelBarrow";
			break;
		default:
			pieceName="Boat";
			break;
		}
		Player newPlayer = new Player(pieceName,board.getSquares().get(0)); 
		
		return newPlayer;
	}
	
	public List<Square> getSquares() {
		return board.getSquares();
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public void runRound(){
		if(players.size()>=2){
			List<Player> removeThese = new ArrayList<Player>();
			Iterator<Player> playerIterator = players.iterator();
			while(playerIterator.hasNext()){
				Player player = playerIterator.next();
				if(!player.takeTurn(die, true)){
					removeThese.add(player);
				}
			}
			for (Player player : removeThese) {
				System.out.println("Player " + player.getToken() + " Eliminated! Lost on square " + player.getSquare().getId());
				player.loseGame();
				players.remove(player);
			}
		}
		else{
			if(players.isEmpty())
				System.out.println("The game is over! No one won!");
			else
				System.out.println("The game is over! The " + players.get(0).getToken() + " has won!");
			gameRunning = false;
		}
	}
	
	public int runGame(Map<String, Integer> turnMap, int attempt){
		int counter=0;
		boolean tooRichToPlay=true;
		while(this.getGameRunning()){
			tooRichToPlay=true;
			StringBuilder output = new StringBuilder();
			for (Player player : players) {
				if(player.getToken().equals("Thimbal") || player.getToken().equals("WheelBarrow")){
					output.append(player.getToken()+":\t\tPrevious Roll - " + player.getPreviousRoll() + "\tMoney - "+player.getMoney() + "\tProperty Count - "+player.ownedProperties.size()+"\tSquare - " + player.getSquare().getId()+ "\n");
				}
				else{
					output.append(player.getToken()+":\t\t\tPrevious Roll - " + player.getPreviousRoll() + "\tMoney - "+player.getMoney() + "\tProperty Count - "+player.ownedProperties.size()+"\tSquare - " + player.getSquare().getId()+"\n");
				}
				if(player.getMoney()<5000)
					tooRichToPlay=false;
			}
			System.out.println(output.toString());
			System.out.println("Turn: " + counter++ + "--------------------------------ENTER TO CONTINUE---------------------------------------");
			this.runRound();
			if(tooRichToPlay)
				this.gameRunning=false;
		}
		if(tooRichToPlay){
			turnMap.put("Rich"+Integer.toString(attempt), counter);
		}
		else{
			turnMap.put("Monopoly"+Integer.toString(attempt), counter);
		}
		return counter;
	}
	
	public static void main(String[] args) {
		double turnCounter=0;
		Map<String, Integer> turnMap = new HashMap<String, Integer>(); 
		for(int i=0; i<100; i++){
			MonopolyGame game = new MonopolyGame(4);
			turnCounter+=game.runGame(turnMap, i);
		}
		double richEnding=0, monopolyEnding=0, richAverage=0, monopolyAverage=0;
		for (String key : turnMap.keySet()) {
			if(key.contains("Rich")){
				richEnding++;
				richAverage+=turnMap.get(key);
			}
			else{
				monopolyEnding++;
				monopolyAverage+=turnMap.get(key);
			}
		}
		System.out.println("Rich ending count: " + richEnding + " with an average turn count of: " + richAverage/richEnding);
		System.out.println("Monopoly ending count: " + monopolyEnding + " with an average turn count of: " + monopolyAverage/monopolyEnding);
	}//end main
	
	
}//end MonopolyGame
