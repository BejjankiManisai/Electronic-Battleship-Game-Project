package com.game.battleship.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.game.battleship.strategy.HitStrategy;
import com.game.battleship.strategy.PlaceStrategy;

public class SettingsJFrame extends JFrame {

	private JButton confirmButton;

	private JComboBox<HitStrategy> hitComboBox;
	private JComboBox<PlaceStrategy> placeComboBox;
	private JComboBox<String> shipsVisibleBox;

	private JLabel hitLabel;
	private JLabel placeLabel;
	private JLabel shipsVisibleLabel;

	private boolean shipsvisible = false;

	public final static int HEIGHT_FRAME = 500;
	public final static int WIDTH_FRAME = 500;

	public SettingsJFrame() {
		super();
		this.launch();
	}

	public void launch() {
		this.DefaultValuesToProperties();
		this.setSize(WIDTH_FRAME, HEIGHT_FRAME);
		this.setResizable(false);
		this.setLayout(null);
		this.setTitle("Settings");

		this.completeLabelHitStrategy();
		this.completeBoxHitStrategy();
		this.completeConfirmButton();

		this.completeBoxPlaceStrategy();
		this.completeLabelPlaceStrategy();

		this.completeShipsVisibleLabel();
		this.completeShipsVisibleBox();

		this.addActionListenerToHitComboBox();
		this.addActionListenerToPlaceCombobox();
		this.addActionListenerToVisibilityComboBox();
		this.addActionListenerTopConfirmButton();
	}

	private void completeConfirmButton() {
		this.confirmButton = new JButton("Confirm");
		this.confirmButton.setLocation(25, 400);
		this.confirmButton.setSize(new Dimension(450, 40));
		this.add(confirmButton);
	}

	private void completeBoxHitStrategy() {
		this.hitComboBox = new JComboBox<HitStrategy>(HitStrategy.values());
		this.hitComboBox.setLocation(25, 120);
		this.hitComboBox.setSize(new Dimension(450, 40));
		this.add(hitComboBox);
	}

	private void completeLabelHitStrategy() {
		this.hitLabel = new JLabel("Choose a shooting strategy:");
		this.hitLabel.setLocation(25, 75);
		this.hitLabel.setSize(new Dimension(450, 40));
		this.add(hitLabel);
	}

	private void addActionListenerToHitComboBox() {
		this.hitComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//writeHitToProperties(((HitStrategy) hitComboBox.getSelectedItem()).getFullClassName());
			}
		});
	}

	private void completeBoxPlaceStrategy() {
		this.placeComboBox = new JComboBox<PlaceStrategy>(PlaceStrategy.values());
		this.placeComboBox.setLocation(25, 200);
		this.placeComboBox.setSize(new Dimension(450, 40));
		this.add(placeComboBox);
	}

	private void completeLabelPlaceStrategy() {
		this.placeLabel = new JLabel("Choose a place ships strategy:");
		this.placeLabel.setLocation(25, 160);
		this.placeLabel.setSize(new Dimension(450, 40));
		this.add(placeLabel);
	}

	private void addActionListenerToPlaceCombobox() {
		this.placeComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//writePlaceToProperties(((PlaceStrategy) placeComboBox.getSelectedItem()).getFullClassName());
			}
		});
	}

	private void addActionListenerTopConfirmButton() {
		this.confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}

	private void completeShipsVisibleLabel() {
		this.shipsVisibleLabel = new JLabel("Should the computer ships be visible?:");
		this.shipsVisibleLabel.setLocation(25, 250);
		this.shipsVisibleLabel.setSize(new Dimension(450, 40));
		this.add(shipsVisibleLabel);
	}

	private void completeShipsVisibleBox() {
		String[] opportunities = { "NO", "YES" };
		this.shipsVisibleBox = new JComboBox<String>(opportunities);
		this.shipsVisibleBox.setLocation(25, 290);
		this.shipsVisibleBox.setSize(new Dimension(450, 40));
		this.add(shipsVisibleBox);
	}

	private void addActionListenerToVisibilityComboBox() {
		this.shipsVisibleBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selected = (String) shipsVisibleBox.getSelectedItem();
				if (selected.equals("YES")) {
					shipsvisible = true;
				} else {
					shipsvisible = false;
				}
			}
		});
	}

	public boolean getShipsVisible() {
		return this.shipsvisible;
	}

	private void DefaultValuesToProperties() {
		this.writeHitToProperties(HitStrategy.RANDOM.getFullClassName());
		this.writePlaceToProperties(PlaceStrategy.RANDOM.getFullClassName());
	}

	public void writeHitToProperties(String hitStrategy) {
		FileInputStream in = null;
		try {
			in = new FileInputStream("src/main/java/StrategyProperties.properties");
		} catch (FileNotFoundException e) {
			System.out.println("Properties not found! (Settings)");
		}
		Properties props = new Properties();
		try {
			props.load(in);
			in.close();
		} catch (IOException e) {
			System.out.println("Could not load properties (Settings)");
		}

		FileOutputStream out = null;
		try {
			out = new FileOutputStream("src/main/java/StrategyProperties.properties");
		} catch (FileNotFoundException e) {
			System.out.println("Properties not found! (Settings)");
		}
		props.setProperty("hitShipStrategy", hitStrategy);
		try {
			props.store(out, null);
			out.close();
		} catch (IOException e) {
			System.out.println("Could not save properties (Settings)");
		}

	}

	public void writePlaceToProperties(String placeShipStrategy) {
		FileInputStream in = null;
		try {
			in = new FileInputStream("src/main/java/StrategyProperties.properties");
		} catch (FileNotFoundException e) {
			System.out.println("Properties not found! (Settings)");
		}
		Properties props = new Properties();
		try {
			props.load(in);
			in.close();
		} catch (IOException e) {
			System.out.println("Could not load properties (Settings)");
		}

		FileOutputStream out = null;
		try {
			out = new FileOutputStream("src/main/java/StrategyProperties.properties");
		} catch (FileNotFoundException e) {
			System.out.println("Properties not found! (Settings)");
		}
		props.setProperty("placeShipStrategy", placeShipStrategy);
		try {
			props.store(out, null);
			out.close();
		} catch (IOException e) {
			System.out.println("Could not save properties (Settings)");
		}
	}

}
