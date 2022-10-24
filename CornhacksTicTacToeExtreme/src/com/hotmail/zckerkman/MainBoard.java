package com.hotmail.zckerkman;

/**
 * Models the main board.
 * 
 * @author LukeAVanDrie, ZCKerkman
 */
public class MainBoard extends Board {

	/**
	 * An array of all boards in the main board.
	 */
	private Board[] boards = new Board[9];

	public MainBoard() {
		// Adds boards to main board.
		for (int i = 0; i < boards.length; i++) {
			boards[i] = new Board();
		}
	}

	/**
	 * Gets all boards from the main board.
	 * 
	 * @return all boards in the main board
	 */
	public Board[] getBoards() {
		return boards;
	}

	/**
	 * Sets the state of a tile on a given particular board.
	 * 
	 * @param the board ID
	 * @param the tile ID
	 * @param the desired state
	 */
	public void setBoardValues(int i, int j, State s) {
		boards[i].setBoardState(j, s);
	}

	/**
	 * Gets a board by its ID.
	 * 
	 * @param id the board's ID
	 * @return a board
	 */
	public Board getBoard(int id) {
		return boards[id];
	}

	@Override
	/**
	 * Checks the values for the main board win condition.
	 */
	public boolean checkValues(State s, int value, int i, int increment) {
		int calculatedVal = 0;
		
		// Iterates through each cell of a desired row/column.
		for (int j = i; j <= increment * 2 + i; j += increment) {
			calculatedVal += (int) Math.pow(boards[j].getWinner().ordinal(), 2);
		}
		
		// If the calculated value equals the desired value, the board has been won.
		if (calculatedVal == value) {
			winner = s;
			return true;
		}
		
		return false;
	}
}