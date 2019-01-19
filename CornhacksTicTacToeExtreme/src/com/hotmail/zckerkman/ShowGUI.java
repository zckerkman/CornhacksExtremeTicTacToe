package com.hotmail.zckerkman;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShowGUI {
	static BufferedImage canvas;
	final static float strokeWidth = 4f;

	public static void main(String[] args) {
		
		String[] strings = {"X","X","X","O","X","O","O","O","X"};
		String[][] stringArray = new String[9][];
		for (int i = 0; i < 9; i++) {
			stringArray[i] = strings;
		}
		
		MasterBoardGUI masterBoardGui = new MasterBoardGUI(stringArray);
		/**
		MasterBoard mb = new MasterBoard();
		mb.setBoardValues(0, 0, State.X);
		ArrayList<String[]> strings = new ArrayList<String[]>();
		for(Board board: mb.getBoards()) {
			for(State state: board.getBoxes()) {
				State.convertToString(state);
			}
		}
		*/
		
		
		JFrame frame = new JFrame("Extreme");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 900);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = masterBoardGui.iterateThroughBoardValues();
		
		frame.add(panel);
		
		frame.setVisible(true);
	}
	
	/**
	 * Draws a grid.
	 * 
	 * @param sideLength the length of each rectangle
	 * @param c          the desired color for the grid
	 */
	public void drawGrid(int sideLength, Color c) {
		int width = 900;
		int height = 900;
		// Generates the vertical lines
		for (int i = 1; i < width; i++) {
			drawLine(sideLength * i, 0, sideLength * i, sideLength * height, c);
		}
		
		// Generates the horizontal lines
		for (int i = 1; i < height; i++) {
			drawLine(0, sideLength * i, sideLength * width, sideLength * i, c);
		}
	}
	
	/**
	 * Draws a line.
	 * Function sourced from Stephanie Valentine, Assistant Professor of Practice, UNL.
	 * 
	 * @param x1 the x coordinate of the first point
	 * @param y1 the y coordinate of the first point
	 * @param x2 the x coordinate of the second point
	 * @param y2 the y coordinate of the second point
	 * @param c  the desired color for the line
	 */
	public void drawLine(double x1, double y1, double x2, double y2, Color c) {
		Graphics2D g2d = (Graphics2D) canvas.getGraphics();
		g2d.setColor(c);

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Stroke stroke = new BasicStroke(strokeWidth);
		g2d.setStroke(stroke);

		Line2D.Double line = new Line2D.Double(x1, y1, x2, y2);
		g2d.draw(line);
	}
}
