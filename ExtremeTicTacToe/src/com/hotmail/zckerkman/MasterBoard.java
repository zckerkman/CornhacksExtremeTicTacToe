package com.hotmail.zckerkman;

public class MasterBoard extends Board{
	
	private Board[] boards = new Board[9];
	
	public MasterBoard() {
		super();
	}
	
	public State getBoardValues(int i, int j) {
		return boards[i].getBoardState(j);
	}
	
	public void setBoardValues(int i, int j, State s) {
		boards[i].setBoardState(j, s);
	}
	
	public void makeBoards() {
		for(int i = 0; i < boards.length; i++) {
			boards[i] = new Board();
		}
	}
	
	@Override
	public boolean checkValues (State s, int value, int i, int increment) {
		int testVal = 0;
		for(int j = i; j <= increment*2 + i ; j+=increment) {
			testVal += boards[j].getWinner().ordinal();
		}
		if(testVal == value) {
			winner = s;
			return true;
		}
		return false;
	}
}
