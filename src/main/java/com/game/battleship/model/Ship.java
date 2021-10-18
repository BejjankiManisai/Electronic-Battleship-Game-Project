package com.game.battleship.model;

import java.util.ArrayList;
import java.util.List;

import com.game.battleship.exceptions.DomainException;
import com.game.battleship.exceptions.ShipPlacementException;

public class Ship {
	
	private Direction direction;
	private ShipType shipType;
	private List<Integer> shipNumbers = new ArrayList<Integer>();
	private List<Integer> hitShipNumbers = new ArrayList<Integer>();
	
	public Ship(ShipType shipType, Direction direction, int startBox) {
		this.setShipType(shipType);
		this.setDirection(direction);
		this.placeShipNumber(startBox);
	}
	
	private void placeShipNumber(int startBox) {
		if(this.getDirection().equals(Direction.HORIZONTAL)) {
			int endBox = startBox + (10 * (shipType.getShipGridSize() - 1));
			if(endBox < 100) {
				for(int i=startBox ; i<=endBox; i+=10) {
					shipNumbers.add(i);
				}
			}else {
				throw new ShipPlacementException("Ship cannot be placed horizontally like this!");
			}
		} else {
			int endBox = startBox + shipType.getShipGridSize() - 1;
			if((endBox % 10) > (startBox % 10)) {
				for(int i=startBox; i<=endBox; i++) {
					shipNumbers.add(i);
				}
			}else {
				throw new ShipPlacementException("Ship cannot be placed vertically like this!");
			}
		}
	}
	
	public ArrayList<Integer> getNumbersAroundShip() {
		ArrayList<Integer> numbersAround = new ArrayList<Integer>();
		
		int firstNumber = this.getShipNumbers().get(0);
		int lastNumber = this.getShipNumbers().get(this.getShipNumbers().size()-1);
		
		if (this.getDirection().equals(Direction.HORIZONTAL)) {
			for (Integer integer : this.getShipNumbers()) {
				if (integer == firstNumber) {
					if ((integer % 10) != 0) {
						numbersAround.add(integer - 1);
					}
					if ((integer % 10) != 9) {
						numbersAround.add(integer + 1);
					}
					if (integer - 10 > 0) {
						numbersAround.add(integer - 10);
					}
					if ((integer - 10) > 0 && (integer % 10) != 0) {
						numbersAround.add(integer - 11);
					}
					if ((integer - 10) > 0 && (integer % 10) != 9) {
						numbersAround.add(integer - 9);
					}
				} else if (integer == lastNumber) {
					if ((integer + 10) < 100) {
						numbersAround.add(integer + 10);
					}
					if ((integer % 10) != 0) {
						numbersAround.add(integer - 1);
					}
					if ((integer % 10) != 9) {
						numbersAround.add(integer + 1);
					}
					if ((integer + 10) < 100 && (integer % 10) != 0) {
						numbersAround.add(integer + 9);
					}
					if ((integer + 10) < 100 && (integer % 10) != 9) {
						numbersAround.add(integer + 11);
					}
				} else {
					if ((integer % 10) != 0) {
						numbersAround.add(integer - 1);
					}
					if ((integer % 10) != 9) {
						numbersAround.add(integer + 1);
					}
				}
			}
		} else {
			for (Integer integer : this.getShipNumbers()) {
				if (integer == firstNumber) {
					if ((integer % 10) != 0) {
						numbersAround.add(integer - 1);
					}
					if ((integer + 10) < 100) {
						numbersAround.add(integer + 10);
					}
					if ((integer - 10) > 0) {
						numbersAround.add(integer - 10);
					}
					if ((integer % 10) != 0 && (integer - 10) > 0) {
						numbersAround.add(integer - 11);
					}
					if ((integer % 10) != 0 && (integer + 10) < 100) {
						numbersAround.add(integer + 9);
					}

				} else if (integer == lastNumber) {
					if ((integer + 10) < 100) {
						numbersAround.add(integer + 10);
					}
					if ((integer - 10) > 0) {
						numbersAround.add(integer - 10);
					}
					if ((integer % 10) != 9) {
						numbersAround.add(integer + 1);
					}
					if ((integer % 10) != 9 && (integer - 10) > 0) {
						numbersAround.add(integer - 9);
					}
					if ((integer % 10) != 9 && (integer + 10) < 100) {
						numbersAround.add(integer + 11);
					}
				} else {
					if ((integer + 10) < 100) {
						numbersAround.add(integer + 10);
					}
					if ((integer - 10) > 0) {
						numbersAround.add(integer - 10);
					}
				}
			}
		}
		return numbersAround;
	}
	
	public void addNumberHit(int number) {
		if(!this.getShipNumbers().contains(number)) {
			throw new DomainException("Can't hit because is not a ship number (Ship class)");
		}
		this.getHitShipNumbers().add(number);
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public ShipType getShipType() {
		return shipType;
	}

	public void setShipType(ShipType shipType) {
		this.shipType = shipType;
	}

	public List<Integer> getShipNumbers() {
		return shipNumbers;
	}

	public List<Integer> getHitShipNumbers() {
		return hitShipNumbers;
	}
	
	

}
