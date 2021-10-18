package com.game.battleship;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import com.game.battleship.factory.PlaceShipFactory;
import com.game.battleship.strategy.PlaceShipStrategy;

public class PlaceShipFactoryTest {
	
	@Test
	public void getPlaceShipStrategyTest() {
		PlaceShipFactory placeShipFactory = new PlaceShipFactory();
		PlaceShipStrategy placeShipStrategy= placeShipFactory.getPlaceShipStrategy();
		assertTrue(placeShipFactory instanceof PlaceShipFactory);
	}

}
