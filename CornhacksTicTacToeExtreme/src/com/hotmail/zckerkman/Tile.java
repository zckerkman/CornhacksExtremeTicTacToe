package com.hotmail.zckerkman;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Models a tile.
 * 
 * @author AntonioLinhart, LukeAVanDrie, PLM13 
 */
public class Tile extends JPanel {
	/**
	 * The tile's ID.
	 */
	private int tileID;
	/**
	 * The total number of created tiles.
	 */
	private static int tileCount = 0;
	/**
	 * The visual representation of the tile's state.
	 */
	private JLabel tileText;
	/**
	 * The last tile ID chosen.
	 */
	private static int lastTileID = 4;

	public Tile(String text) {
		// Converts total number of tiles to relative position on a board.
		this.tileID = tileCount++ % 9;

		this.tileText = new JLabel(text);
		tileText.setFont(new Font("Helvetica", Font.PLAIN, 60));

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		this.add(tileText);
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				MasterBoard mb = ExtremeTicTacToeMain.mb;
				State turnState = ExtremeTicTacToeMain.turnState;

				BoardGUI boardGUI = (BoardGUI) Tile.this.getParent();

				// Ensures that the next playable board corresponds to the last
				// played tile.
				if (boardGUI.getBoardID() == lastTileID) {
					// Ensures that only empty tiles can be played.
					if (Tile.this.tileText.getText().equals(State.convertToString(State.EMPTY))) {

						// Converts the tile's text to the user's state.
						Tile.this.tileText.setText(State.convertToString(turnState));

						// Converts the tile's state to the user's state.
						mb.setBoardValues(boardGUI.getBoardID(), Tile.this.getTileID(), turnState);

						// Resets the last board's tile backgrounds.
						Tile[] pastTiles = boardGUI.tiles;
						for (int i = 0; i < pastTiles.length; i++) {
							pastTiles[i].setBackground(Color.WHITE);
						}

						// Sets the next board's tile backgrounds to a playable color indicator.
						BoardGUI nextBoardGUI = MasterBoardGUI.boards[Tile.this.getTileID()];
						Tile[] tiles = nextBoardGUI.tiles;
						for (int i = 0; i < tiles.length; i++) {
							tiles[i].setBackground(Color.GREEN);
						}

						// Converts the BoardGUI to a Board.
						Board board = mb.getBoard(boardGUI.getBoardID());
						
						// Determines if the board has been won by the user.
						board.checkForWinner(turnState);
						if (board.getWinner().equals(turnState)) {
							
							// Determines if the master board has been won by the user.
							mb.checkForWinner(turnState);
							if (mb.getWinner().equals(turnState)) {
								
								// Alerts user that they have won and exits program.
								JOptionPane.showMessageDialog(ExtremeTicTacToeMain.frame,
										"Congratulations! Player " + turnState + " has won the game!");
								System.exit(0);
							}
						}

						// Swaps the turn state.
						if (turnState.equals(State.X)) {
							ExtremeTicTacToeMain.turnState = State.O;
						} else if (turnState.equals(State.O)) {
							ExtremeTicTacToeMain.turnState = State.X;
						}

						// Updates the last played tile ID.
						lastTileID = Tile.this.getTileID();
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
	}

	/**
	 * Gets the tile ID.
	 * 
	 * @return tileID
	 */
	public int getTileID() {
		return tileID;
	}
}