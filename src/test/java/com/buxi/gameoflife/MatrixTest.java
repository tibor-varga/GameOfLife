package com.buxi.gameoflife;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatrixTest {

	@Test
	public void testMatrixConstructor() {
		Matrix matrix = new Matrix(3, 2);

		Matrix matrix2 = new Matrix(matrix.getMatrix());
		assertEquals(matrix.getMatrixSizeX(), matrix2.getMatrixSizeX());
		assertEquals(matrix.getMatrixSizeY(), matrix2.getMatrixSizeY());

	}

}
