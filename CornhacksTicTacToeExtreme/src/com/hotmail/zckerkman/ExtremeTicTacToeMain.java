package com.hotmail.zckerkman;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExtremeTicTacToeMain {

	public static void main(String[] args) {

		// Creates master board.
		MasterBoard mb = new MasterBoard();
		mb.setBoardValues(0, 0, State.X);

		// Creates an array of the box states in String form.
		String[][] nestedStringArray = new String[9][9];

		// Iterates through all boards in the master board.
		Board[] boards = mb.getBoards();
		for (int i = 0; i < boards.length; i++) {
			ArrayList<String> stringArrayList = new ArrayList<String>();

			// Iterates through the states of each board in the master board.
			State[] boxes = boards[i].getBoxes();
			for (int j = 0; j < boxes.length; j++) {
				stringArrayList.add(State.convertToString(boxes[j]));
			}

			// Adds a boards states represented as Strings to the array of the states of all
			// of the boards in the master board.
			String[] stringArray = new String[9];
			for (int j = 0; j < stringArrayList.size(); j++) {
				stringArray[j] = stringArrayList.get(j);
			}

			nestedStringArray[i] = stringArray;
		}

		// Creates master board GUI from saved values.
		MasterBoardGUI masterBoardGui = new MasterBoardGUI(nestedStringArray);
		JPanel panel = masterBoardGui.iterateThroughBoardValues();

		// Handles GUI creation.
		JFrame frame = new JFrame("Extreme Tic-Tac-Toe!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(900, 900);
		frame.add(panel);
		frame.setVisible(true);
	}
}
