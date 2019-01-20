package com.hotmail.zckerkman;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MasterBoardGUI {
	
	/**
	 * An array of length 9 to store the values for one normal tic tac toe board.
	 */
	private String[][] nestedBoardValues;
	
	public BoardGUI[] boards = new BoardGUI[9];
	
	public MasterBoardGUI(String[][] nestedBoardValues) {
		this.nestedBoardValues = nestedBoardValues;
	}
	/**
	 * Iterates through the board values and creates a panel with 9 tile panels on it.
	 * @return the board panel
	 */
	public JPanel iterateThroughBoardValues() {
		JPanel masterBoard = new JPanel();
		masterBoard.setLayout(new GridLayout(3, 3));
		
		for(int i = 0; i < nestedBoardValues.length; i++) {
			BoardGUI singleBoard = new BoardGUI(nestedBoardValues[i]);
			// Adds boards to a list
			boards[i] = singleBoard;
			
			JPanel tileBoard = singleBoard.iterateThroughBoardValues();
			tileBoard.setBorder(BorderFactory.createLineBorder(Color.BLACK, 7));
			masterBoard.add(tileBoard);
		}
		return masterBoard;
	}
}
