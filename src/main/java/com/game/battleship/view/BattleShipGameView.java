package com.game.battleship.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.game.battleship.model.Direction;
import com.game.battleship.model.ShipType;

public class BattleShipGameView {
	private GameFrame gameFrame;
	private SettingsJFrame settingsJFrame;
	private String playerName;

	public BattleShipGameView() {
		gameFrame = new GameFrame();
		gameFrame.launch(this.askPlayerName());
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
	}

	public String askPlayerName() {
		playerName = JOptionPane.showInputDialog("***Right now, sea is empty.***\n \nPlease enter player Name.");

		return playerName;
	}

	public void openSettingsJFrame() {
		settingsJFrame = new SettingsJFrame();
		settingsJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		settingsJFrame.setVisible(true);
	}

	public String getPlayerName() {
		return playerName;
	}

	public GameBoardJPanel getGameBoardPanel1() {
		return this.getGameFrame().getGameBoardJPanel1();
	}

	public GameBoardJPanel getGameBoardPanel2() {
		return this.getGameFrame().getGameBoardJPanel2();
	}

	public int getGameBoard1Size() {
		return this.getGameBoardPanel1().getSquares().size();
	}

	public int getGameBoard2Size() {
		return this.getGameBoardPanel2().getSquares().size();
	}

	public boolean isClickedInGameboard2(int i, int x, int y) {
		return this.getGameBoardPanel2().getSquares().get(i).isClicked(x, y);
	}

	public boolean isClickedInGameboard1(int i, int x, int y) {
		return this.getGameBoardPanel1().getSquares().get(i).isClicked(x, y);
	}

	public void colorShipGameBoardPanel1(int nummer, Color kleur) {
		this.getGameBoardPanel1().setColor(nummer, kleur);
	}

	public void colorShipGameBoardPanel2(int nummer, Color kleur) {
		this.getGameBoardPanel2().setColor(nummer, kleur);
	}

	public boolean getSquareBusyGameBoardPanel1(int nummer) {
		return this.getGameBoardPanel1().getSquares().get(nummer).getBusy();
	}

	public boolean getSquareBusyGameBoardPanel2(int nummer) {
		return this.getGameBoardPanel2().getSquares().get(nummer).getBusy();
	}

	public void setSquareGameBoardPanel2Busy(int nummer) {
		this.getGameBoardPanel2().getSquares().get(nummer).setBusy();
	}

	public ShipType getSelectedShipType() {
		return this.getGameFrame().getShipBordJPanel().getSelectedShipType();
	}

	public Direction getSelectedDirection() {
		return this.getGameFrame().getShipBordJPanel().getSelectedDirection();
	}

	public GameFrame getGameFrame() {
		return gameFrame;
	}

	public void showError(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public void disableStartButton() {
		this.getGameFrame().disableStartButton();
	}

	public boolean isStartButtonEnabled() {
		return this.getGameFrame().isStartButtonEnabled();
	}

	public void disableSettingsButton() {
		this.getGameFrame().disableSettingsButton();
	}

	public boolean isSettingsButtonEnabled() {
		return this.getGameFrame().isSettingsButtonEnabled();
	}

	public void disableGameBoardJPanel1() {
		this.getGameFrame().disableGameBoardJPanel1();
	}

	public boolean isGameBoardJPanel1Enabled() {
		return this.getGameFrame().isGameBoardJPanel1Enabled();
	}

	public void updateNameFieldHuman(String n) {
		this.getGameFrame().updateNameFieldHuman(n);
	}

	public void updateNameFieldComputer(String n) {
		this.getGameFrame().updateNameFieldComputer(n);
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public void closeApplication() {
		this.getGameFrame().closeApplication();
	}

	public boolean mustShipsvisible() {
		return this.settingsJFrame.getShipsVisible();
	}

	public SettingsJFrame getSettingsFrame() {
		return this.settingsJFrame;
	}

}

