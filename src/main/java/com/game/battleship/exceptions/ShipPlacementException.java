package com.game.battleship.exceptions;

@SuppressWarnings("serial")
public class ShipPlacementException extends RuntimeException {

	public ShipPlacementException(String message, Exception exception) {
		super(message, exception);
	}
	
	public ShipPlacementException(String message) {
		super(message);
	}
	
	public ShipPlacementException() {
		super();
	}

}
