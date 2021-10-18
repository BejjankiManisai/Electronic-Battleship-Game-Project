package com.game.battleship.observer;

import java.util.Observable;
import java.util.Observer;

import com.game.battleship.model.ComputerPlayer;
import com.game.battleship.model.HumanPlayer;

public class CalculateScore implements Observer {
	private int score = 0;
	@SuppressWarnings("unused")
	private Observable observable;

	public CalculateScore(Observable observable) {
		this.setScore(19);
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof HumanPlayer || o instanceof ComputerPlayer) {
			this.setScore(score - 1);
		}

	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
