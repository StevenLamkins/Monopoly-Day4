package com.monopoly;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
			System.out.println("The game is over! The " + players.get(0).getToken() + " has won!");
			gameRunning = false;
		}
	}
	
	public static void main(String[] args) {
		MonopolyGame game = new MonopolyGame(8);
		Scanner keyboard = new Scanner(System.in);
		int counter = 0;
		while(game.getGameRunning()){
			StringBuilder output = new StringBuilder();
			for (Player player : game.getPlayers()) {
				if(player.getToken().equals("Thimbal") || player.getToken().equals("WheelBarrow")){
					output.append(player.getToken()+":\t\tPrevious Roll - " + player.getPreviousRoll() + "\tMoney - "+player.getMoney() + "\tProperty Count - "+player.ownedProperties.size()+"\tSquare - " + player.getSquare().getId()+ "\n");
				}
				else{
					output.append(player.getToken()+":\t\t\tPrevious Roll - " + player.getPreviousRoll() + "\tMoney - "+player.getMoney() + "\tProperty Count - "+player.ownedProperties.size()+"\tSquare - " + player.getSquare().getId()+"\n");
				}
			}
			System.out.println(output.toString());
			System.out.println("Turn: " + counter++ + "--------------------------------ENTER TO CONTINUE---------------------------------------");
			try {
				System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
//			keyboard.next();
			game.runRound();
		}
	}//end main
	
	
}//end MonopolyGame
