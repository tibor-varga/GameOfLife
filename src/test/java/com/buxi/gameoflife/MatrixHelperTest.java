package com.buxi.gameoflife;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.buxi.gameoflife.model.Coordinate;

public class MatrixHelperTest {

	@Test
	public void testGenerateNeighbourCoordinates() {

		List<Coordinate> coords = MatrixHelper.generateNeighbourCoordinates(0, 0);
		assertNotNull(coords);
		assertEquals(8, coords.size());
		assertTrue(coords.contains(new Coordinate(-1, -1)));
		assertTrue(coords.contains(new Coordinate(-1, 0)));
		assertTrue(coords.contains(new Coordinate(-1, 1)));
		assertTrue(coords.contains(new Coordinate(0, -1)));
		assertTrue(coords.contains(new Coordinate(0, 1)));
		assertTrue(coords.contains(new Coordinate(1, -1)));
		assertTrue(coords.contains(new Coordinate(1, 0)));
		assertTrue(coords.contains(new Coordinate(1, 1)));
	}

	@Test
	public void testRemoveInvalidCoordinates0_0() {

		List<Coordinate> coords = MatrixHelper.generateNeighbourCoordinates(0, 0);
		assertNotNull(coords);
		List<Coordinate> validCoords = MatrixHelper.removeInvalidCoordinates(coords, 10, 10);

		assertEquals(3, validCoords.size());
		assertTrue(validCoords.contains(new Coordinate(0, 1)));
		assertTrue(validCoords.contains(new Coordinate(1, 0)));
		assertTrue(validCoords.contains(new Coordinate(1, 1)));
	}

	@Test
	public void testRemoveInvalidCoordinates0_max() {

		List<Coordinate> coords = MatrixHelper.generateNeighbourCoordinates(0, 9);
		assertNotNull(coords);
		List<Coordinate> validCoords = MatrixHelper.removeInvalidCoordinates(coords, 10, 10);

		assertEquals(3, validCoords.size());
		assertTrue(validCoords.contains(new Coordinate(0, 8)));
		assertTrue(validCoords.contains(new Coordinate(1, 9)));
		assertTrue(validCoords.contains(new Coordinate(1, 8)));
	}

	@Test
	public void testRemoveInvalidCoordinatesmax_max() {

		List<Coordinate> coords = MatrixHelper.generateNeighbourCoordinates(9, 9);
		assertNotNull(coords);
		List<Coordinate> validCoords = MatrixHelper.removeInvalidCoordinates(coords, 10, 10);

		assertEquals(3, validCoords.size());
		assertTrue(validCoords.contains(new Coordinate(8, 8)));
		assertTrue(validCoords.contains(new Coordinate(8, 9)));
		assertTrue(validCoords.contains(new Coordinate(9, 8)));
	}

	@Test
	public void testRemoveInvalidCoordinatesmax_0() {

		List<Coordinate> coords = MatrixHelper.generateNeighbourCoordinates(9, 0);
		assertNotNull(coords);
		List<Coordinate> validCoords = MatrixHelper.removeInvalidCoordinates(coords, 10, 10);

		assertEquals(3, validCoords.size());
		assertTrue(validCoords.contains(new Coordinate(8, 0)));
		assertTrue(validCoords.contains(new Coordinate(9, 1)));
		assertTrue(validCoords.contains(new Coordinate(8, 1)));
	}

	@Test
	public void testRemoveInvalidCoordinates5_5() {

		List<Coordinate> coords = MatrixHelper.generateNeighbourCoordinates(5, 5);
		assertNotNull(coords);
		List<Coordinate> validCoords = MatrixHelper.removeInvalidCoordinates(coords, 10, 10);

		assertEquals(8, validCoords.size());
		assertTrue(coords.contains(new Coordinate(4, 4)));
		assertTrue(coords.contains(new Coordinate(4, 5)));
		assertTrue(coords.contains(new Coordinate(4, 6)));
		assertTrue(coords.contains(new Coordinate(5, 4)));
		assertTrue(coords.contains(new Coordinate(5, 6)));
		assertTrue(coords.contains(new Coordinate(6, 4)));
		assertTrue(coords.contains(new Coordinate(6, 5)));
		assertTrue(coords.contains(new Coordinate(6, 6)));

	}

	@Test
	public void testGetNeighbours() {

		byte[][] matrix = new byte[3][3];

		/**
		 * //@formatter:off 
		 *  100
		 *  0?0 
		 *  000 
		 *  //@formatter:on
		 */

		matrix[0][0] = 1;
		int liveNeighboursCount = MatrixHelper.getLiveNeighboursCount(1, 1, matrix);
		assertEquals(1, liveNeighboursCount);

		/**
		 * //@formatter:off 
		 *  110
		 *  0?0 
		 *  000 
		 *  //@formatter:on
		 */
		matrix[0][1] = 1;
		liveNeighboursCount = MatrixHelper.getLiveNeighboursCount(1, 1, matrix);
		assertEquals(2, liveNeighboursCount);

		/**
		 * //@formatter:off 
		 *  110
		 *  000 
		 *  00? 
		 *  //@formatter:on
		 */
		liveNeighboursCount = MatrixHelper.getLiveNeighboursCount(2, 2, matrix);
		assertEquals(0, liveNeighboursCount);
		/**
		 * //@formatter:off 
		 *  110
		 *  00?
		 *  000 
		 *  //@formatter:on
		 */
		liveNeighboursCount = MatrixHelper.getLiveNeighboursCount(1, 2, matrix);
		assertEquals(1, liveNeighboursCount);

		/**
		 * //@formatter:off 
		 *  11?
		 *  000
		 *  000 
		 *  //@formatter:on
		 */
		liveNeighboursCount = MatrixHelper.getLiveNeighboursCount(0, 2, matrix);
		assertEquals(1, liveNeighboursCount);
	}

	@Test
	public void testGetNewCellValue() {
		// rule1
		assertEquals(0, MatrixHelper.getNewCellValue((byte) 1, 0));
		assertEquals(0, MatrixHelper.getNewCellValue((byte) 1, 1));

		// rule2
		assertEquals(1, MatrixHelper.getNewCellValue((byte) 1, 2));
		assertEquals(1, MatrixHelper.getNewCellValue((byte) 1, 3));

		// rule3
		assertEquals(0, MatrixHelper.getNewCellValue((byte) 1, 4));
		assertEquals(0, MatrixHelper.getNewCellValue((byte) 1, 5));
		assertEquals(0, MatrixHelper.getNewCellValue((byte) 1, 6));
		assertEquals(0, MatrixHelper.getNewCellValue((byte) 1, 7));
		assertEquals(0, MatrixHelper.getNewCellValue((byte) 1, 8));

		// rule4
		assertEquals(0, MatrixHelper.getNewCellValue((byte) 0, 0));
		assertEquals(0, MatrixHelper.getNewCellValue((byte) 0, 1));
		assertEquals(0, MatrixHelper.getNewCellValue((byte) 0, 2));
		assertEquals(1, MatrixHelper.getNewCellValue((byte) 0, 3));
		assertEquals(0, MatrixHelper.getNewCellValue((byte) 0, 4));
		assertEquals(0, MatrixHelper.getNewCellValue((byte) 0, 5));
		assertEquals(0, MatrixHelper.getNewCellValue((byte) 0, 6));
		assertEquals(0, MatrixHelper.getNewCellValue((byte) 0, 7));
		assertEquals(0, MatrixHelper.getNewCellValue((byte) 0, 8));

	}

}
