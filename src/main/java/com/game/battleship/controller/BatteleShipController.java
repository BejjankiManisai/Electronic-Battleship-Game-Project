package com.game.battleship.controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.game.battleship.exceptions.DomainException;
import com.game.battleship.model.BattleShipGameModel;
import com.game.battleship.view.BattleShipGameView;

public class BatteleShipController {
	private BattleShipGameModel model;
	private BattleShipGameView view;

	public BatteleShipController() {
		this.setUpGame();
	}

	public void setUpGame() {
		view = new BattleShipGameView();
		model = new BattleShipGameModel(view.getPlayerName());
		view.getGameBoardPanel1().addMouseClickListener(new MouseClickHandler());
		view.getGameFrame().addMouseClickListenerToStartButton(new StartButtonHandler());
		view.getGameFrame().addMouseClickListenerToInstellingenButton(new SettingsHandler());
	}

	private class SettingsHandler extends MouseAdapter {
		public void mouseClicked(MouseEvent event) {
			if (view.isSettingsButtonEnabled()) {
				view.disableSettingsButton();
				view.openSettingsJFrame();
			}
		}
	}

	private class StartButtonHandler extends MouseAdapter {
		public void mouseClicked(MouseEvent event) {
			if (view.isStartButtonEnabled()) {
				try {
					model.startGame();
					model.readHitStrategyFromProp();
					model.readPlacesShipStrategyFromProp();
					computerGenerateShips();
					if (view.getSettingsFrame() != null && view.mustShipsvisible()) {
						showGeneratedShips();
					}
					view.disableStartButton();
					view.disableGameBoardJPanel1();
					view.getGameBoardPanel2().addMouseClickListener(new ShootClickHandler());
					updateNameFieldComputer();
					updateNamefieldHuman();
					if (view.isSettingsButtonEnabled()) {
						view.disableSettingsButton();
					}
				} catch (Exception e) {
					view.showError(e.getMessage());
				}
			}
		}
	}

	private class ShootClickHandler extends MouseAdapter {

		ArrayList<Integer> shipsFiguresComputer = (ArrayList<Integer>) model.getAllComputerShipNummers();
		ArrayList<Integer> shipsFiguresHumanPlayer = (ArrayList<Integer>) model.getAllHumanPlayerShipNummers();

		public void mouseClicked(MouseEvent event) {
			int x = event.getX();
			int y = event.getY();
			int beginNummer = -1;

			for (int i = 0; i < view.getGameBoard2Size(); i++) {
				if (view.isClickedInGameboard2(i, x, y)) {
					beginNummer = i;
					if (!view.getSquareBusyGameBoardPanel2(beginNummer)) {
						view.setSquareGameBoardPanel2Busy(beginNummer);
						if (shipsFiguresComputer.contains(beginNummer)) {
							if (model.addHitNumberToComputerShip(beginNummer)) {
								for (Integer integer : model.allNumbersfDestroyedShipsOfComputer()) {
									view.colorShipGameBoardPanel2(integer, Color.RED);
								}
							} else {
								view.colorShipGameBoardPanel2(beginNummer, Color.YELLOW);
							}

						} else {
							view.colorShipGameBoardPanel2(beginNummer, Color.BLUE);
						}
						updateNamefieldHuman();
						if (model.getIfGameOverComputer()) {
							view.showMessage("Game over!\n" + model.getHumanPlayerName() + " won with "
									+ model.getHumanPlayerScore() + " points...");
							endGame();
						} else {
							this.computerShoots();
						}
						break;
					}
				}
			}

		}

		public void computerShoots() {
			int shot = model.getComputerShot();

			if (shipsFiguresHumanPlayer.contains(shot)) {
				if (model.addHitNumberToHumanPlayerShip(shot)) {
					for (Integer integer : model.allNumbersfDestroyedShipsOfHumanPlayer()) {
						view.colorShipGameBoardPanel1(integer, Color.RED);
					}
				} else {
					view.colorShipGameBoardPanel1(shot, Color.YELLOW);
				}
			} else {
				view.colorShipGameBoardPanel1(shot, Color.BLUE);
			}
			updateNameFieldComputer();
			if (model.getIfGameOverHumanPlayer()) {
				view.showMessage("Game over!\n" + model.getComputerPlayerName() + " won met "
						+ model.getComputerPlayerName() + " punten...");
				endGame();
			}
		}

	}

	public void updateNamefieldHuman() {
		view.updateNameFieldHuman(model.getHumanPlayerName() + " (" + model.getHumanPlayerScore() + "):");
	}

	public void updateNameFieldComputer() {
		view.updateNameFieldComputer(model.getComputerPlayerName() + " (" + model.getComputerPlayerScore() + "):");
	}

	public void endGame() {
		view.closeApplication();
		this.setUpGame();
	}

	private class MouseClickHandler extends MouseAdapter {
		public void mouseClicked(MouseEvent event) {
			if (view.isGameBoardJPanel1Enabled()) {

				int x = event.getX();
				int y = event.getY();
				int beginNummer = -1;
				for (int i = 0; i < view.getGameBoard1Size(); i++) {
					if (view.isClickedInGameboard1(i, x, y)) {
						beginNummer = i;
						try {
							model.addShipToHumanPlayer(view.getSelectedShipType(), view.getSelectedDirection(),
									beginNummer);
							for (Integer schipnummer : model.getLastAddedShipToHumanPlayer().getShipNumbers()) {
								view.colorShipGameBoardPanel1(schipnummer, Color.WHITE);
							}
						} catch (DomainException e) {
							view.showError(e.getMessage());
						}
						break;
					}
				}
			}
		}
	}

	private void computerGenerateShips() {
		model.computerGenerateShips();
	}

	private void showGeneratedShips() {
		for (Integer nummer : model.getAllComputerShipNummers()) {
			view.colorShipGameBoardPanel2(nummer, Color.WHITE);
		}
	}

}

