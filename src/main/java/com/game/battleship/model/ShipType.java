package com.game.battleship.model;

import java.util.ArrayList;

public enum ShipType {
	
	CARRIER (5, 1),
	BATTLESHIP (4, 1),
	DESTROYER(3,1),
	SUBMARINE(3,1),
	PTBOAT(2,1),
	CRUISER(1,1);
	
	private final int shipGridSize;
	private final int noOfAllowedShips;
	
	private ShipType(int shipGridSize, int noOfAllowedShips) {
		this.shipGridSize = shipGridSize;
		this.noOfAllowedShips = noOfAllowedShips;
	}

	public int getShipGridSize() {
		return shipGridSize;
	}
	
	public int getNoOfAllowedShips() {
		return noOfAllowedShips;
	}

	public static ArrayList<ShipType> getAllShipTypes(){
		ArrayList<ShipType> allShipTypes = new ArrayList<ShipType>();
		for(ShipType shipType : ShipType.values()) {
			allShipTypes.add(shipType);
		}
		return allShipTypes;
	}
}
