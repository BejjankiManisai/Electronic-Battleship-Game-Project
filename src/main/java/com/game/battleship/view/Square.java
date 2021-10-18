package com.game.battleship.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Square {
	private int x, y, silk;
	private Color color;
	public boolean busy;
	private Color borderColor;
	
	public Square(int x, int y, int silk, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.silk = silk;
		this.color = color;
		busy = false;
		borderColor = Color.BLACK;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setBusy() {
		this.busy = true;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public Color getColor() {
		return color;
	}

	public boolean getBusy() {
		return busy;
	}
	
	public boolean isClicked(int x, int y) {
		boolean isClicked = this.x <= x && this.x + silk >= x && this.y <= y && this.y + silk >= y;
		return isClicked;
	}
	
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, silk, silk);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g.setColor(borderColor);
		g.drawRect(x, y, silk, silk);
	}
	
}
