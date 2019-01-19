package com.hotmail.zckerkman;

public class ExtremeTicTacToeMain {

	public static void main(String [] args) {
		MasterBoard masterBoard = new MasterBoard();
		masterBoard.makeBoards();
		
		Board board1 = new Board();
		board1.setWinner(State.X);
		masterBoard.setBoard(0, board1);
		
		Board board2 = new Board();
		board2.setWinner(State.X);
		masterBoard.setBoard(4, board1);
		
		Board board3 = new Board();
		board3.setWinner(State.X);
		masterBoard.setBoard(8, board1);
		
		masterBoard.checkForWinner();
		
		System.out.print(masterBoard.getWinner().toString());
	}
	
}
