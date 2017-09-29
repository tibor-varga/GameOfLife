/**
 * 
 */
package com.buxi.gameoflife;

import java.net.URISyntaxException;

import javax.swing.WindowConstants;

/**
 * @author buxi
 *
 */
public class Starter {

	/**
	 * @param args
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws URISyntaxException {

		Matrix matrix = new Matrix(200, 200);
		// MatrixHelper.initMatrixRandom(matrix);
		// MatrixHelper.initWithAcorn(matrix,"acorn.dat");
		// MatrixHelper.initWithDieHard(matrix,"diehard.dat");
		// MatrixHelper.initWithRPentomino(matrix,"r-pentomino.dat");
		MatrixHelper.initWithPattern(matrix, "pentadecathlon.dat");
		Screen frame = new Screen(5, 5, matrix);
		frame.setSize(1700, 700);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
