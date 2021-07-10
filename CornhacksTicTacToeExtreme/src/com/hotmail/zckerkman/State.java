package com.hotmail.zckerkman;

/**
 * An enumerated list of possible tile states.
 * 
 * @author LukeAVanDrie, ZCKerkman
 */
public enum State {
	X, O, EMPTY;
	
	/**
	 * Converts the states to their String representations.
	 * 
	 * @param s the desired state
	 * @return a String representing the state
	 */
	public static String convertToString(State s) {
		if (s.equals(X)) {
			return "X";
		} else if (s.equals(O)) {
			return "O";
		} else {
			return "";
		}
	}
}