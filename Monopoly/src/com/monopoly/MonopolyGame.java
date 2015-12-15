package com.monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {

	Board board = new Board();
	Die die = new Die();
	List<Player> players = new ArrayList<Player>();
	
	public MonopolyGame (int playerCount){
		if (playerCount<2){
			throw new IllegalArgumentException("To Few Players");
		}//end if
		else if (playerCount>8){
			throw new IllegalArgumentException("To many Players");
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
		Player newPlayer = new Player(pieceName,0); 
		
		return newPlayer;
	}
	
	public List<Square> getSquares() {
		return board.getSquares();
	}
	
	public static void main(String[] args) {
		
	}//end main
	
	
}//end MonopolyGame
