package com.game.battleship.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.game.battleship.exceptions.DomainException;

public class HumanPlayer extends Observable{
	
	private String name;
	private ArrayList<Ship> ships = new ArrayList<Ship>();
	public static final int MAX_SHIPS = 5;
	
	public HumanPlayer() {
		this("Player1");
	}
	
	public HumanPlayer(String name) {
		this.setName(name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			this.name = "Player1";
		} else {
			this.name = name;
		}
	}
	
	public Ship getShipContainsNumber(int nummer) {
		for (Ship ship : this.getShips()) {
			if (ship.getShipNumbers().contains(nummer)) {
				return ship;
			}
		}
		return null;
	}
	
	public boolean addHitToShip(int number) {
		// returns if ship was destroyed
		Ship ship = this.getShipContainsNumber(number);
		if (ship == null) {
			throw new DomainException("Ship was not found!");
		}
		ship.addNumberHit(number);
		boolean destroyed = false;
		if (ship.getHitShipNumbers().containsAll(ship.getShipNumbers())) {
			destroyed = true;
		}
		this.setChanged();
		this.notifyObservers();
		return destroyed;
	}
	
	public ArrayList<Ship> getAllDestroyedShips() {
		ArrayList<Ship> destroyedShips = new ArrayList<Ship>();
		for (Ship ship : this.getShips()) {
			if (ship.getHitShipNumbers().containsAll(ship.getShipNumbers())) {
				destroyedShips.add(ship);
			}
		}
		return destroyedShips;
	}
	
	public boolean isGameOver() {
		boolean gameOver = false;
		if (this.getAllDestroyedShips().containsAll(this.getShips())) {
			gameOver = true;
		}
		return gameOver;
	}
	
	public ArrayList<Integer> allNumbersOfDestroyedShips() {
		ArrayList<Integer> destroyedNumbers = new ArrayList<Integer>();
		for (Ship s : this.getAllDestroyedShips()) {
			destroyedNumbers.addAll(s.getShipNumbers());
		}
		return destroyedNumbers;
	}
	
	public void addHitToShip(int number, Ship ship) {
		if (ship == null) {
			throw new DomainException("Ship was not found!");
		}
		ship.addNumberHit(number);
	}
	
	public ArrayList<Ship> getShips() {
		return ships;
	}
	
	public int getNoOfShips() {
		return this.getShips().size();
	}
	
	public List<Integer> getAllShipNumbers() {
		List<Integer> shipNumbers = new ArrayList<Integer>();
		for (Ship ship : ships) {
			shipNumbers.addAll(ship.getShipNumbers());
		}
		return shipNumbers;
	}
	
	public void addShip(Ship ship) {
		if (maxNoOfShips()) {
			throw new DomainException("You cannot place more than 5 ships!");
		}
		if (!this.maxNoOfAllowedShips(ship)) {
			throw new DomainException("You cannot place more ships of this type!");
		}
		if (!this.overlapShips(ship)) {
			throw new DomainException("This ship is placed too close to another ship!");
		}
		this.ships.add(ship);
	}
	
	public void addShip(ShipType shipType, Direction direction, int startBox) {
		Ship ship = new Ship(shipType, direction, startBox);
		this.addShip(ship);
	}

	public Ship getlastAddedShip() {
		return ships.get(ships.size() - 1);
	}
	
	private boolean maxNoOfShips() {
		return ships.size() == MAX_SHIPS;
	}

	private boolean maxNoOfAllowedShips(Ship ship) {
		int number = 0;
		for (Ship s : this.getShips()) {
			if (s.getShipType().equals(ship.getShipType())) {
				number++;
			}
		}
		// true if ship may add
		return ship.getShipType().getNoOfAllowedShips() > number;
	}

	private boolean overlapShips(Ship ship) {
		for (Ship s : this.getShips()) {
			for (Integer i : ship.getShipNumbers()) {
				if (s.getNumbersAroundShip().contains(i) || s.getShipNumbers().contains(i)) {
					return false;
				}
			}
		}
		return true;
	}
	
}
