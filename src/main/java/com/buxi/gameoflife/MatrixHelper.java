package com.buxi.gameoflife;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatrixHelper {

	static void initMatrix(Matrix matrix) {
		Random rand = new Random();
		for (int i = 0; i < matrix.getMatrixSizeX(); i++) {
			for (int j = 0; j < matrix.getMatrixSizeY(); j++) {
				matrix.getMatrix()[i][j] = (byte) rand.nextInt(2);
			}
		}

	}

	/**
	 * @param x
	 *            coordinate in matrix, 0 based
	 * @param y
	 *            coordinate in matrix, 0 based
	 * @param matrix
	 * @return count of live neigbours
	 */
	static int getLiveNeighboursCount(int x, int y, byte[][] matrix) {
		/*
		 * All neighbours, but not all are valid
		 * 
		 * x-1, y-1
		 * 
		 * x-1, y
		 * 
		 * x-1, y+1
		 * 
		 * x, y-1
		 * 
		 * x, y+1
		 * 
		 * x+1, y-1
		 * 
		 * x+1, y
		 * 
		 * x+1, y-1
		 */
		List<Coordinate> coordinates = generateNeighbourCoordinates(x, y);
		List<Coordinate> validCoords = removeInvalidCoordinates(coordinates, matrix.length, matrix[0].length);
		int count = 0;
		for (Coordinate coordinate : validCoords) {
			if (matrix[coordinate.x][coordinate.y] == 1) {
				count++;
			}
		}
		return count;

	}

	public static List<Coordinate> removeInvalidCoordinates(List<Coordinate> coordinates, int maxX, int maxY) {
		List<Coordinate> result = new ArrayList<>();
		for (Coordinate coordinate : coordinates) {
			if (coordinate.x < 0 || coordinate.x == maxX || coordinate.y < 0 || coordinate.y == maxY) {
				continue;
			}
			result.add(coordinate);
		}
		return result;
	}

	public static List<Coordinate> generateNeighbourCoordinates(int x, int y) {
		List<Coordinate> result = new ArrayList<>();
		result.add(new Coordinate(x - 1, y - 1));
		result.add(new Coordinate(x - 1, y));
		result.add(new Coordinate(x - 1, y + 1));
		result.add(new Coordinate(x, y - 1));
		result.add(new Coordinate(x, y + 1));
		result.add(new Coordinate(x + 1, y - 1));
		result.add(new Coordinate(x + 1, y));
		result.add(new Coordinate(x + 1, y + 1));
		return result;
	}

	/**
	 * 1. Any live cell with fewer than two live neighbours dies, as if caused by
	 * underpopulation.
	 * 
	 * 2. Any live cell with two or three live neighbours lives on to the next
	 * generation.
	 * 
	 * 3. Any live cell with more than three live neighbours dies, as if by
	 * overpopulation.
	 * 
	 * 4. Any dead cell with exactly three live neighbours becomes a live cell, as
	 * if by reproduction.
	 * 
	 * @param matrix
	 *            input matrix to apply rules
	 * @return matrix new matrix
	 */
	static Matrix recalculateMatrix(Matrix matrix) {
		byte[][] inputMatrix = matrix.getMatrix();
		byte[][] outputMatrix = new byte[matrix.getMatrixSizeX()][matrix.getMatrixSizeY()];

		for (int i = 0; i < matrix.getMatrixSizeX(); i++) {
			for (int j = 0; j < matrix.getMatrixSizeY(); j++) {
				int liveCount = MatrixHelper.getLiveNeighboursCount(i, j, matrix.getMatrix());
				outputMatrix[i][j] = getNewCellValue(inputMatrix[i][j], liveCount);

			}
		}

		return new Matrix(outputMatrix);
	}

	static byte getNewCellValue(byte oldValue, int liveCount) {
		// Rule1-3
		if (oldValue == 1) {
			if (liveCount == 2 || liveCount == 3) {
				// rule2
				return 1;
			} else {
				// rule1,3
				return 0;
			}

		} else {
			// rule4
			if (liveCount == 3) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
