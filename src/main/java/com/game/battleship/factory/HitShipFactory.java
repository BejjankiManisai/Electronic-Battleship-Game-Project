package com.game.battleship.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.game.battleship.exceptions.DomainException;
import com.game.battleship.strategy.HardPlaceShipStrategy;
import com.game.battleship.strategy.HitShipStrategy;
import com.game.battleship.strategy.OrderedHitStrategy;
import com.game.battleship.strategy.RandomHitShipStrategy;

public class HitShipFactory {
	
	public HitShipStrategy getHitShipStrategy() {
		Properties properties = new Properties();
		InputStream input ;
		try {
			input = new FileInputStream(new File("src/main/java/StrategyProperties.properties"));
			properties.load(input);
		} catch (IOException e) {
			throw new DomainException("Properties file not found (HitShipFactory)");
		}

		String className = (String) properties.get("hitShipStrategy");

		try {
			Class<?> clazz = Class.forName(className);
			return (HitShipStrategy) clazz.newInstance();
			//return new OrderedHitStrategy();
		} catch (Exception e) {
			throw new DomainException("Strategy not found HitShipFactory)");
		}

	}
}
