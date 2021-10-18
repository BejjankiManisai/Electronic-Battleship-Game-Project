package com.game.battleship.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameBoardJPanel extends JPanel {
	private List<Square> squares = new ArrayList<Square>();

	public GameBoardJPanel(int silk, int number) {
		int y = 0;
		int x = 0;
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				squares.add(new Square(x + silk * i, y + silk * j, silk, Color.cyan));
			}
		}

	}

	public void addMouseClickListener(MouseListener listener) {
		this.addMouseListener(listener);
	}

	public List<Square> getSquares() {
		return squares;
	}

	public void setColor(int nr, Color color) {
		squares.get(nr).setBorderColor(color);
		squares.get(nr).setColor(color);
		this.repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		for (Square square : squares) {
			square.paint(g);
		}
	}
}
