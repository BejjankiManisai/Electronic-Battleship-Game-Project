package com.game.battleship.state;

import com.game.battleship.exceptions.DomainException;
import com.game.battleship.model.BattleShipGame;

public class NewGameState implements GameState {
	private BattleShipGame game;

	public NewGameState(BattleShipGame game) {
		this.game = game;
	}

	@Override
	public void newGame() {
		throw new DomainException("Can't start a new game if it hasn't already started!");
	}

	@Override
	public void start() {
		if (game.getHumanPlayer().getNoOfShips() != 5) {
			throw new DomainException("There are 5 ships to be placed!");
		}
		game.setCurrentGameState(game.getStartedGameState());
	}

}
