package com.hotmail.zckerkman;

public enum State {
	X, O, EMPTY;
	
	public String convertToString(State s) {
		if (s.equals(X)) {
			return "X";
		} else if (s.equals(O)) {
			return "O";
		} else {
			return "";
		}
	}
}
