package com.hotmail.zckerkman;

public class MasterBoard extends Board{
	
	private Board[] boards = new Board[9];
	
	public MasterBoard() {
		super();
	}
	
	public Board getBoard(int i) {
		return boards[i];
	}
	
	public void setBoard(int i, Board board) {
		boards[i] = board; 
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
