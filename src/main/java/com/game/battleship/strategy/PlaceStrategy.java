package com.game.battleship.strategy;

public enum PlaceStrategy {
	RANDOM("com.game.battleship.strategy.RandomPlaceShipStrategy"),
	HARD("com.game.battleship.strategy.HardPlaceShipStrategy");

	private String fullClassName;

	private PlaceStrategy(String fullClassName) {
		this.fullClassName = fullClassName;
	}

	public String getFullClassName() {
		return this.fullClassName;
	}

}
