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

		Matrix matrix = new Matrix(10, 10);
		MatrixHelper.initMatrix(matrix);

		Screen frame = new Screen(10, 10, matrix);
		frame.setSize(200, 300);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
