package com.game.battleship.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {

	private GameBoardJPanel panel1;
	private GameBoardJPanel panel2;
	private JPanel namePanel1 = new JPanel();
	private JPanel namePanel2 = new JPanel();
	private ShipBoardJPanel shipBoardJPanel;
	private JButton startButton;

	private JButton settingsButton;

	private JLabel name1Label;
	private JLabel name2Label;

	public final static int HEIGHT_FRAME = 500; // At least 400
	public final static int WIDTH_FRAME = (int) (HEIGHT_FRAME * 2.5);
	public final static int PANEL_SIZE = (int) (HEIGHT_FRAME * 4 / 5);
	public final static int NUMBER_ROWS = 10;
	public boolean tryToStart = false;

	public GameFrame() {
		super();
	}

	public void launch(String naam) {
		this.setSize(WIDTH_FRAME, HEIGHT_FRAME);
		this.setResizable(false);
		this.setLayout(null);
		this.setTitle("BattleShip Electronic Game");

		this.completeSettingsShipBordJPanel();

		this.completeSettingsNamePanel1(naam);
		this.completeSettingsNamePanel2();

		this.completeSettingsSpelBordPanel1();
		this.completeSettingsSpelBordPanel2();

		this.setStartButton();
		this.setInstellingenButton();
	}

	private void setInstellingenButton() {
		this.settingsButton = new JButton("Settings");
		this.settingsButton.setLocation(25, PANEL_SIZE - 10);
		this.settingsButton.setSize(new Dimension(350, 40));
		this.add(this.settingsButton);
	}

	private void setStartButton() {
		this.startButton = new JButton("Start");
		this.startButton.setLocation(25, PANEL_SIZE - 50);
		this.startButton.setSize(new Dimension(350, 40));
		this.add(startButton);

	}

	public void addMouseClickListenerToStartButton(MouseListener listener) {
		this.startButton.addMouseListener(listener);
	}

	public void addMouseClickListenerToInstellingenButton(MouseListener listener) {
		this.settingsButton.addMouseListener(listener);
	}

	private void completeSettingsShipBordJPanel() {
		this.shipBoardJPanel = new ShipBoardJPanel();
		this.shipBoardJPanel.setSize(new Dimension(PANEL_SIZE - 25, PANEL_SIZE / 2));
		this.shipBoardJPanel.setLocation(25, 50);
		this.add(shipBoardJPanel);
	}

	private void completeSettingsSpelBordPanel1() {
		panel1 = new GameBoardJPanel((PANEL_SIZE / NUMBER_ROWS), NUMBER_ROWS);
		panel1.setBackground(Color.GRAY);
		panel1.setSize(new Dimension(PANEL_SIZE, PANEL_SIZE));
		panel1.setLocation(PANEL_SIZE, 50);
		panel1.setBorder(BorderFactory.createLoweredBevelBorder());
		this.add(panel1);
	}


	private void completeSettingsSpelBordPanel2() {
		panel2 = new GameBoardJPanel((PANEL_SIZE / NUMBER_ROWS), NUMBER_ROWS);
		panel2.setBackground(Color.GRAY);
		panel2.setSize(new Dimension(PANEL_SIZE, PANEL_SIZE));
		panel2.setLocation(2 * PANEL_SIZE + 25, 50);
		panel2.setBorder(BorderFactory.createLoweredBevelBorder());
		this.add(panel2);
	}


	public GameBoardJPanel getGameBoardJPanel1() {
		return panel1;
	}


	public GameBoardJPanel getGameBoardJPanel2() {
		return panel2;
	}


	public ShipBoardJPanel getShipBordJPanel() {
		return shipBoardJPanel;
	}


	public void completeSettingsNamePanel1(String naam) {
		String name = naam;
		if (naam == null || naam.isEmpty()) {
			name = "Player1";
		}
		this.name1Label = new JLabel(name + ":", SwingConstants.LEFT);
		namePanel1.add(name1Label);
		namePanel1.setSize(new Dimension(100, 25));
		namePanel1.setLocation(PANEL_SIZE, 25);
		this.add(namePanel1);
	}

	public void updateNameFieldHuman(String n) {
		this.name1Label.setText(n);
	}

	public void updateNameFieldComputer(String n) {
		this.name2Label.setText(n);
	}

	public void completeSettingsNamePanel2() {
		this.name2Label = new JLabel("Computer:");
		namePanel2.add(name2Label);
		namePanel2.setSize(new Dimension(100, 25));
		namePanel2.setLocation(2 * PANEL_SIZE + 25, 25);

		this.add(namePanel2);
	}

	public void disableStartButton() {
		this.startButton.setEnabled(false);
	}

	public void disableSettingsButton() {
		this.settingsButton.setEnabled(false);
	}

	public boolean isStartButtonEnabled() {
		return this.startButton.isEnabled();
	}

	public boolean isSettingsButtonEnabled() {
		return this.settingsButton.isEnabled();
	}

	public void disableGameBoardJPanel1() {
		this.getGameBoardJPanel1().setEnabled(false);
	}

	public boolean isGameBoardJPanel1Enabled() {
		return this.getGameBoardJPanel2().isEnabled();
	}

	public void closeApplication() {
		setVisible(false);
		dispose();
	}

}
