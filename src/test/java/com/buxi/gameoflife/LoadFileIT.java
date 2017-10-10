package com.buxi.gameoflife;

import java.net.URISyntaxException;

import org.junit.Test;

import com.buxi.gameoflife.model.Coordinate;
import com.buxi.gameoflife.model.Matrix;

public class LoadFileIT {

	@Test
	public void testMatrixConstructor() throws URISyntaxException {
		Matrix m = new Matrix(10, 10);
		MatrixHelper.loadPatternIntoMatrix(m, "acorn.dat", new Coordinate(1, 1));

		System.out.println(m);
	}

}
