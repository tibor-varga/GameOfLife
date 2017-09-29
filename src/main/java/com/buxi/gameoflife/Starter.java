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

		Matrix matrix = new Matrix(200, 100);
		MatrixHelper.initMatrix(matrix);

		Screen frame = new Screen(5, 5, matrix);
		frame.setSize(1700, 700);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
