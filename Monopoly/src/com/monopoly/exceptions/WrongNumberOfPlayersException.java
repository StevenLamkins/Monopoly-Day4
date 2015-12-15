package com.monopoly.exceptions;

public class WrongNumberOfPlayersException extends RuntimeException {
	public WrongNumberOfPlayersException(String message) {
		super(message);
	}
}
