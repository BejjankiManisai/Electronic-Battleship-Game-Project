package com.game.battleship.state;

import com.game.battleship.exceptions.DomainException;
import com.game.battleship.model.BattleShipGame;

public class StartedGameState implements GameState {
	private BattleShipGame game;

	public StartedGameState(BattleShipGame game) {
		this.game = game;
	}

	@Override
	public void newGame() {
		this.game.setCurrentGameState(this.game.getNewGameState());
	}

	@Override
	public void start() {
		throw new DomainException("A game is already underway!\r\n" + 
				"");
	}

}
