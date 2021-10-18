package com.game.battleship.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.game.battleship.exceptions.DomainException;
import com.game.battleship.strategy.HardPlaceShipStrategy;
import com.game.battleship.strategy.PlaceShipStrategy;
import com.game.battleship.strategy.RandomPlaceShipStrategy;

public class PlaceShipFactory {
	public PlaceShipStrategy getPlaceShipStrategy() {
		Properties properties = new Properties();
		InputStream input;
		try {
			input = new FileInputStream(new File("src/main/java/StrategyProperties.properties"));
			properties.load(input);
		} catch (IOException e) {
			throw new DomainException("Properties file not found (PlaceShipFactory)");
		}

		String className = (String) properties.get("placeShipStrategy");

		try {
			Class<?> clazz = Class.forName(className);
			return (PlaceShipStrategy) clazz.newInstance();
			//return new HardPlaceShipStrategy();
		} catch (Exception e) {
			throw new DomainException("Strategy not found PlaceShipStrategy");
		}

	}
}
