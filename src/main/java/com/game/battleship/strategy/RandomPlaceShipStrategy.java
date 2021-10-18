package com.game.battleship.strategy;

import java.util.Random;

import com.game.battleship.model.Direction;
import com.game.battleship.model.Ship;
import com.game.battleship.model.ShipType;

public class RandomPlaceShipStrategy implements PlaceShipStrategy {

	@Override
	public Ship placeRandomShip() {
		Random random = new Random();
		ShipType shipType = ShipType.values()[random.nextInt(ShipType.values().length)];
		Direction direction = Direction.values()[random.nextInt(Direction.values().length)];
		int startBox = (int) (Math.random() * 99);
		return new Ship(shipType, direction, startBox);
	}

}