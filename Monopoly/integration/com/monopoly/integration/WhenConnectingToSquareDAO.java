package com.monopoly.integration;

import static org.junit.Assert.*;

import org.junit.Test;

import com.monopoly.Square;

public class WhenConnectingToSquareDAO {

	@Test
	public void shouldSelectSquareByPosition()
	{
		RealSquareDAO dao = new RealSquare DAO();
		Square square = dao.getSquareByPosition(39);
		assertEquals("Boardwalk", square.getName());
	}

}
