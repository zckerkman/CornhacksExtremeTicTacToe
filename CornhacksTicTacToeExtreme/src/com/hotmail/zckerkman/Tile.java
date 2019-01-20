package com.hotmail.zckerkman;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tile extends JPanel{
	/**
	 * The id of a tile.
	 */
	private int tileID;
	/**
	 * The static count of the tile to set an id.
	 */
	private static int tileCount = 0;
	/**
	 * String of the current value.
	 */
	private String text;
	
	/**
	 * The panel for the tile.
	 */
	private JPanel panel;
	
	/**
	 * Tile constructor.
	 */
	public Tile(String text) {
		this.text = text;
		this.tileID = tileCount++;
		this.panel = new JPanel();
		JLabel panelText = new JLabel(text);
		panelText.setFont(new Font("Helvetica", Font.PLAIN, 60));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(panelText);
	}
	
	/**
	 * Gets the tile ID.
	 * @return tileID
	 */
	public int getTileID() {
		return tileID;
	}
	
	/**
	 * Gets the text for tile
	 * @return String text of tile
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Sets the text for tile
	 * @param text String text to set button
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Gets the JPanel
	 * @return panel
	 */
	public JPanel getPanel() {
		return panel;
	}
	
	
}
