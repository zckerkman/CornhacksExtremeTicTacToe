package com.hotmail.zckerkman;

/**
 * Models a board.
 * 
 * @author LukeAVanDrie, ZCKerkman
 */
public class Board {

	/**
	 * An array of the tiles on the board.
	 */
	protected State[] tiles = new State[9];
	/**
	 * The current winning state of the board.
	 */
	protected State winner = State.EMPTY;
	
	public Board() {
		/**
		 * Adds the tiles to the board.
		 */
		for(int i = 0; i < tiles.length; i++) {
			tiles[i] = State.EMPTY;
		}
	}
	
	/**
	 * Gets the states of tiles from a board.
	 * 
	 * @return the board's tile's states
	 */
	public State[] getTileStates() {
		return tiles;
	}
	
	/**
	 * Sets the winning state of a board.
	 * 
	 * @param the board ID
	 * @param the desired state
	 */
	public void setBoardState(int i, State s) {
		tiles[i] = s;
	}
	
	/**
	 * Gets the winning state of the board.
	 * 
	 * @return the winning state of the board
	 */
	public State getWinner() {
		return winner;
	}
	
	/**
	 * Checks if a user has won a board.
	 * 
	 * @param the state of the user being checked
	 */
	protected void checkForWinner(State s) {
		// Determines winning values for each state.
		int value = (int) Math.pow(s.ordinal(), 2) * 3;
		
		// Checks for horizontal win condition.
		for(int i = 0; i <= 8; i+=3) {
			if(checkValues(s, value, i, 1)) {
				return;
			}
		}
		
		// Checks for vertical win condition.
		for(int i = 0; i <= 2; i+=1) {
			if(checkValues(s, value, i, 3)) {
				return;
			}
		}
		
		//Checks diagonal win conditions.
		if (checkValues(s, value, 0, 4)) {
			return;
		}
		if (checkValues(s, value, 2, 2)) {
			return;
		}
	}
	
	/**
	 * Checks the values for the main board win condition.
	 */
	protected boolean checkValues (State s, int value, int i, int increment) {
		int calculatedVal = 0;
		
		// Iterates through each cell of a desired row/column.
		for(int j = i; j <= increment*2 + i ; j+=increment) {
			calculatedVal += (int) Math.pow(tiles[j].ordinal(), 2);
		}
		
		// If the calculated value equals the desired value, the board has been won.
		if(calculatedVal == value) {
			winner = s;
			return true;
		}
		return false;
	}
}