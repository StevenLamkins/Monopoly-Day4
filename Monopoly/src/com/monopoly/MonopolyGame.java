package com.monopoly;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

import com.monopoly.squares.Square;

public class MonopolyGame {

	private List<Player> players = new ArrayList<>();
	private List<Die> dice = new ArrayList<>();
	private Board board  = new Board();

	public enum Token{Dog, Thimble, Iron, Battleship, Wheelbarrow, Pen, Shoe, Tophat, Car};
	
	public MonopolyGame(int maxPlayers) {
		if(maxPlayers > 8)
		{
			throw new IllegalArgumentException("Too many players!");
		}
		if(maxPlayers < 2)
		{
			throw new IllegalArgumentException("Too few players!");
		}

		dice.add(new Die(14561));
		dice.add(new Die(123048));

		Iterator<Token> tokens = EnumSet.allOf(Token.class).iterator();
		for(int j = 0; j < maxPlayers && tokens.hasNext(); j++){
			players.add(new Player(board.getSquares().get(0), tokens.next(), dice));
		}
	}

	public List<Square> getSquares() {
		return board.getSquares();
	}

	public List<Player> getPlayers() {
		return players;
	}
	
	public List<Die> getDice() {
		return dice;
	}
	
	public void  playRound() {
		for (Player player : players) {
			player.takeTurn();
		}
	}
	
	public void playDistanceGame() {
		for (int index = 0; index < 10; ++index)
		{
			playRound();
		}
		List<Player> winners = new ArrayList<Player>();
		int winPosition = getDistanceGameWinners(winners);
		showDistanceGameWinners(winners, winPosition);
	}

	private int getDistanceGameWinners(List<Player> winners) {
		int winPosition = -1;
		winners.clear();
		for (Player player : players) 
		{
			int playerPosition = player.getPosition();
			// New single winner, clear winner list and set new winning score
			if (playerPosition > winPosition)
			{
				winners.clear();
				winners.add(player);
				winPosition = playerPosition;
			}
			// Tied winner, add them to the list
			else if (playerPosition == winPosition)
			{
				winners.add(player);
			}
		}
		return winPosition;
	}
	
	private void showDistanceGameWinners(List<Player> winners, int winPosition) {
		System.out.println("Winning player(s) at position " + winPosition);
		for (Player winner : winners)
		{
			System.out.println("  " + winner);
		}
	}

	
}
