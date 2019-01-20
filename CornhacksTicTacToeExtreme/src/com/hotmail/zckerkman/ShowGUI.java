package com.hotmail.zckerkman;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShowGUI {

	public static void main(String[] args) {
		
		
		
		
		// Creates master board and puts the values from the board backend into a list
		// of strings representing X, O, or an empty value.
		MasterBoard mb = new MasterBoard();
		//mb.setBoardValues(0, 0, State.X);
		ArrayList<String[]> nestedStringArrayList = new ArrayList<String[]>();
		for (Board board : mb.getBoards()) {
			ArrayList<String> stringArrayList = new ArrayList<String>();
			for (State state : board.getBoxes()) {
				State.convertToString(state);
			}
			String[] stringArray = (String[]) stringArrayList.toArray();
			nestedStringArrayList.add(stringArray);
		}
		String[][] nestedStringArray = (String[][]) nestedStringArrayList.toArray();
		MasterBoardGUI masterBoardGui = new MasterBoardGUI(nestedStringArray);

		
	}
}
