package com.game.battleship;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.game.battleship.exceptions.DomainException;
import com.game.battleship.model.BattleShipGame;
import com.game.battleship.state.NewGameState;
public class NewGameStateTest {
	
	@Test
	public void newGameTest() {
		BattleShipGame battleShipGame = new BattleShipGame("Test Player");
		NewGameState newGameState = new NewGameState(battleShipGame);
		try {
		newGameState.start();
		}catch (RuntimeException e) {
			assertTrue(e instanceof DomainException);
		}	
	}

}
