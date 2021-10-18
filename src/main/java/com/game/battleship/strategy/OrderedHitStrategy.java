package com.game.battleship.strategy;

public class OrderedHitStrategy implements HitShipStrategy {

	private int lastInteger = -1;

	@Override
	public int hitShip() {
		if (lastInteger < 99) {
			lastInteger++;
		}
		return lastInteger;

	}

}
