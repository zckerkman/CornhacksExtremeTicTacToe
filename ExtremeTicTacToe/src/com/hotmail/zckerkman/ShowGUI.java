package com.hotmail.zckerkman;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShowGUI {
	BufferedImage canvas;
	final static float strokeWidth = 4f;

	public static void main(String[] args) {
		String[] strings = {"a","b","c","d","e","f","g","h","i"};
		BoardGUI boardGui = new BoardGUI(strings);
		
		JFrame frame = new JFrame("Extreme");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 900);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = boardGui.iterateThroughBoardValues();
		
		frame.add(panel);
		
		frame.setVisible(true);
	}
	
	
	/**
	 * Draws a line.
	 * Function from Stephanie Valentine, Assistant Professor of Practice, UNL.
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
