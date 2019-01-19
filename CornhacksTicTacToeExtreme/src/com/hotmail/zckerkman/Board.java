package com.hotmail.zckerkman;

public class Board {
		
	protected State[] boxes = new State[9];
	
	protected State winner = State.EMPTY;
	
	public Board() {
		for(int i = 0; i < boxes.length; i++) {
			boxes[i] = State.EMPTY;
		}
	}
	
	public State getBoardState(int i) {
		return boxes[i];
	}
	
	public void setBoardState(int i, State s) {
		boxes[i] = s;
	}
	
	public State getWinner() {
		return winner;
	}
	
	public void setWinner(State s) {
		winner = s;
	}
	
	public void checkForWinner() {
		checkForWinner(State.X);
		checkForWinner(State.O);
	}
	
	protected void checkForWinner(State s) {
		int value = s.ordinal() * 3;
		for(int i = 0; i < 8; i+=3) {
			if(checkValues(s, value, i, 1)) {
				return;
			}
		}
		for(int i = 0; i < 3; i+=1) {
			if(checkValues(s, value, i, 3)) {
				return;
			}
		}
		if (checkValues(s, value, 0, 4)) {
			return;
		}
		if (checkValues(s, value, 2, 2)) {
			return;
		}
	}
	
	protected boolean checkValues (State s, int value, int i, int increment) {
		int testVal = 0;
		for(int j = i; j <= increment*2 + i ; j+=increment) {
			testVal += boxes[j].ordinal();
		}
		if(testVal == value) {
			winner = s;
			return true;
		}
		return false;
	}
}
