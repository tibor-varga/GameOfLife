/**
 * 
 */
package com.buxi.gameoflife;

import java.util.Arrays;

/**
 * @author buxi
 *
 */
public class Matrix {
	private int matrixSizeX;
	private int matrixSizeY;

	private byte matrix[][];

	public Matrix(int matrixSizeX, int matrixSizeY) {
		super();
		this.matrixSizeX = matrixSizeX;
		this.matrixSizeY = matrixSizeY;
		matrix = new byte[matrixSizeX][matrixSizeY];
	}

	public Matrix(byte[][] matrix) {
		this.matrixSizeX = matrix.length;
		this.matrixSizeY = matrix[0].length;
		this.matrix = matrix;
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

	public byte[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(byte[][] matrix) {
		this.matrix = matrix;
	}

	@Override
	public String toString() {
		return "Matrix [matrixSizeX=" + matrixSizeX + ", matrixSizeY=" + matrixSizeY + ", matrix="
				+ Arrays.toString(matrix) + "]";

	}

}
