package com.game.battleship.model;

import com.game.battleship.observer.CalculateScore;
import com.game.battleship.state.GameState;
import com.game.battleship.state.NewGameState;
import com.game.battleship.state.StartedGameState;

public class BattleShipGame {
	private HumanPlayer humanPlayer;
	private ComputerPlayer computerPlayer;

	private CalculateScore scoreHumanPlayer;
	private CalculateScore scoreComputerPlayer;

	private GameState newGameState = new NewGameState(this);
	private GameState StartedGameState = new StartedGameState(this);
	private GameState currentGameState = newGameState;

	public BattleShipGame(String naam) {
		humanPlayer = new HumanPlayer(naam);
		computerPlayer = new ComputerPlayer();
		scoreHumanPlayer = new CalculateScore(humanPlayer);
		scoreComputerPlayer = new CalculateScore(computerPlayer);
	}

	public GameState getCurrentGameState() {
		return this.currentGameState;
	}

	public void setCurrentGameState(GameState gameState) {
		this.currentGameState = gameState;
	}

	public HumanPlayer getHumanPlayer() {
		return humanPlayer;
	}

	public ComputerPlayer getComputerPlayer() {
		return computerPlayer;
	}

	public GameState getNewGameState() {
		return newGameState;
	}

	public GameState getStartedGameState() {
		return StartedGameState;
	}

	public void start() {
		this.currentGameState.start();
	}

	public void newGame() {
		this.currentGameState.newGame();
	}

	public CalculateScore getScoreHumanPlayer() {
		return this.scoreHumanPlayer;
	}

	public CalculateScore getScoreComputerPlayer() {
		return this.scoreComputerPlayer;
	}

}