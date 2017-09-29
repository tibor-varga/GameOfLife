package com.buxi.gameoflife;

import java.util.Random;

public class MatrixHelper {

	static void initMatrix(Matrix matrix) {
		Random rand = new Random();
		for (int i = 0; i < matrix.getMatrixSizeX(); i++) {
			for (int j = 0; j < matrix.getMatrixSizeY(); j++) {
				matrix.getMatrix()[i][j] = rand.nextInt(2);
			}
		}

	}

	static Matrix recalculateMatrix(Matrix matrix) {
		return matrix;
	}
}
