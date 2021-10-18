package com.game.battleship.model;

import com.game.battleship.factory.HitShipFactory;
import com.game.battleship.factory.PlaceShipFactory;
import com.game.battleship.strategy.HitShipStrategy;
import com.game.battleship.strategy.PlaceShipStrategy;

public class ComputerPlayer extends HumanPlayer {

	public PlaceShipStrategy placeShipStrategy;
	public HitShipStrategy hitShipStrategy;

	public ComputerPlayer() {
		super("Computer");
		this.readHitStrategyFromProp();
		this.readPlaceShipFromProp();
	}

	public void setShipsFromStrategy() {
		while (this.getShips().size() != MAX_SHIPS) {
			try {
				Ship generatedShip = placeShipStrategy.placeRandomShip();
				this.addShip(generatedShip);
			} catch (Exception e) {
			}
		}
	}

	public int hitShip() {
		return hitShipStrategy.hitShip();
	}

	public void readHitStrategyFromProp() {
		hitShipStrategy = new HitShipFactory().getHitShipStrategy();
	}

	public void readPlaceShipFromProp() {
		placeShipStrategy = new PlaceShipFactory().getPlaceShipStrategy();
	}

}
