package com.hotmail.zckerkman;

import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class BoardGUI extends JPanel{
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
	
	/**
	 * BoardGUI constructor.
	 */
	public BoardGUI(String[] boardValues){
		this.boardID = boardCount++;
		this.boardValues = boardValues;
	}
	
	public JPanel createPanel(String value) {
		JPanel tilePanel = new Tile(value).getPanel();
		
		return tilePanel;
	}
	
	/**
	 * Iterates through the board values and creates a panel with 9 tile panels on it.
	 * @return the board panel
	 */
	public JPanel iterateThroughBoardValues() {
		JPanel board = new JPanel();
		board.setLayout(new GridLayout(3, 3));
		for(String value: boardValues) {
			JPanel tilePanel = createPanel(value);
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
