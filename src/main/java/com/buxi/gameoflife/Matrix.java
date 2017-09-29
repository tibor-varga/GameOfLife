/**
 * 
 */
package com.buxi.gameoflife;

/**
 * @author buxi
 *
 */
public class Matrix {
	private int matrixSizeX;
	private int matrixSizeY;

	private int matrix[][];

	public Matrix(int matrixSizeX, int matrixSizeY) {
		super();
		this.matrixSizeX = matrixSizeX;
		this.matrixSizeY = matrixSizeY;
		matrix = new int[matrixSizeX][matrixSizeY];
	}

	public int getMatrixSizeX() {
		return matrixSizeX;
	}

	public void setMatrixSizeX(int matrixSizeX) {
		this.matrixSizeX = matrixSizeX;
	}

	public int getMatrixSizeY() {
		return matrixSizeY;
	}

	public void setMatrixSizeY(int matrixSizeY) {
		this.matrixSizeY = matrixSizeY;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

}
