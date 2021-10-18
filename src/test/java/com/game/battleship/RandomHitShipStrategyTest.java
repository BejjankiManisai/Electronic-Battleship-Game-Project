package com.game.battleship;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import com.game.battleship.strategy.RandomHitShipStrategy;


public class RandomHitShipStrategyTest {
	
	@Test
	public void hitShipTest() {
		RandomHitShipStrategy randomHitShipStrategy = new RandomHitShipStrategy();
		int hitCount = randomHitShipStrategy.hitShip();
		assertTrue(hitCount <= 100);
	}

}
