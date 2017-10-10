package com.buxi.gameoflife;

import java.net.URISyntaxException;

import com.buxi.gameoflife.model.Coordinate;
import com.buxi.gameoflife.model.Matrix;

public class MatrixInitializerFactory {

	public static Matrix createInitMatrix(int matrixSizeX, int matrixSizeY, Coordinate defaultCoord, String scene)
			throws URISyntaxException {
		Matrix matrix = new Matrix(matrixSizeX, matrixSizeY);

		switch (scene) {
		case "random":
			MatrixHelper.initMatrixRandom(matrix);
			break;
		case "supernova":
			MatrixHelper.initWithPattern(matrix, "pentadecathlon.dat", new Coordinate(80, 90));
			MatrixHelper.initWithPattern(matrix, "gun2.dat", new Coordinate(33, 41));
			MatrixHelper.initWithPattern(matrix, "gun2.dat", new Coordinate(15, 10));
			MatrixHelper.initWithPattern(matrix, "gun3.dat", new Coordinate(185, 15));
			break;

		case "killPulsarWithFirework":
			MatrixHelper.initWithPattern(matrix, "pentadecathlon.dat", new Coordinate(80, 90));
			MatrixHelper.initWithPattern(matrix, "gun2.dat", new Coordinate(35, 45));
			break;

		default:
			// default initialization with filename=scene
			MatrixHelper.initWithPattern(matrix, scene, defaultCoord);
			break;
		}
		return matrix;

		// public static void killPulsar7(Matrix matrix) throws URISyntaxException {
		// MatrixHelper.initWithPattern(matrix, "pentadecathlon.dat", new Coordinate(80,
		// 90));
		// MatrixHelper.initWithPattern(matrix, "gun2.dat", new Coordinate(35, 55));
		// }
		//
		// public static void explodePulsar6(Matrix matrix) throws URISyntaxException {
		// MatrixHelper.initWithPattern(matrix, "pentadecathlon.dat", new Coordinate(80,
		// 90));
		// MatrixHelper.initWithPattern(matrix, "gun2.dat", new Coordinate(40, 55));
		// }
		//
		// public static void killPulsar5(Matrix matrix) throws URISyntaxException {
		// MatrixHelper.initWithPattern(matrix, "pentadecathlon.dat", new Coordinate(80,
		// 90));
		// MatrixHelper.initWithPattern(matrix, "gun2.dat", new Coordinate(50, 65));
		// }
		//
		// public static void killPulsar4(Matrix matrix) throws URISyntaxException {
		// MatrixHelper.initWithPattern(matrix, "pentadecathlon.dat", new Coordinate(80,
		// 90));
		// MatrixHelper.initWithPattern(matrix, "gun2.dat", new Coordinate(60, 85));
		// }
		//
		// public static void killPulsar2(Matrix matrix) throws URISyntaxException {
		// MatrixHelper.initWithPattern(matrix, "pentadecathlon.dat", new Coordinate(80,
		// 90));
		// MatrixHelper.initWithPattern(matrix, "gun2.dat", new Coordinate(70, 90));
		// }
		//
		// public static void killPulsar3(Matrix matrix) throws URISyntaxException {
		// MatrixHelper.initWithPattern(matrix, "pentadecathlon.dat", new Coordinate(80,
		// 90));
		// MatrixHelper.initWithPattern(matrix, "gun2.dat", new Coordinate(70, 85));
		// }

	}
}
