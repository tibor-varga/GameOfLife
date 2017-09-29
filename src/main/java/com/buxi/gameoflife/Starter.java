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
		// MatrixHelper.initWithAcorn(matrix,"acorn.dat", new Coordinate(100, 100));
		// MatrixHelper.initWithDieHard(matrix,"diehard.dat", new Coordinate(100, 100));
		// MatrixHelper.initWithRPentomino(matrix,"r-pentomino.dat", new Coordinate(100,
		// 100));
		// MatrixHelper.initWithPattern(matrix, "pentadecathlon.dat", new
		// Coordinate(100, 100));
		// MatrixHelper.initWithPattern(matrix, "gun1.dat", new Coordinate(100, 100));
		// MatrixHelper.initWithPattern(matrix, "first_gun.dat", new Coordinate(100,
		// 100));
		// MatrixHelper.initWithPattern(matrix, "endup_in_pulsar.dat", new
		// Coordinate(100, 100));
		MatrixHelper.initWithPattern(matrix, "interessant.dat", new Coordinate(100, 100));
		Screen frame = new Screen(5, 5, matrix);
		frame.setSize(1700, 700);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
