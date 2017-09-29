/**
 * 
 */
package com.buxi.gameoflife;

import javax.swing.WindowConstants;

/**
 * @author buxi
 *
 */
public class Starter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Matrix matrix = new Matrix(100, 100);
		MatrixHelper.initMatrix(matrix);

		Screen frame = new Screen(5, 5, matrix);
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
