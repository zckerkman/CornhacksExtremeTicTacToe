package com.hotmail.zckerkman;

import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * Creates the GUI for a board.
 * 
 * @author AntonioSSD
 */
public class BoardGUI extends JPanel{
	/**
	 * The board's ID.
	 */
	private int boardID;
	/**
	 * The total number of boards created.
	 */
	private static int boardCount = 0;
	
	/**
	 * An array of Strings representing the states of the tiles.
	 */
	private String[] boardValues;
	
	/**
	 * An array of the board's tiles.
	 */
	public Tile[] tiles = new Tile[9];
	
	public BoardGUI(String[] boardValues){
		this.boardID = boardCount++;
		this.boardValues = boardValues;
	}
	
	/**
	 * Converts the board values to tiles.
	 * 
	 * @return the board panel
	 */
	public JPanel iterateThroughBoardValues() {
		// Creates one board as a panel.
		this.setLayout(new GridLayout(3, 3));
		for(int i = 0; i < boardValues.length; i++) {
			Tile tilePanel = new Tile(boardValues[i]);
			tiles[i] = tilePanel;
			this.add(tilePanel);
		}
		return this;
	}

	/**
	 * Gets a board's ID.
	 * 
	 * @return a board's ID
	 */
	public int getBoardID() {
		return boardID;
	}
}