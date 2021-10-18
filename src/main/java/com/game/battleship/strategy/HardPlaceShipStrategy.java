package com.game.battleship.strategy;

import java.util.ArrayList;
import java.util.Random;

import com.game.battleship.model.Direction;
import com.game.battleship.model.Ship;
import com.game.battleship.model.ShipType;

public class HardPlaceShipStrategy implements PlaceShipStrategy {

	@Override
	public Ship placeRandomShip() {
		Random random = new Random();
		ShipType shipType = this.getType(random);
		Direction direction = this.getDirection(random);
		int startBox = this.getSquare();
		return new Ship(shipType, direction, startBox);
	}

	private ShipType getType(Random random) {
		ShipType shipType;
		if (random.nextInt(7) == 0) {
			// 20% chance of bigger ship (CARRIER = 0, BATTLESHIP = 1)
			shipType = ShipType.values()[random.nextInt(1)];
		} else {
			// 80% chance of smaller ship
			// To get randint between min=3 and max=length: random.nextInt(max -
			// min + 1) + min
			shipType = ShipType.values()[random.nextInt(ShipType.values().length - 2 + 1) + 2];
		}
		return shipType;
	}

	private Direction getDirection(Random random) {
		Direction direction;
		if (random.nextInt(5) == 0) {
			// 60% chance of vertical
			direction = Direction.values()[0];
		} else {
			// else horizontal
			direction = Direction.values()[1];
		}
		return direction;
	}

	private int getSquare() {
		int startBox = (int) (Math.random() * 99);
		// try to avoid column 1, 5 and 10
		ArrayList<Integer> squaresToAvoid = this.getSquaresToAvoid();
		boolean optimalsquare = false;
		while (optimalsquare != true) {
			startBox = (int) (Math.random() * 99);
			if (!squaresToAvoid.contains(startBox)) {
				optimalsquare = true;
			}
		}
		return startBox;
	}

	private ArrayList<Integer> getSquaresToAvoid() {
		ArrayList<Integer> squaresToAvoid = new ArrayList<Integer>();
		for (int i = 0; i <= 9; i++) {
			squaresToAvoid.add(i); // kolom 1
			squaresToAvoid.add(i + 40); // kolom 5
			squaresToAvoid.add(i + 90); // kolom 10
		}
		return squaresToAvoid;
	}

}
