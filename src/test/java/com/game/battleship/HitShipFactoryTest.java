package com.game.battleship;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import com.game.battleship.factory.HitShipFactory;
import com.game.battleship.strategy.HitShipStrategy;


public class HitShipFactoryTest {
	
	@Test
	public void getHitShipStrategyTest() {
		HitShipFactory hitShipFactory = new HitShipFactory();
		HitShipStrategy hitShipStrategy  = hitShipFactory.getHitShipStrategy();
		assertTrue(hitShipStrategy instanceof HitShipStrategy);
	}

}
