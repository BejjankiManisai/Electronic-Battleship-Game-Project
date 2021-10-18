package com.game.battleship;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import com.game.battleship.exceptions.ShipPlacementException;
import com.game.battleship.model.Ship;
import com.game.battleship.strategy.RandomPlaceShipStrategy;

public class RandomPlaceShipStrategyTest {
	
	@Test
	public void placeRandomShipTest() {
		RandomPlaceShipStrategy ramPlaceShipStrategy = new RandomPlaceShipStrategy();
		try {
		Ship ship=ramPlaceShipStrategy.placeRandomShip();
		assertTrue(ship instanceof Ship);
		} catch(RuntimeException e) {
			assertTrue(e instanceof ShipPlacementException);
		}
	}

}
