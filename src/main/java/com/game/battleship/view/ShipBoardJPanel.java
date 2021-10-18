package com.game.battleship.view;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

import com.game.battleship.model.Direction;
import com.game.battleship.model.ShipType;

@SuppressWarnings("serial")
public class ShipBoardJPanel extends JPanel {

	private JLabel projectLabel;
	private JLabel shipsLabel;
	private JComboBox<Object> possibleShipsBox;
	private JLabel directionLabel;
	private JRadioButton verticalButton;
	private JRadioButton horizontalButton;
	private ButtonGroup group;

	public ShipType selectedShipType = ShipType.CARRIER;
	public Direction selectedDirection = Direction.VERTICAL;

	public ShipBoardJPanel() {
		this.projectLabel = new JLabel("Electronic Battle Ship Game");
		this.shipsLabel = new JLabel("Available ships: ");
		List<ShipType> listSchiptypes = ShipType.getAllShipTypes();
		this.possibleShipsBox = new JComboBox<Object>(listSchiptypes.toArray());
		this.directionLabel = new JLabel("Direction:");
		this.verticalButton = new JRadioButton("Vertical", true);
		this.horizontalButton = new JRadioButton("Horizontal");

		this.group = new ButtonGroup();
		this.group.add(horizontalButton);
		this.group.add(verticalButton);

		possibleShipsBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedShipType = (ShipType) possibleShipsBox.getSelectedItem();
			}
		});

		verticalButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedDirection = Direction.VERTICAL;
			}
		});

		horizontalButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedDirection = Direction.HORIZONTAL;
			}
		});

		
		this.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		c.gridx = 0;
		c.gridy = 0;
		this.add(projectLabel);

		c.gridx = 0;
		c.gridy = 1;
		this.add(shipsLabel, c);

		c.gridx = 0;
		c.gridy = 2;

		this.add(possibleShipsBox, c);

		c.gridx = 0;
		c.gridy = 3;
		this.add(this.directionLabel, c);

		c.gridy = 4;
		this.add(horizontalButton, c);
		c.gridx = 2;
		c.gridy = 4;
		this.add(verticalButton, c);

	}

	public ShipType getSelectedShipType() {
		return selectedShipType;
	}

	public Direction getSelectedDirection() {
		return selectedDirection;
	}

	

}
