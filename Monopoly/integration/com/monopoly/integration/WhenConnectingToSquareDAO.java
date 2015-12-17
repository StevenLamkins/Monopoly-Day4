package com.monopoly.integration;

import static org.junit.Assert.*;

import org.junit.Test;

import com.monopoly.squares.Square;

public class WhenConnectingToSquareDAO {

	@Test
	public void shouldSelectSquareByPosition() {
		RealSquareDao dao = new RealSquareDao();
		//Square square = dao.getSquareByName("Boardwalk");
		Square square = dao.getSquareByPosition(40);
		assertEquals("Boardwalk", square.getName());
	}

}
