/**
 * 
 */
package com.buxi.gameoflife;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.RenderingHints;
import java.net.URISyntaxException;

import javax.swing.JFrame;

/**
 * @author buxi
 *
 */
public class Screen extends JFrame {
	private int pixelSizeX;
	private int pixelSizeY;
	private Matrix matrix;

	public Screen(int pixelSizeX, int pixelSizeY, Matrix matrix) throws HeadlessException {
		super();
		this.pixelSizeX = pixelSizeX;
		this.pixelSizeY = pixelSizeY;
		this.matrix = matrix;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		int i = 0;
		while (true) {
			showMatrix(graphics);

			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i++);
			matrix = MatrixHelper.recalculateMatrix(matrix);
		}
	}

	public void showRectXY(int x, int y, Graphics2D graphics) {
		graphics.setPaint(new Color(150, 150, 150));
		graphics.fillRect(x * pixelSizeX, y * pixelSizeY, pixelSizeX, pixelSizeY);
	}

	public void hideRectXY(int x, int y, Graphics2D graphics) {
		graphics.setPaint(new Color(0, 0, 0));
		graphics.fillRect(x * pixelSizeX, y * pixelSizeY, pixelSizeX, pixelSizeY);
	}

	public void showMatrix(Graphics2D graphics) {
		for (int i = 0; i < matrix.getMatrixSizeX(); i++) {
			for (int j = 0; j < matrix.getMatrixSizeY(); j++) {
				if (matrix.getMatrix()[i][j] == 0) {
					hideRectXY(i, j, graphics);
				} else {
					showRectXY(i, j, graphics);
				}
			}
		}

	}

	public void initWithPattern(String initPattern, int initPattenCoordX, int initPattenCoordY)
			throws URISyntaxException {
		MatrixHelper.initWithPattern(matrix, initPattern, new Coordinate(initPattenCoordX, initPattenCoordY));
	}
}
