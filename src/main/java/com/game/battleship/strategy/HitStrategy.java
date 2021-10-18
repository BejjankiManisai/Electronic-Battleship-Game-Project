package com.game.battleship.strategy;

public enum HitStrategy {
	RANDOM("com.game.battleship.strategy.RandomHitShipStrategy"), ORDERED("com.game.battleship.strategy.OrderedHitStrategy");

	private String fullClassName;

	private HitStrategy(String fullClassName) {
		this.fullClassName = fullClassName;
	}

	public String getFullClassName() {
		return this.fullClassName;
	}

}
