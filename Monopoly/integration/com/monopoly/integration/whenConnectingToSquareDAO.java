package com.monopoly.integration;

import static org.junit.Assert.*;

import org.junit.Test;

import com.monopoly.Square;

public class whenConnectingToSquareDAO {

	@Test
	public void shouldSelectSquareByPosition() {
		RealSquareDao dao = new RealSquareDao();
		Square square = dao.getSquareByPosition(39);
		assertEquals("Boardwalk", square.getName());		
	}

}
