package com.monopoly.integration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.monopoly.squares.Square;

public class WhenConnectingToSquareDAO {

	@Test
	public void shouldSelectSquareByPosition() {
		RealSquareDao dao = new RealSquareDao();
		Square square = dao.getSquareByPosition(40);

		//query = "SELECT * FROM Monopoly.PROPERTIES where Position = 39;";
		assertEquals("Boardwalk",square.name());
	}

}
