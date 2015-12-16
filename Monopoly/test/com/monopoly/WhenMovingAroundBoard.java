package com.monopoly;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

public class WhenMovingAroundBoard {
	
	MonopolyGame game = new MonopolyGame();
	Square firstSquare  = new Square("1", 1);
	Square square2 = new Square("2", 2);
	Square square3 = new Square("3", 3);
	Square square4 = new Square("4", 4);
	
	@Before
	public void setupSquares() {
		firstSquare.setNext(square2);
		square2.setNext(square3);
		square3.setNext(square4);
		square4.setNext(firstSquare);
	}
	
	@Test
	public void playersShouldLeaveGoSquareAfterARound() {
		game.setNumPlayers(8);
		
		List<Square> squares = game.getSquares();
		Square firstSquare = squares.get(0);
		game.playRound();
		for (Player player: game.getPlayers()) {
			Square currSquare = player.getPosition();
			assertNotNull (currSquare);
			assertNotSame(currSquare, firstSquare);
		}
	}
	
	@Test
	public void playersShouldCircleTheBoard() {
		Player player = new Player(Token.Dog, firstSquare);
		player.takeTurn(new LoadedDice(4));
		assertSame (player.getPosition(), firstSquare);
		
	}
	
	@Test
	public void playerShouldMoveWhenTakingTurn() {
		Square square1 = new Square("1", 1);
		Square square2 = new Square("2", 2);
		square1.setNext(square2);
		square2.setNext(square1);
		Player player = new Player(Token.Dog, square1);
		Dice testDice = new LoadedDice(1);
		player.takeTurn(testDice);
		assertNotNull(player.getPosition());
		assertSame(player.getPosition(), square2);
	}
	
	@Test
	public void diceShouldRoll2Dice() {
		Dice dice = new Dice();
	
		for (int i = 1; i < 100; i++) {
			int rollVal = dice.roll();
			//System.out.println("Roll Value: " + rollVal);
			assertTrue (rollVal <= 12);
			assertTrue (rollVal >=2);
		}
	}
	
	public void playerShouldMoveTheRightNumberOfSquares() {
		
		Player player = new Player (Token.Dog, firstSquare);
		player.takeTurn(new LoadedDice(2));
		assertSame (player.getPosition(), square3);
		
		player.takeTurn(new LoadedDice(3));
		assertSame (player.getPosition(), square2);
	}
}

