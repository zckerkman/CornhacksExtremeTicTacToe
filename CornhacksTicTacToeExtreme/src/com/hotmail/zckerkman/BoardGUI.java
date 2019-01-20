package com.hotmail.zckerkman;

import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class BoardGUI extends JPanel{
	/**
	 * Used to serialize the Board GUI class. (Recommended to use default Java serialization without transiency)
	 */
	private static final long serialVersionUID = 123212321L;
	/**
	 * The id of a tile.
	 */
	private int boardID;
	/**
	 * The static count of the tile to set an id.
	 */
	private static int boardCount = 0;
	
	/**
	 * An array of length 9 to store the values for one normal tic tac toe board.
	 */
	private String[] boardValues;
	
	public Tile[] tiles = new Tile[9];
	
	/**
	 * BoardGUI constructor.
	 */
	public BoardGUI(String[] boardValues){
		this.boardID = boardCount++;
		this.boardValues = boardValues;
	}
	
	/**
	 * Iterates through the board values and creates a panel with 9 tile panels on it.
	 * @return the board panel
	 */
	public JPanel iterateThroughBoardValues() {
		JPanel board = new JPanel();
		board.setLayout(new GridLayout(3, 3));
		for(int i = 0; i < boardValues.length; i++) {
			Tile tilePanel = new Tile(boardValues[i]);
			tiles[i] = tilePanel;
			board.add(tilePanel);
		}
		return board;
	}
	
	/**
	 * Gets the board count.
	 * @return boardCount
	 */
	public static int getBoardCount() {
		return boardCount;
	}
	
	/**
	 * Set the board count.
	 * @param boardCount
	 */
	public static void setBoardCount(int boardCount) {
		BoardGUI.boardCount = boardCount;
	}

	public int getBoardID() {
		return boardID;
	}
	
}
